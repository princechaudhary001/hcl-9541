import { Link, useLocation } from 'react-router-dom'

function Navbar() {
  const location = useLocation()

  const links = [
    { path: '/', label: 'Home' },
    { path: '/dashboard', label: 'Dashboard' },
    { path: '/attendance', label: 'Attendance' },
    { path: '/register', label: 'Register' },
    { path: '/students', label: 'Employees' },
    { path: '/login', label: 'Login' },
  ]

  return (
    <nav className="navbar navbar-expand navbar-light bg-light border-bottom px-3 mb-3">
      <div className="container-fluid">
        <Link className="navbar-brand fw-bold text-primary" to="/dashboard">
          HRMS Portal
        </Link>
        <ul className="navbar-nav me-auto mb-2 mb-lg-0 gap-1">
          {links.map((link) => {
            const isActive = location.pathname === link.path
            return (
              <li key={link.path} className="nav-item">
                <Link
                  className={`nav-link px-3 ${isActive ? 'active fw-semibold text-primary' : ''}`}
                  to={link.path}
                >
                  {link.label}
                </Link>
              </li>
            )
          })}
        </ul>
      </div>
    </nav>
  )
}

export default Navbar
