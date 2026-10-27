import { useState } from 'react'
import axios from 'axios'

const emptyForm = {
  empId: '',
  name: '',
  email: '',
  designation: '',
  techStack: '',
  password: '',
  agree: false,
}

function Registration() {
  const [form, setForm] = useState(emptyForm)
  const [message, setMessage] = useState('')

  function handleChange(e) {
    const { name, value, type, checked } = e.target
    setForm({ ...form, [name]: type === 'checkbox' ? checked : value })
  }

  async function handleSubmit(e) {
    e.preventDefault()

    if (!form.agree) {
      setMessage('Please tick the confirmation checkbox')
      return
    }

    const employee = {
      empCode: form.empId,
      name: form.name,
      email: form.email,
      designation: form.designation,
      techStack: form.techStack,
      password: form.password,
    }

    try {
      const response = await axios.post('http://localhost:8080/addEmp', employee)
      console.log('Saved:', response.data)
      setMessage('Employee ' + response.data.name + ' registered successfully')
      setForm(emptyForm)
    } catch (error) {
      console.error(error)
      setMessage('Registration failed. Is the backend running?')
    }
  }

  return (
    <div className="container py-4">
      <div className="row justify-content-center">
        <div className="col-12 col-md-10 col-lg-8">
          <div className="card shadow-sm">
            <div className="card-body p-4">
              <h3 className="mb-4">Employee Registration</h3>

              <form onSubmit={handleSubmit}>
                <div className="row g-3">
                  <div className="col-12 col-md-6">
                    <label htmlFor="empId" className="form-label">Employee ID</label>
                    <input type="number" id="empId" name="empId" className="form-control"
                      placeholder="Enter employee id" value={form.empId}
                      onChange={handleChange} required />
                  </div>

                  <div className="col-12 col-md-6">
                    <label htmlFor="name" className="form-label">Name</label>
                    <input type="text" id="name" name="name" className="form-control"
                      placeholder="Enter name" value={form.name}
                      onChange={handleChange} required />
                  </div>

                  <div className="col-12 col-md-6">
                    <label htmlFor="email" className="form-label">Email address</label>
                    <input type="email" id="email" name="email" className="form-control"
                      placeholder="Enter email" value={form.email}
                      onChange={handleChange} required />
                    <div className="form-text">We'll never share your email with anyone else.</div>
                  </div>

                  <div className="col-12 col-md-6">
                    <label htmlFor="designation" className="form-label">Designation</label>
                    <input type="text" id="designation" name="designation" className="form-control"
                      placeholder="Enter designation" value={form.designation}
                      onChange={handleChange} required />
                  </div>

                  <div className="col-12 col-md-6">
                    <label htmlFor="techStack" className="form-label">Tech Stack</label>
                    <input type="text" id="techStack" name="techStack" className="form-control"
                      placeholder="e.g. Java FSD, Test Engineer" value={form.techStack}
                      onChange={handleChange} required />
                  </div>

                  <div className="col-12 col-md-6">
                    <label htmlFor="password" className="form-label">Password</label>
                    <input type="password" id="password" name="password" className="form-control"
                      placeholder="Password" value={form.password}
                      onChange={handleChange} required />
                  </div>

                  <div className="col-12">
                    <div className="form-check">
                      <input type="checkbox" id="agree" name="agree" className="form-check-input"
                        checked={form.agree} onChange={handleChange} />
                      <label htmlFor="agree" className="form-check-label">
                        I confirm the details are correct
                      </label>
                    </div>
                  </div>

                  <div className="col-12 d-grid d-sm-block">
                    <button type="submit" className="btn btn-primary px-4">Submit</button>
                  </div>
                </div>
              </form>

              {message && <div className="alert alert-info mt-3 mb-0">{message}</div>}
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Registration