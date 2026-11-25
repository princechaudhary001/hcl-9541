import { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import axios from 'axios'

const API_BASE = 'http://localhost:8080/attendance'

function Attendance() {
  const navigate = useNavigate()

  // Default to Employee ID 6 and Prince, or retrieve from localStorage if present
  const [employeeId, setEmployeeId] = useState(() => {
    return localStorage.getItem('empId') || '6'
  })
  const [employeeName, setEmployeeName] = useState(() => {
    return localStorage.getItem('empName') || 'Prince'
  })

  const [todayAttendance, setTodayAttendance] = useState(null)
  const [history, setHistory] = useState([])
  const [loading, setLoading] = useState(false)
  const [alertInfo, setAlertInfo] = useState({ show: false, message: '', type: '' })

  const todayStr = new Date().toISOString().slice(0, 10)

  // Format date-time exactly like: 10/28/2026, 12:31:32 PM
  function formatDateTime(val) {
    if (!val) return '-'
    const d = new Date(val)
    if (isNaN(d.getTime())) return val
    return d.toLocaleString('en-US', {
      month: '2-digit',
      day: '2-digit',
      year: 'numeric',
      hour: 'numeric',
      minute: '2-digit',
      second: '2-digit',
      hour12: true,
    })
  }

  function showAlert(message, type = 'info') {
    setAlertInfo({ show: true, message, type })
    setTimeout(() => {
      setAlertInfo({ show: false, message: '', type: '' })
    }, 4000)
  }

  async function fetchTodayAttendance(empId) {
    try {
      const res = await axios.get(`${API_BASE}/today/${empId}`)
      setTodayAttendance(res.data || null)
    } catch (err) {
      console.warn('Could not fetch today attendance:', err.response?.data || err.message)
      setTodayAttendance(null)
    }
  }

  async function fetchAttendanceHistory(empId) {
    try {
      const res = await axios.get(`${API_BASE}/history/${empId}`)
      setHistory(Array.isArray(res.data) ? res.data : [])
    } catch (err) {
      console.warn('Could not fetch attendance history:', err.response?.data || err.message)
      setHistory([])
    }
  }

  async function loadData(empId) {
    setLoading(true)
    await Promise.all([fetchTodayAttendance(empId), fetchAttendanceHistory(empId)])
    setLoading(false)
  }

  useEffect(() => {
    loadData(employeeId)
  }, [employeeId])

  async function handleCheckIn() {
    try {
      const res = await axios.post(`${API_BASE}/check-in/${employeeId}`)
      showAlert('Check-in successful!', 'success')
      setTodayAttendance(res.data)
      fetchAttendanceHistory(employeeId)
    } catch (err) {
      const msg = err.response?.data?.message || 'Check-in failed. Please ensure the backend is running.'
      showAlert(msg, 'danger')
    }
  }

  async function handleCheckOut() {
    try {
      const res = await axios.post(`${API_BASE}/check-out/${employeeId}`)
      showAlert('Check-out successful!', 'success')
      setTodayAttendance(res.data)
      fetchAttendanceHistory(employeeId)
    } catch (err) {
      const msg = err.response?.data?.message || 'Check-out failed. Please ensure the backend is running.'
      showAlert(msg, 'danger')
    }
  }

  function handleRefresh() {
    loadData(employeeId)
    showAlert('Attendance refreshed', 'info')
  }

  // Determine current display status
  let displayStatus = 'Not Checked In'
  let checkInDisplay = '-'
  let checkOutDisplay = '-'

  if (todayAttendance) {
    checkInDisplay = formatDateTime(todayAttendance.inTime)
    checkOutDisplay = formatDateTime(todayAttendance.outTime)

    if (todayAttendance.outTime) {
      displayStatus = 'Checked out'
    } else if (todayAttendance.inTime) {
      displayStatus = 'Checked in'
    }
  }

  const isCheckedIn = !!(todayAttendance && todayAttendance.inTime && !todayAttendance.outTime)
  const isCheckedOut = !!(todayAttendance && todayAttendance.outTime)

  return (
    <div className="container py-4" style={{ maxWidth: '980px' }}>
      {/* Top Header */}
      <div className="d-flex justify-content-between align-items-start mb-4">
        <div>
          <h2
            style={{
              color: '#d0d4dc',
              fontWeight: 500,
              fontSize: '1.75rem',
              letterSpacing: '-0.2px',
              margin: 0,
            }}
          >
            Attendance Management
          </h2>
          <div
            style={{
              color: '#495057',
              fontSize: '1rem',
              marginTop: '4px',
              fontWeight: 400,
            }}
          >
            Welcome, {employeeName}
          </div>
        </div>
        <button
          onClick={() => navigate('/dashboard')}
          className="btn"
          style={{
            backgroundColor: '#ffffff',
            border: '1px solid #ced4da',
            color: '#495057',
            padding: '7px 18px',
            borderRadius: '6px',
            fontSize: '0.95rem',
          }}
        >
          Back to Dashboard
        </button>
      </div>

      {alertInfo.show && (
        <div className={`alert alert-${alertInfo.type} alert-dismissible fade show`} role="alert">
          {alertInfo.message}
          <button
            type="button"
            className="btn-close"
            onClick={() => setAlertInfo({ show: false, message: '', type: '' })}
          ></button>
        </div>
      )}

      {/* Card 1: Today's Attendance */}
      <div
        className="card mb-4"
        style={{
          border: '1px solid #dee2e6',
          borderRadius: '8px',
          boxShadow: 'none',
        }}
      >
        <div className="card-body p-4">
          <h4
            className="text-center mb-3"
            style={{
              fontWeight: 600,
              fontSize: '1.25rem',
              color: '#212529',
            }}
          >
            Today's Attendance
          </h4>

          <div
            className="text-center mb-4"
            style={{
              lineHeight: '1.7',
              fontSize: '0.95rem',
              color: '#212529',
            }}
          >
            <div>
              <strong>Employee ID:</strong> {employeeId}
            </div>
            <div>
              <strong>Date:</strong> {todayAttendance?.attendancedate || todayStr}
            </div>
            <div>
              <strong>Status:</strong> {displayStatus}
            </div>
            <div>
              <strong>Check-in:</strong> {checkInDisplay}
            </div>
            <div>
              <strong>Check-out:</strong> {checkOutDisplay}
            </div>
          </div>

          {/* Action buttons */}
          <div className="d-flex align-items-center gap-2">
            <button
              onClick={handleCheckIn}
              disabled={loading || isCheckedIn || isCheckedOut}
              className="btn"
              style={{
                backgroundColor: '#52a885',
                color: '#ffffff',
                border: 'none',
                padding: '6px 18px',
                borderRadius: '6px',
                fontWeight: 500,
                cursor: isCheckedIn || isCheckedOut ? 'not-allowed' : 'pointer',
                opacity: isCheckedIn || isCheckedOut ? 0.6 : 1,
              }}
            >
              Check In
            </button>

            <button
              onClick={handleCheckOut}
              disabled={loading || !isCheckedIn || isCheckedOut}
              className="btn"
              style={{
                backgroundColor: '#e37777',
                color: '#ffffff',
                border: 'none',
                padding: '6px 18px',
                borderRadius: '6px',
                fontWeight: 500,
                cursor: !isCheckedIn || isCheckedOut ? 'not-allowed' : 'pointer',
                opacity: !isCheckedIn || isCheckedOut ? 0.6 : 1,
              }}
            >
              Check Out
            </button>

            <button
              onClick={handleRefresh}
              disabled={loading}
              className="btn"
              style={{
                backgroundColor: '#ffffff',
                color: '#2b7a9e',
                border: '1px solid #2b7a9e',
                padding: '6px 16px',
                borderRadius: '6px',
                fontWeight: 500,
              }}
            >
              Refresh History
            </button>
          </div>
        </div>
      </div>

      {/* Card 2: Attendance History */}
      <div
        className="card"
        style={{
          border: '1px solid #dee2e6',
          borderRadius: '8px',
          boxShadow: 'none',
        }}
      >
        <div className="card-body p-4">
          <h4
            className="text-center mb-4"
            style={{
              fontWeight: 600,
              fontSize: '1.25rem',
              color: '#212529',
            }}
          >
            Attendance History
          </h4>

          <div className="table-responsive">
            <table
              className="table table-bordered mb-0"
              style={{
                borderColor: '#dee2e6',
                verticalAlign: 'middle',
              }}
            >
              <thead>
                <tr style={{ backgroundColor: '#ffffff' }}>
                  <th className="text-center py-2" style={{ fontWeight: 600, width: '18%' }}>
                    Attendance ID
                  </th>
                  <th className="text-center py-2" style={{ fontWeight: 600, width: '18%' }}>
                    Date
                  </th>
                  <th className="text-center py-2" style={{ fontWeight: 600, width: '24%' }}>
                    Check-in
                  </th>
                  <th className="text-center py-2" style={{ fontWeight: 600, width: '24%' }}>
                    Check-out
                  </th>
                  <th className="text-center py-2" style={{ fontWeight: 600, width: '16%' }}>
                    Status
                  </th>
                </tr>
              </thead>
              <tbody>
                {history.length > 0 ? (
                  history.map((item) => (
                    <tr key={item.attendanceId}>
                      <td className="text-center py-2">{item.attendanceId}</td>
                      <td className="text-center py-2">{item.attendancedate}</td>
                      <td className="text-center py-2">{formatDateTime(item.inTime)}</td>
                      <td className="text-center py-2">{formatDateTime(item.outTime)}</td>
                      <td className="text-center py-2">
                        {item.status || (item.outTime ? 'Completed' : 'Checked In')}
                      </td>
                    </tr>
                  ))
                ) : (
                  <tr>
                    <td colSpan="5" className="text-center text-muted py-4">
                      {loading ? 'Loading attendance history...' : 'No attendance records found'}
                    </td>
                  </tr>
                )}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Attendance
