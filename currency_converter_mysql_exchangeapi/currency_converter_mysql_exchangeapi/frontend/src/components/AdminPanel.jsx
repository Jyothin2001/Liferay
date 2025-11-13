import React, { useState, useEffect } from 'react'
import { adminLogin, adminGetConversions } from '../api' // use separated admin endpoints
import './AdminPanel.css';


export default function AdminPanel() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [token, setToken] = useState(localStorage.getItem('admin_token') || '')
  const [logs, setLogs] = useState([])

  // Admin login function
  const login = async () => {
    try {
      const res = await adminLogin(email, password) // calls /admin/login
      setToken(res.data.access_token)
      localStorage.setItem('admin_token', res.data.access_token)
      alert('Logged in successfully')
    } catch (e) {
      alert(e.response?.data?.detail || e.message)
    }
  }

  // Fetch conversions for admin
  const fetchLogs = async () => {
    if (!token) return
    try {
      const res = await adminGetConversions(token) // calls /admin/conversions
      setLogs(res.data)
    } catch (e) {
      alert(e.response?.data?.detail || e.message)
    }
  }

  // Automatically fetch logs after login or token changes
  useEffect(() => {
    if (token) {
      fetchLogs()
    }
  }, [token])

  return (
    <div className="card">
      {!token ? (
        <div className="login-container">
          <h3>Admin Login</h3>
          <label>Email</label>
          <input value={email} onChange={e => setEmail(e.target.value)} />
          <label>Password</label>
          <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
          <div className="login-button">
            <button onClick={login}>Login</button>
          </div>
        </div>
      ) : (
        <div className="dashboard-container">
          <div className="dashboard-header">
            <button
              className="logout-btn"
              onClick={() => {
                setToken('');
                localStorage.removeItem('admin_token');
                setLogs([]);
              }}
            >
              Logout
            </button>
            <h3>Latest Conversions</h3>
          </div>
          <div className="table-wrapper">
            <table className="admin-table">
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
                {logs.map((l, idx) => (
                  <tr key={l.id}>
                    <td>{idx + 1}</td>
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
          </div>
        </div>
      )}
    </div>
  );
}



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




// import React, {useState} from 'react'
// import axios from 'axios'

// export default function AdminPanel(){
//   const [email, setEmail] = useState('')
//   const [password, setPassword] = useState('')
//   const [token, setToken] = useState(localStorage.getItem('admin_token') || '')
//   const [logs, setLogs] = useState([])

//   const login = async () => {
//     try{
//       const res = await axios.post('http://localhost:8000/auth/login', { email, password })
//       setToken(res.data.access_token)
//       localStorage.setItem('admin_token', res.data.access_token)
//       alert('Logged in')
//     }catch(e){
//       alert(e.response?.data?.detail || e.message)
//     }
//   }

//   const fetchLogs = async () => {
//     try{
//       const res = await axios.get('http://localhost:8000/admin/conversions', { headers: { Authorization: 'Bearer ' + token } })
//       setLogs(res.data)
//     }catch(e){
//       alert(e.response?.data?.detail || e.message)
//     }
//   }

//   return (
//     <div className="card" style={{marginTop:12}}>
//       {!token ? (
//         <div>
//           <h3>Admin Login</h3>
//           <label className="small">Email</label>
//           <input value={email} onChange={e=>setEmail(e.target.value)} />
//           <label className="small">Password</label>
//           <input type="password" value={password} onChange={e=>setPassword(e.target.value)} />
//           <div style={{marginTop:8}}>
//             <button onClick={login}>Login</button>
//           </div>
//         </div>
//       ) : (
//         <div>
//           <div style={{display:'flex', gap:8}}>
//             <button onClick={fetchLogs}>Fetch Logs</button>
//             <button onClick={()=>{ setToken(''); localStorage.removeItem('admin_token'); setLogs([]) }}>Logout</button>
//           </div>
//           <div style={{marginTop:12}}>
//             <h4>Latest conversions</h4>
//             <table className="table">
//               <thead><tr><th>#</th><th>Time</th><th>From</th><th>To</th><th>Amount</th><th>Result</th><th>Rate</th></tr></thead>
//               <tbody>
//                 {logs.map((l, idx)=>(
//                   <tr key={l.id}>
//                     <td>{idx+1}</td>
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
