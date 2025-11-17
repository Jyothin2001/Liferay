import React, { useState, useEffect } from 'react'
import axios from 'axios'
import './AdminPanel.css'

export default function AdminPanel() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [token, setToken] = useState(localStorage.getItem('admin_token') || '')
  const [logs, setLogs] = useState([])

  /* ⭐ ADDED — Pagination states */
  const [currentPage, setCurrentPage] = useState(1)
  const rowsPerPage = 5

  /* ⭐ ADDED — Pagination calculations */
  const indexOfLastRow = currentPage * rowsPerPage
  const indexOfFirstRow = indexOfLastRow - rowsPerPage
  const currentRows = logs.slice(indexOfFirstRow, indexOfLastRow)
  const totalPages = Math.ceil(logs.length / rowsPerPage)

  const login = async () => {
    try {
      const res = await axios.post('http://localhost:8000/admin/login', { email, password })
      setToken(res.data.access_token)
      localStorage.setItem('admin_token', res.data.access_token)
      alert('Logged in')
    } catch (e) {
      alert(e.response?.data?.detail || e.message)
    }
  }

  const fetchLogs = async () => {
    try {
      const res = await axios.get('http://localhost:8000/admin/conversions', {
        headers: { Authorization: 'Bearer ' + token }
      })
      setLogs(res.data)

      /* ⭐ ADDED — Reset to page 1 when logs load */
      setCurrentPage(1)
    } catch (e) {
      alert(e.response?.data?.detail || e.message)
    }
  }

  useEffect(() => {
    if (token) fetchLogs()
  }, [token])

  return (
    <div className="admin-wrapper">

      {/* -------------------- LOGIN VIEW -------------------- */}
      {!token ? (
        <div className="admin-login-box">
          <h2>Admin Login</h2>

          <label>Email</label>
          <input
            value={email}
            onChange={e => setEmail(e.target.value)}
            placeholder="Enter email"
          />

          <label>Password</label>
          <input
            type="password"
            value={password}
            onChange={e => setPassword(e.target.value)}
            placeholder="Enter password"
          />

          <button className="admin-btn" onClick={login}>Login</button>
        </div>
      ) : (
        /* -------------------- ADMIN TABLE VIEW -------------------- */
        <div className="admin-panel">

          {/* Header Row with Title + Logout */}
          <div className="admin-header-row">
            <h2 className="admin-header-title">Conversion Logs</h2>

            <button
              className="logout-btn"
              onClick={() => {
                setToken('')
                localStorage.removeItem('admin_token')
                setLogs([])
              }}
            >
              Logout
            </button>
          </div>

          {/* Table */}
          <div className="table-wrapper">
            <table className="conversion-table">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Time</th>
                  <th>From</th>
                  <th>To</th>
                  <th>Amount</th>
                  <th>Result</th>
                  <th>Rate</th>
                </tr>
              </thead>

              <tbody>
                {/* ⭐ CHANGED — Using paginated rows */}
                {currentRows.map((l, idx) => (
                  <tr key={l.id}>
                    <td>{indexOfFirstRow + idx + 1}</td>
                    <td>{new Date(l.timestamp).toLocaleString()}</td>
                    <td>{l.from_currency}</td>
                    <td>{l.to_currency}</td>
                    <td>{l.amount}</td>
                    <td>{l.result}</td>
                    <td>{l.rate}</td>
                  </tr>
                ))}
              </tbody>
            </table>

            {/* ⭐ ADDED — Pagination UI */}
            <div className="pagination">
              <button
                disabled={currentPage === 1}
                onClick={() => setCurrentPage(currentPage - 1)}
              >
                Previous
              </button>

              {[...Array(totalPages)].map((_, i) => (
                <button
                  key={i}
                  className={currentPage === i + 1 ? "active-page" : ""}
                  onClick={() => setCurrentPage(i + 1)}
                >
                  {i + 1}
                </button>
              ))}

              <button
                disabled={currentPage === totalPages}
                onClick={() => setCurrentPage(currentPage + 1)}
              >
                Next
              </button>
            </div>
          </div>

        </div>
      )}

    </div>
  )
}



// import React, { useState, useEffect } from 'react'
// import axios from 'axios'
// import './AdminPanel.css'

// export default function AdminPanel() {
//   const [email, setEmail] = useState('')
//   const [password, setPassword] = useState('')
//   const [token, setToken] = useState(localStorage.getItem('admin_token') || '')
//   const [logs, setLogs] = useState([])

//   const login = async () => {
//     try {
//       const res = await axios.post('http://localhost:8000/admin/login', { email, password })
//       setToken(res.data.access_token)
//       localStorage.setItem('admin_token', res.data.access_token)
//       alert('Logged in')
//     } catch (e) {
//       alert(e.response?.data?.detail || e.message)
//     }
//   }

//   const fetchLogs = async () => {
//     try {
//       const res = await axios.get('http://localhost:8000/admin/conversions', {
//         headers: { Authorization: 'Bearer ' + token }
//       })
//       setLogs(res.data)
//     } catch (e) {
//       alert(e.response?.data?.detail || e.message)
//     }
//   }

//   useEffect(() => {
//     if (token) fetchLogs()
//   }, [token])

//   return (
//     <div className="admin-wrapper">

//       {/* -------------------- LOGIN VIEW -------------------- */}
//       {!token ? (
//         <div className="admin-login-box">
//           <h2>Admin Login</h2>

//           <label>Email</label>
//           <input
//             value={email}
//             onChange={e => setEmail(e.target.value)}
//             placeholder="Enter email"
//           />

//           <label>Password</label>
//           <input
//             type="password"
//             value={password}
//             onChange={e => setPassword(e.target.value)}
//             placeholder="Enter password"
//           />

//           <button className="admin-btn" onClick={login}>Login</button>
//         </div>
//       ) : (
//         /* -------------------- ADMIN TABLE VIEW -------------------- */
//         <div className="admin-panel">

//           {/* Header Row with Title + Logout */}
//           <div className="admin-header-row">
//             <h2 className="admin-header-title">Conversion Logs</h2>

//             <button
//               className="logout-btn"
//               onClick={() => {
//                 setToken('')
//                 localStorage.removeItem('admin_token')
//                 setLogs([])
//               }}
//             >
//               Logout
//             </button>
//           </div>

//           {/* Table */}
//           <div className="table-wrapper">
//             <table className="conversion-table">
//               <thead>
//                 <tr>
//                   <th>#</th>
//                   <th>Time</th>
//                   <th>From</th>
//                   <th>To</th>
//                   <th>Amount</th>
//                   <th>Result</th>
//                   <th>Rate</th>
//                 </tr>
//               </thead>

//               <tbody>
//                 {logs.map((l, idx) => (
//                   <tr key={l.id}>
//                     <td>{idx + 1}</td>
//                     <td>{new Date(l.timestamp).toLocaleString()}</td>
//                     <td>{l.from_currency}</td>
//                     <td>{l.to_currency}</td>
//                     <td>{l.amount}</td>
//                     <td>{l.result}</td>
//                     <td>{l.rate}</td>
//                   </tr>
//                 ))}
//               </tbody>

//             </table>
//           </div>

//         </div>
//       )}

//     </div>
//   )
// }


// import React, { useState, useEffect } from 'react'
// import axios from 'axios'

// export default function AdminPanel() {
//   const [email, setEmail] = useState('')
//   const [password, setPassword] = useState('')
//   const [token, setToken] = useState(localStorage.getItem('admin_token') || '')
//   const [logs, setLogs] = useState([])

//   const login = async () => {
//     try {
//       const res = await axios.post('http://localhost:8000/admin/login', { email, password })
//       setToken(res.data.access_token)
//       localStorage.setItem('admin_token', res.data.access_token)
//       alert('Logged in')
//     } catch (e) {
//       alert(e.response?.data?.detail || e.message)
//     }
//   }

//   const fetchLogs = async () => {
//     try {
//       const res = await axios.get('http://localhost:8000/admin/conversions', {
//         headers: { Authorization: 'Bearer ' + token }
//       })
//       setLogs(res.data)
//     } catch (e) {
//       alert(e.response?.data?.detail || e.message)
//     }
//   }

//   // ✅ Automatically fetch logs after login or when token changes
//   useEffect(() => {
//     if (token) {
//       fetchLogs()
//     }
//   }, [token])

//   return (
//     <div className="card" style={{ marginTop: 12 }}>
//       {!token ? (
//         <div>
//           <h3>Admin Login</h3>
//           <label className="small">Email</label>
//           <input value={email} onChange={e => setEmail(e.target.value)} />
//           <label className="small">Password</label>
//           <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
//           <div style={{ marginTop: 8 }}>
//             <button onClick={login}>Login</button>
//           </div>
//         </div>
//       ) : (
//         <div>
//           <div style={{ display: 'flex', gap: 8 }}>
//             {/* <button onClick={fetchLogs}>Fetch Logs</button> */}
//             <button
//               onClick={() => {
//                 setToken('')
//                 localStorage.removeItem('admin_token')
//                 setLogs([])
//               }}
//             >
//               Logout
//             </button>
//           </div>
//           <div style={{ marginTop: 12 }}>
//             <h4>Latest conversions</h4>
//             <table className="table">
//               <thead>
//                 <tr>
//                   <th>#</th>
//                   <th>Time</th>
//                   <th>From</th>
//                   <th>To</th>
//                   <th>Amount</th>
//                   <th>Result</th>
//                   <th>Rate</th>
//                 </tr>
//               </thead>
//               <tbody>
//                 {logs.map((l, idx) => (
//                   <tr key={l.id}>
//                     <td>{idx + 1}</td>
//                     <td>{new Date(l.timestamp).toLocaleString()}</td>
//                     <td>{l.from_currency}</td>
//                     <td>{l.to_currency}</td>
//                     <td>{l.amount}</td>
//                     <td>{l.result}</td>
//                     <td>{l.rate}</td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>
//           </div>
//         </div>
//       )}
//     </div>
//   )
// }