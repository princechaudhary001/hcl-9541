import { Link } from 'react-router-dom'

function Navbar() {
  return (
    <nav style={{ display: 'flex', gap: '16px', padding: '12px', background: '#eee' }}>
      <Link to="/">Home</Link>
      <Link to="/login">Login</Link>
      <Link to="/dashboard">Dashboard</Link>
      <Link to="/students">Students</Link>
      <Link to="/attendance">Attendance</Link>
      <Link to="/register">Register</Link>
    </nav>
  )
}

export default Navbar