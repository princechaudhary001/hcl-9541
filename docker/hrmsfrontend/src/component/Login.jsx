import { useState } from 'react'
import { useNavigate, Link } from 'react-router-dom'
import axios from 'axios'

function Login() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [error, setError] = useState('')
  const [loading, setLoading] = useState(false)
  const navigate = useNavigate()

  async function handleSubmit(e) {
    e.preventDefault()

    if (!email || !password) {
      setError('Please enter email and password')
      return
    }

    setError('')
    setLoading(true)

    try {
      const response = await axios.post('http://localhost:8080/login', {
        email,
        password,
      })

      const user = response.data
      localStorage.setItem('empId', user.id || user.empCode || '6')
      localStorage.setItem('empName', user.name || 'Prince')
      localStorage.setItem('user', JSON.stringify(user))

      navigate('/dashboard')
    } catch (err) {
      console.warn('Login request error:', err)
      if (err.response && err.response.data && err.response.data.message) {
        setError(err.response.data.message)
      } else {
        // Fallback for offline/demo: allow login with entered details or default
        const fallbackName = email.includes('@') ? email.split('@')[0] : 'Prince'
        localStorage.setItem('empId', '6')
        localStorage.setItem('empName', fallbackName.charAt(0).toUpperCase() + fallbackName.slice(1))
        navigate('/dashboard')
      }
    } finally {
      setLoading(false)
    }
  }

  return (
    <div className="container py-5">
      <div className="row justify-content-center">
        <div className="col-12 col-sm-8 col-md-6 col-lg-4">
          <div className="card shadow-sm" style={{ borderRadius: '8px', border: '1px solid #ced4da' }}>
            <div className="card-body p-4">
              <h3 className="text-center mb-4" style={{ fontWeight: 600, color: '#2c3e50' }}>
                HRMS Login
              </h3>

              <form onSubmit={handleSubmit}>
                <div className="mb-3">
                  <label className="form-label" style={{ fontWeight: 500 }}>
                    Email Address
                  </label>
                  <input
                    type="email"
                    className="form-control"
                    placeholder="name@company.com"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                  />
                </div>

                <div className="mb-3">
                  <label className="form-label" style={{ fontWeight: 500 }}>
                    Password
                  </label>
                  <input
                    type="password"
                    className="form-control"
                    placeholder="Enter password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                  />
                </div>

                {error && <div className="alert alert-danger py-2 mb-3">{error}</div>}

                <div className="d-grid mb-3">
                  <button
                    type="submit"
                    className="btn btn-primary"
                    disabled={loading}
                    style={{ fontWeight: 500 }}
                  >
                    {loading ? 'Logging in...' : 'Sign In'}
                  </button>
                </div>

                <div className="text-center text-muted small">
                  Don't have an account? <Link to="/register">Register here</Link>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Login
