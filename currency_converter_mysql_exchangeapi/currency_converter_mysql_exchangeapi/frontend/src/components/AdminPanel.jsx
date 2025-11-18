import React, { useState, useEffect } from 'react';
import axios from 'axios';
import ReactCountryFlag from 'react-country-flag';
import './AdminPanel.css';
import AdminAnalytics from "./AdminAnalytics";

export default function AdminPanel({ token, setToken, onLogout }) {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [logs, setLogs] = useState([]);

  const [currentPage, setCurrentPage] = useState(1);
  const rowsPerPage = 5;

  // Filters
  const [filterFrom, setFilterFrom] = useState('');
  const [filterTo, setFilterTo] = useState('');
  const [filterStartDate, setFilterStartDate] = useState('');
  const [filterEndDate, setFilterEndDate] = useState('');
  const [minAmount, setMinAmount] = useState('');
  const [maxAmount, setMaxAmount] = useState('');

  const currencyCountryMap = {
    USD: "US", EUR: "EU", INR: "IN", GBP: "GB", JPY: "JP",
    AUD: "AU", CAD: "CA", CHF: "CH", CNY: "CN", SGD: "SG",
    NZD: "NZ", HKD: "HK", SEK: "SE", NOK: "NO", MXN: "MX",
    ZAR: "ZA", TRY: "TR", BRL: "BR", RUB: "RU", KRW: "KR",
    DKK: "DK", PLN: "PL", THB: "TH", IDR: "ID", MYR: "MY",
    PHP: "PH", VND: "VN", AED: "AE", PKR: "PK", LKR: "LK",
  };

  const getCountryCode = (code) => currencyCountryMap[code] || code.slice(0,2).toUpperCase();

  // Admin login
  const login = async () => {
    try {
      const res = await axios.post('http://localhost:8000/admin/login', { email, password });
      setToken(res.data.access_token);
      localStorage.setItem('admin_token', res.data.access_token);
      alert('Logged in');
    } catch (e) {
      alert(e.response?.data?.detail || e.message);
    }
  };

  // Fetch logs
  const fetchLogs = async () => {
    try {
      const res = await axios.get('http://localhost:8000/admin/conversions', {
        headers: { Authorization: 'Bearer ' + token }
      });
      setLogs(res.data);
      setCurrentPage(1);
    } catch (e) {
      alert(e.response?.data?.detail || e.message);
    }
  };

  const deleteLog = async (id) => {
    if (!window.confirm("Are you sure you want to delete this record?")) return;

    try {
      const adminToken = localStorage.getItem('admin_token'); // always use latest token
      await axios.delete(`http://localhost:8000/admin/delete_conversion/${id}`, {
        headers: { Authorization: `Bearer ${adminToken}` }
      });
      setLogs(prev => prev.filter(l => l.id !== id));
    } catch (err) {
      alert("Delete failed: " + (err.response?.data?.detail || err.message));
    }
  };

  useEffect(() => {
    if (token) fetchLogs();
  }, [token]);

  // Filtered logs
  const filteredLogs = logs.filter(log => {
    const logDate = new Date(log.timestamp).toISOString().split("T")[0];
    if (filterStartDate && logDate < filterStartDate) return false;
    if (filterEndDate && logDate > filterEndDate) return false;
    if (filterFrom && log.from_currency.toUpperCase() !== filterFrom.toUpperCase().trim()) return false;
    if (filterTo && log.to_currency.toUpperCase() !== filterTo.toUpperCase().trim()) return false;
    if (minAmount && Number(log.amount) < Number(minAmount)) return false;
    if (maxAmount && Number(log.amount) > Number(maxAmount)) return false;
    return true;
  });

  const indexOfLastRow = currentPage * rowsPerPage;
  const indexOfFirstRow = indexOfLastRow - rowsPerPage;
  const currentRows = filteredLogs.slice(indexOfFirstRow, indexOfLastRow);
  const totalPages = Math.ceil(filteredLogs.length / rowsPerPage);

  return (
    <div className="admin-wrapper">
      {!token ? (
        <div className="admin-login-box">
          <h2>Admin Sign In</h2>
          <input type="email" value={email} onChange={e => setEmail(e.target.value)} placeholder="Email" />
          <input type="password" value={password} onChange={e => setPassword(e.target.value)} placeholder="Password" />
          <button onClick={login}>Sign In</button>
          <div className="extra-info">
            <p>By signing in, you can manage all user conversions securely.</p>
          </div>
        </div>
      ) : (
        <>
          {/* Analytics Dashboard */}
          <AdminAnalytics token={token} />

          {/* Conversion Table */}
          <div className="admin-panel">
            <div className="admin-header-row">
              <h2 className="admin-header-title">Conversion Logs</h2>
              <button className="logout-btn" onClick={() => { setToken(''); localStorage.removeItem('admin_token'); setLogs([]); onLogout(); }}>
                Logout
              </button>
            </div>

            <div className="filters">
              <input type="text" placeholder="From currency" value={filterFrom} onChange={e => setFilterFrom(e.target.value)} />
              <input type="text" placeholder="To currency" value={filterTo} onChange={e => setFilterTo(e.target.value)} />
              <input type="date" value={filterStartDate} onChange={e => setFilterStartDate(e.target.value)} />
              <input type="date" value={filterEndDate} onChange={e => setFilterEndDate(e.target.value)} />
              <input type="number" placeholder="Min Amount" value={minAmount} onChange={e => setMinAmount(e.target.value)} />
              <input type="number" placeholder="Max Amount" value={maxAmount} onChange={e => setMaxAmount(e.target.value)} />
            </div>

            <div className="table-wrapper">
              <table className="conversion-table">
                <thead>
                  <tr>
                    <th>SL NO</th>
                    <th>Time</th>
                    <th>From</th>
                    <th>To</th>
                    <th>Amount</th>
                    <th>Result</th>
                    <th>Rate</th>
                    <th>Action</th>
                  </tr>
                </thead>
                <tbody>
                  {currentRows.map((l, idx) => (
                    <tr key={l.id}>
                      <td>{indexOfFirstRow + idx + 1}</td>
                      <td>{new Date(l.timestamp).toLocaleString()}</td>
                      <td><ReactCountryFlag countryCode={getCountryCode(l.from_currency)} svg style={{ width: '20px', marginRight: '5px' }} />{l.from_currency}</td>
                      <td><ReactCountryFlag countryCode={getCountryCode(l.to_currency)} svg style={{ width: '20px', marginRight: '5px' }} />{l.to_currency}</td>
                      <td>{l.amount}</td>
                      <td>{l.result}</td>
                      <td>{l.rate}</td>
                      <td><button onClick={() => deleteLog(l.id)} style={{ background: "none", border: "none", color: "red", fontSize: "16px", cursor: "pointer" }}>🗑Delete</button></td>
                    </tr>
                  ))}
                </tbody>
              </table>

              <div className="pagination">
                <button disabled={currentPage === 1} onClick={() => setCurrentPage(currentPage - 1)}>Previous</button>
                <span>Page {currentPage} / {totalPages}</span>
                <button disabled={currentPage === totalPages} onClick={() => setCurrentPage(currentPage + 1)}>Next</button>
              </div>
            </div>
          </div>
        </>
      )}
    </div>
  );
}




// import React, { useState, useEffect } from 'react';
// import axios from 'axios';
// import ReactCountryFlag from 'react-country-flag';
// import './AdminPanel.css';
// import AdminAnalytics from "./AdminAnalytics";

// export default function AdminPanel({ token, setToken, onLogout }) {
//   const [email, setEmail] = useState('');
//   const [password, setPassword] = useState('');
//   const [logs, setLogs] = useState([]);

//   const [currentPage, setCurrentPage] = useState(1);
//   const rowsPerPage = 5;

//   // Filters
//   const [filterFrom, setFilterFrom] = useState('');
//   const [filterTo, setFilterTo] = useState('');
//   const [filterStartDate, setFilterStartDate] = useState('');
//   const [filterEndDate, setFilterEndDate] = useState('');
//   const [minAmount, setMinAmount] = useState('');
//   const [maxAmount, setMaxAmount] = useState('');

//   const currencyCountryMap = {
//     USD: "US", EUR: "EU", INR: "IN", GBP: "GB", JPY: "JP",
//     AUD: "AU", CAD: "CA", CHF: "CH", CNY: "CN", SGD: "SG",
//     NZD: "NZ", HKD: "HK", SEK: "SE", NOK: "NO", MXN: "MX",
//     ZAR: "ZA", TRY: "TR", BRL: "BR", RUB: "RU", KRW: "KR",
//     DKK: "DK", PLN: "PL", THB: "TH", IDR: "ID", MYR: "MY",
//     PHP: "PH", VND: "VN", AED: "AE", PKR: "PK", LKR: "LK",
//   };

//   const getCountryCode = (code) => currencyCountryMap[code] || code.slice(0,2).toUpperCase();

//   // Admin login
//   const login = async () => {
//     try {
//       const res = await axios.post('http://localhost:8000/admin/login', { email, password });
//       setToken(res.data.access_token);
//       localStorage.setItem('admin_token', res.data.access_token);
//       alert('Logged in');
//     } catch (e) {
//       alert(e.response?.data?.detail || e.message);
//     }
//   };

//   // Fetch logs
//   const fetchLogs = async () => {
//     try {
//       const res = await axios.get('http://localhost:8000/admin/conversions', {
//         headers: { Authorization: 'Bearer ' + token }
//       });
//       setLogs(res.data);
//       setCurrentPage(1);
//     } catch (e) {
//       alert(e.response?.data?.detail || e.message);
//     }
//   };

//  const deleteLog = async (id) => {
//   if (!window.confirm("Are you sure you want to delete this record?")) return;

//   try {
//     const adminToken = localStorage.getItem('admin_token'); // always use latest token
//     await axios.delete(`http://localhost:8000/admin/delete_conversion/${id}`, {
//       headers: { Authorization: `Bearer ${adminToken}` }
//     });
//     setLogs(prev => prev.filter(l => l.id !== id)); // l comes from logs state
//   } catch (err) {
//     alert("Delete failed: " + (err.response?.data?.detail || err.message));
//   }
// };


//   useEffect(() => {
//     if (token) fetchLogs();
//   }, [token]);


//   // Filtered logs
//   const filteredLogs = logs.filter(log => {
//     const logDate = new Date(log.timestamp).toISOString().split("T")[0];
//     if (filterStartDate && logDate < filterStartDate) return false;
//     if (filterEndDate && logDate > filterEndDate) return false;
//     if (filterFrom && log.from_currency.toUpperCase() !== filterFrom.toUpperCase().trim()) return false;
//     if (filterTo && log.to_currency.toUpperCase() !== filterTo.toUpperCase().trim()) return false;
//     if (minAmount && Number(log.amount) < Number(minAmount)) return false;
//     if (maxAmount && Number(log.amount) > Number(maxAmount)) return false;
//     return true;
//   });

//   const indexOfLastRow = currentPage * rowsPerPage;
//   const indexOfFirstRow = indexOfLastRow - rowsPerPage;
//   const currentRows = filteredLogs.slice(indexOfFirstRow, indexOfLastRow);
//   const totalPages = Math.ceil(filteredLogs.length / rowsPerPage);

//   return (
//     <div className="admin-wrapper">
//       {!token ? (
//         <div className="admin-login-box">
//           <h2>Admin Sign In</h2>
//           <input type="email" value={email} onChange={e => setEmail(e.target.value)} placeholder="Email" />
//           <input type="password" value={password} onChange={e => setPassword(e.target.value)} placeholder="Password" />
//           <button onClick={login}>Sign In</button>
//           <div className="extra-info">
//             <p>By signing in, you can manage all user conversions securely.</p>
//           </div>
//         </div>
//       ) : (
//         <div className="admin-panel">
//           <div className="admin-header-row">
//             <h2 className="admin-header-title">Conversion Logs</h2>
//             <button className="logout-btn" onClick={() => { setToken(''); localStorage.removeItem('admin_token'); setLogs([]); onLogout(); }}>
//               Logout
//             </button>
//           </div>

//           <div className="filters">
//             <input type="text" placeholder="From currency" value={filterFrom} onChange={e => setFilterFrom(e.target.value)} />
//             <input type="text" placeholder="To currency" value={filterTo} onChange={e => setFilterTo(e.target.value)} />
//             <input type="date" value={filterStartDate} onChange={e => setFilterStartDate(e.target.value)} />
//             <input type="date" value={filterEndDate} onChange={e => setFilterEndDate(e.target.value)} />
//             <input type="number" placeholder="Min Amount" value={minAmount} onChange={e => setMinAmount(e.target.value)} />
//             <input type="number" placeholder="Max Amount" value={maxAmount} onChange={e => setMaxAmount(e.target.value)} />
//           </div>

//           <div className="table-wrapper">
//             <table className="conversion-table">
//               <thead>
//                 <tr>
//                   <th>SL NO</th>
//                   <th>Time</th>
//                   <th>From</th>
//                   <th>To</th>
//                   <th>Amount</th>
//                   <th>Result</th>
//                   <th>Rate</th>
//                   <th>Action</th>
//                 </tr>
//               </thead>
//               <tbody>
//                 {currentRows.map((l, idx) => <tr key={l.id}><td>{indexOfFirstRow + idx + 1}</td><td>{new Date(l.timestamp).toLocaleString()}</td><td><ReactCountryFlag countryCode={getCountryCode(l.from_currency)} svg style={{ width: '20px', marginRight: '5px' }} />{l.from_currency}</td><td><ReactCountryFlag countryCode={getCountryCode(l.to_currency)} svg style={{ width: '20px', marginRight: '5px' }} />{l.to_currency}</td><td>{l.amount}</td><td>{l.result}</td><td>{l.rate}</td><td><button onClick={() => deleteLog(l.id)} style={{ background: "none", border: "none", color: "red", fontSize: "16px", cursor: "pointer" }}>🗑Delete</button></td></tr>)}
//               </tbody>
//             </table>

//             <div className="pagination">
//               <button disabled={currentPage === 1} onClick={() => setCurrentPage(currentPage - 1)}>Previous</button>
//               <span>Page {currentPage} / {totalPages}</span>
//               <button disabled={currentPage === totalPages} onClick={() => setCurrentPage(currentPage + 1)}>Next</button>
//             </div>
//           </div>
//         </div>
//       )}
//     </div>
//   );
// }


// import React, { useState, useEffect } from 'react'
// import axios from 'axios'
// import ReactCountryFlag from 'react-country-flag'
// import './AdminPanel.css'

// export default function AdminPanel() {
//   const [email, setEmail] = useState('')
//   const [password, setPassword] = useState('')
//   const [token, setToken] = useState(localStorage.getItem('admin_token') || '')
//   const [logs, setLogs] = useState([])

//   const [currentPage, setCurrentPage] = useState(1)
//   const rowsPerPage = 5

//   /* ---------------- Filters ---------------- */    
//   const [filterFrom, setFilterFrom] = useState('')
//   const [filterTo, setFilterTo] = useState('')
//   const [filterStartDate, setFilterStartDate] = useState('')
//   const [filterEndDate, setFilterEndDate] = useState('')
//   const [minAmount, setMinAmount] = useState('');
//   const [maxAmount, setMaxAmount] = useState('');

//   /* ---------------- DELETE LOGIC ---------------- */
//   const deleteLog = async (id) => {
//     if (!window.confirm("Are you sure you want to delete this record?")) return;

//     try {
//       await axios.delete(`http://localhost:8000/admin/delete_conversion/${id}`, {
//         headers: { Authorization: "Bearer " + token }
//       });

//       // Remove instantly from frontend
//       setLogs(prev => prev.filter(l => l.id !== id));
//     } catch (err) {
//       alert("Delete failed: " + err.response?.data?.detail || err.message);
//     }
//   };

  
//   /* ---------------- Filter logic ---------------- */
//   const filteredLogs = logs.filter(log => {
//     const logDate = new Date(log.timestamp).toISOString().split("T")[0];

//     if (filterStartDate && logDate < filterStartDate) return false;
//     if (filterEndDate && logDate > filterEndDate) return false;

//     if (filterFrom && log.from_currency.toUpperCase() !== filterFrom.toUpperCase().trim())
//       return false;

//     if (filterTo && log.to_currency.toUpperCase() !== filterTo.toUpperCase().trim())
//       return false;

//     if (minAmount && Number(log.amount) < Number(minAmount)) return false;
//     if (maxAmount && Number(log.amount) > Number(maxAmount)) return false;

//     return true;
//   });

//   /* ---------------- Pagination ---------------- */
//   const indexOfLastRow = currentPage * rowsPerPage
//   const indexOfFirstRow = indexOfLastRow - rowsPerPage
//   const currentRows = filteredLogs.slice(indexOfFirstRow, indexOfLastRow)
//   const totalPages = Math.ceil(filteredLogs.length / rowsPerPage)

//   const currencyCountryMap = {
//     USD: "US", EUR: "EU", INR: "IN", GBP: "GB", JPY: "JP",
//     AUD: "AU", CAD: "CA", CHF: "CH", CNY: "CN", SGD: "SG",
//     NZD: "NZ", HKD: "HK", SEK: "SE", NOK: "NO", MXN: "MX",
//     ZAR: "ZA", TRY: "TR", BRL: "BR", RUB: "RU", KRW: "KR",
//     DKK: "DK", PLN: "PL", THB: "TH", IDR: "ID", MYR: "MY",
//     PHP: "PH", VND: "VN", AED: "AE", PKR: "PK", LKR: "LK",
//   }

//   const getCountryCode = (code) => currencyCountryMap[code] || code.slice(0,2).toUpperCase()

//   const login = async () => {
//     try {
//       const res = await axios.post('http://localhost:8000/admin/login', {
//         email, password
//       });

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
//       setCurrentPage(1)
//     } catch (e) {
//       alert(e.response?.data?.detail || e.message)
//     }
//   }

//   useEffect(() => {
//     if (token) fetchLogs()
//   }, [token])

//   return (
//     <div className="admin-wrapper">

//       {!token ? (
//         <div className="admin-login-box">
//           <h2>Admin Sign In</h2>

//           <input type="email" value={email} onChange={e => setEmail(e.target.value)} placeholder="Email" />
//           <input type="password" value={password} onChange={e => setPassword(e.target.value)} placeholder="Password" />

//           <button onClick={login}>Sign In</button>

//           <div className="extra-info">
//             <p>By signing in, you can manage all user conversions securely.</p>
//           </div>
//         </div>

//       ) : (
//         <div className="admin-panel">

//           <div className="admin-header-row">
//             <h2 className="admin-header-title">Conversion Logs</h2>

//             <button className="logout-btn" onClick={() => {
//               setToken('')
//               localStorage.removeItem('admin_token')
//               setLogs([])
//             }}>
//               Logout
//             </button>
//           </div>

//           {/* ------- FILTER BAR ------- */}
//           <div className="filters">
//             <input type="text" placeholder="From currency" value={filterFrom} onChange={e => setFilterFrom(e.target.value)} />
//             <input type="text" placeholder="To currency" value={filterTo} onChange={e => setFilterTo(e.target.value)} />
//             <input type="date" value={filterStartDate} onChange={e => setFilterStartDate(e.target.value)} />
//             <input type="date" value={filterEndDate} onChange={e => setFilterEndDate(e.target.value)} />
//             <input type="number" placeholder="Min Amount" value={minAmount} onChange={e => setMinAmount(e.target.value)} />
//             <input type="number" placeholder="Max Amount" value={maxAmount} onChange={e => setMaxAmount(e.target.value)} />
//           </div>

//           {/* ------- TABLE ------- */}
//           <div className="table-wrapper">
//             <table className="conversion-table">
//               <thead>
//                 <tr>
//                   <th>SL NO</th>
//                   <th>Time</th>
//                   <th>From</th>
//                   <th>To</th>
//                   <th>Amount</th>
//                   <th>Result</th>
//                   <th>Rate</th>
//                   <th>Action</th> {/* NEW COLUMN */}
//                 </tr>
//               </thead>

//               <tbody>
//                 {currentRows.map((l, idx) => (
//                   <tr key={l.id}>
//                     <td>{indexOfFirstRow + idx + 1}</td>
//                     <td>{new Date(l.timestamp).toLocaleString()}</td>

//                     <td>
//                       <ReactCountryFlag countryCode={getCountryCode(l.from_currency)} svg style={{ width: '20px', marginRight: '5px' }} />
//                       {l.from_currency}
//                     </td>

//                     <td>
//                       <ReactCountryFlag countryCode={getCountryCode(l.to_currency)} svg style={{ width: '20px', marginRight: '5px' }} />
//                       {l.to_currency}
//                     </td>

//                     <td>{l.amount}</td>
//                     <td>{l.result}</td>
//                     <td>{l.rate}</td>

//                     <td>
//                       <button
//                         onClick={() => deleteLog(l.id)}
//                         style={{
//                           background: "none",
//                           border: "none",
//                           color: "red",
//                           fontSize: "18px",
//                           cursor: "pointer"
//                         }}
//                       >
//                         🗑Delete
//                       </button>
//                     </td>
//                   </tr>
//                 ))}
//               </tbody>
//             </table>

//             {/* ------- PAGINATION ------- */}
//             <div className="pagination">
//               <button disabled={currentPage === 1} onClick={() => setCurrentPage(currentPage - 1)}>Previous</button>
//               <span>Page {currentPage} / {totalPages}</span>
//               <button disabled={currentPage === totalPages} onClick={() => setCurrentPage(currentPage + 1)}>Next</button>
//             </div>

//           </div>

//         </div>
//       )}

//     </div>
//   )
// }


