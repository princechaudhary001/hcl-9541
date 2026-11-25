import { useState, useEffect } from 'react'
import { useNavigate, Link } from 'react-router-dom'

function Dashboard() {
  const navigate = useNavigate()
  const [employeeName, setEmployeeName] = useState('Prince')
  const [employeeId, setEmployeeId] = useState('6')

  useEffect(() => {
    const savedName = localStorage.getItem('empName')
    const savedId = localStorage.getItem('empId')
    if (savedName) setEmployeeName(savedName)
    if (savedId) setEmployeeId(savedId)
  }, [])

  function handleLogout() {
    localStorage.removeItem('empId')
    localStorage.removeItem('empName')
    localStorage.removeItem('user')
    navigate('/login')
  }

  const currentDate = new Date().toLocaleDateString('en-US', {
    weekday: 'long',
    year: 'numeric',
    month: 'long',
    day: 'numeric',
  })

  return (
    <div className="container py-4" style={{ maxWidth: '980px' }}>
      {/* Header Banner */}
      <div
        className="card mb-4"
        style={{
          border: '1px solid #dee2e6',
          borderRadius: '8px',
          backgroundColor: '#f8f9fa',
        }}
      >
        <div className="card-body p-4 d-flex justify-content-between align-items-center flex-wrap gap-3">
          <div>
            <h2 className="mb-1" style={{ fontWeight: 600, color: '#2c3e50' }}>
              Welcome back, {employeeName}
            </h2>
            <div className="text-muted" style={{ fontSize: '0.95rem' }}>
              HRMS Dashboard &bull; Employee ID: <strong>{employeeId}</strong> &bull; {currentDate}
            </div>
          </div>
          <div>
            <button
              onClick={handleLogout}
              className="btn btn-outline-danger"
              style={{ borderRadius: '6px', fontWeight: 500 }}
            >
              Sign Out
            </button>
          </div>
        </div>
      </div>

      {/* Feature Cards Grid */}
      <div className="row g-4">
        {/* Attendance Card */}
        <div className="col-12 col-md-6 col-lg-4">
          <div
            className="card h-100 shadow-sm"
            style={{
              border: '1px solid #dee2e6',
              borderRadius: '8px',
              transition: 'transform 0.15s ease-in-out',
            }}
          >
            <div className="card-body p-4 d-flex flex-column">
              <div className="mb-2">
                <span className="badge bg-success mb-2">Active</span>
                <h4 style={{ fontWeight: 600, color: '#2c3e50' }}>Attendance</h4>
              </div>
              <p className="text-muted flex-grow-1" style={{ fontSize: '0.92rem' }}>
                Check in, check out, track your daily work hours, and view historical attendance records.
              </p>
              <Link
                to="/attendance"
                className="btn btn-success mt-2"
                style={{ borderRadius: '6px', fontWeight: 500 }}
              >
                Go to Attendance &rarr;
              </Link>
            </div>
          </div>
        </div>

        {/* Employee Registration Card */}
        <div className="col-12 col-md-6 col-lg-4">
          <div
            className="card h-100 shadow-sm"
            style={{
              border: '1px solid #dee2e6',
              borderRadius: '8px',
            }}
          >
            <div className="card-body p-4 d-flex flex-column">
              <div className="mb-2">
                <span className="badge bg-primary mb-2">Onboarding</span>
                <h4 style={{ fontWeight: 600, color: '#2c3e50' }}>Registration</h4>
              </div>
              <p className="text-muted flex-grow-1" style={{ fontSize: '0.92rem' }}>
                Add new team members, manage designations, assign employee IDs, and set up system access.
              </p>
              <Link
                to="/register"
                className="btn btn-primary mt-2"
                style={{ borderRadius: '6px', fontWeight: 500 }}
              >
                Register Employee &rarr;
              </Link>
            </div>
          </div>
        </div>

        {/* Employee Directory Card */}
        <div className="col-12 col-md-6 col-lg-4">
          <div
            className="card h-100 shadow-sm"
            style={{
              border: '1px solid #dee2e6',
              borderRadius: '8px',
            }}
          >
            <div className="card-body p-4 d-flex flex-column">
              <div className="mb-2">
                <span className="badge bg-info text-dark mb-2">Directory</span>
                <h4 style={{ fontWeight: 600, color: '#2c3e50' }}>Employees</h4>
              </div>
              <p className="text-muted flex-grow-1" style={{ fontSize: '0.92rem' }}>
                Browse the employee directory, view team contact information, and examine active roles.
              </p>
              <Link
                to="/students"
                className="btn btn-outline-primary mt-2"
                style={{ borderRadius: '6px', fontWeight: 500 }}
              >
                View Directory &rarr;
              </Link>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Dashboard
