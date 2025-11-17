import React, { useState, useEffect } from 'react'
import axios from 'axios'
import ReactCountryFlag from 'react-country-flag'
import './AdminPanel.css'

export default function AdminPanel() {
  const [email, setEmail] = useState('')
  const [password, setPassword] = useState('')
  const [token, setToken] = useState(localStorage.getItem('admin_token') || '')
  const [logs, setLogs] = useState([])

  /* ⭐ Pagination states */
  const [currentPage, setCurrentPage] = useState(1)
  const rowsPerPage = 5

  /* ⭐ Pagination calculations */
  const indexOfLastRow = currentPage * rowsPerPage
  const indexOfFirstRow = indexOfLastRow - rowsPerPage
  const currentRows = logs.slice(indexOfFirstRow, indexOfLastRow)
  const totalPages = Math.ceil(logs.length / rowsPerPage)

  // Map currency to country code for flags
  const currencyCountryMap = {
    USD: "US", EUR: "EU", INR: "IN", GBP: "GB", JPY: "JP",
    AUD: "AU", CAD: "CA", CHF: "CH", CNY: "CN", SGD: "SG",
    NZD: "NZ", HKD: "HK", SEK: "SE", NOK: "NO", MXN: "MX",
    ZAR: "ZA", TRY: "TR", BRL: "BR", RUB: "RU", KRW: "KR",
    DKK: "DK", PLN: "PL", THB: "TH", IDR: "ID", MYR: "MY",
    PHP: "PH", VND: "VN", AED: "AE", PKR: "PK", LKR: "LK",
  }

  const getCountryCode = (code) => currencyCountryMap[code] || code.slice(0,2).toUpperCase()

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
      setCurrentPage(1) // reset to first page when new logs load
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
          <h2>Admin Sign In</h2>

          <input
            type="email"
            value={email}
            onChange={e => setEmail(e.target.value)}
            placeholder="Email"
          />

          <input
            type="password"
            value={password}
            onChange={e => setPassword(e.target.value)}
            placeholder="Password"
          />

          <button onClick={login}>Sign In</button>

          <div className="extra-info">
            <p>By signing in, you can manage all user conversions securely.</p>
          </div>
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
                {currentRows.map((l, idx) => (
                  <tr key={l.id}>
                    <td>{indexOfFirstRow + idx + 1}</td>
                    <td>{new Date(l.timestamp).toLocaleString()}</td>
                    <td>
                      <ReactCountryFlag
                        countryCode={getCountryCode(l.from_currency)}
                        svg
                        style={{ width: '20px', marginRight: '5px' }}
                      />
                      {l.from_currency}
                    </td>
                    <td>
                      <ReactCountryFlag
                        countryCode={getCountryCode(l.to_currency)}
                        svg
                        style={{ width: '20px', marginRight: '5px' }}
                      />
                      {l.to_currency}
                    </td>
                    <td>{l.amount}</td>
                    <td>{l.result}</td>
                    <td>{l.rate}</td>
                  </tr>
                ))}
              </tbody>
            </table>

            {/* ⭐ Pagination UI: Current / Total */}
            <div className="pagination">
              <button
                disabled={currentPage === 1}
                onClick={() => setCurrentPage(currentPage - 1)}
              >
                Previous
              </button>

              <span>Page {currentPage} / {totalPages}</span>

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

//   /* ⭐ Pagination states */
//   const [currentPage, setCurrentPage] = useState(1)
//   const rowsPerPage = 5

//   /* ⭐ Pagination calculations */
//   const indexOfLastRow = currentPage * rowsPerPage
//   const indexOfFirstRow = indexOfLastRow - rowsPerPage
//   const currentRows = logs.slice(indexOfFirstRow, indexOfLastRow)
//   const totalPages = Math.ceil(logs.length / rowsPerPage)

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
//       setCurrentPage(1) // reset to first page when new logs load
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
//                 {currentRows.map((l, idx) => (
//                   <tr key={l.id}>
//                     <td>{indexOfFirstRow + idx + 1}</td>
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

//             {/* ⭐ Pagination UI: Current / Total */}
//             <div className="pagination">
//               <button
//                 disabled={currentPage === 1}
//                 onClick={() => setCurrentPage(currentPage - 1)}
//               >
//                 Previous
//               </button>

//               <span>Page {currentPage} / {totalPages}</span>

//               <button
//                 disabled={currentPage === totalPages}
//                 onClick={() => setCurrentPage(currentPage + 1)}
//               >
//                 Next
//               </button>
//             </div>
//           </div>

//         </div>
//       )}

//     </div>
//   )
// }

