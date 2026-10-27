import { useEffect, useState } from 'react'

function Attendance() {
  const [students, setStudents] = useState([])
  const [attendance, setAttendance] = useState({})
  const [date, setDate] = useState(new Date().toISOString().slice(0, 10))
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    async function getStudents() {
      try {
        const response = await fetch('https://jsonplaceholder.typicode.com/users')
        const data = await response.json()
        setStudents(data)
      } catch (e) {
        console.error(e)
      } finally {
        setLoading(false)
      }
    }
    getStudents()
  }, [])

  function markAttendance(id, status) {
    setAttendance({ ...attendance, [id]: status })
  }

  function markAll(status) {
    const all = {}
    students.forEach((s) => {
      all[s.id] = status
    })
    setAttendance(all)
  }

  function handleSubmit() {
    const records = students.map((s) => ({
      studentId: s.id,
      date: date,
      status: attendance[s.id] || 'Absent',
    }))
    console.log('Attendance to send:', records)
    alert('Attendance saved (check console)')
    // Step 7: send this to Spring Boot.
  }

  if (loading) return <p>Loading...</p>

  return (
    <div>
      <h2>Mark Attendance</h2>

      <div style={{ marginBottom: '12px' }}>
        <label>Date: </label>
        <input type="date" value={date} onChange={(e) => setDate(e.target.value)} />
        <button onClick={() => markAll('Present')} style={{ marginLeft: '12px' }}>
          All Present
        </button>
        <button onClick={() => markAll('Absent')} style={{ marginLeft: '8px' }}>
          All Absent
        </button>
      </div>

      <table border="1" cellPadding="8" style={{ borderCollapse: 'collapse', width: '100%' }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Present</th>
            <th>Absent</th>
          </tr>
        </thead>
        <tbody>
          {students.map((s) => (
            <tr key={s.id}>
              <td>{s.id}</td>
              <td>{s.name}</td>
              <td>
                <input
                  type="radio"
                  name={'att-' + s.id}
                  checked={attendance[s.id] === 'Present'}
                  onChange={() => markAttendance(s.id, 'Present')}
                />
              </td>
              <td>
                <input
                  type="radio"
                  name={'att-' + s.id}
                  checked={attendance[s.id] === 'Absent'}
                  onChange={() => markAttendance(s.id, 'Absent')}
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      <p>
        Marked: {Object.keys(attendance).length} / {students.length}
      </p>
      <button onClick={handleSubmit} style={{ padding: '8px 16px' }}>
        Submit Attendance
      </button>
    </div>
  )
}

export default Attendance