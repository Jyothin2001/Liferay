import React, { useEffect, useState } from 'react';
import { clientConvert, clientGetConversions } from '../api'; // import client API functions
import HistoryChart from './HistoryChart';
import './Converter.css';

export default function Converter({ token, email }) {
  const [amount, setAmount] = useState(1);
  const [from, setFrom] = useState('USD');
  const [to, setTo] = useState('INR');
  const [result, setResult] = useState(null);
  const [loading, setLoading] = useState(false);
  const [currencies, setCurrencies] = useState({});
  const [error, setError] = useState(null);
  const [days, setDays] = useState(7);
  const [conversions, setConversions] = useState([]);

  // Load currencies and conversion history on mount
  useEffect(() => {
    fetchCurrencies();
    if (token) fetchConversions();
  }, [token]);

  // Fetch available currencies
  const fetchCurrencies = async () => {
    try {
      const res = await fetch('http://localhost:8000/currencies');
      const data = await res.json();
      if (data.success) setCurrencies(data.codes);
    } catch (e) {
      console.error("Error fetching currencies:", e);
    }
  };

  // Swap "from" and "to" currencies
  const swap = () => {
    const t = from;
    setFrom(to);
    setTo(t);
    setResult(null);
  };

  // Handle currency conversion
  const handleConvert = async () => {
    if (!token) return alert("Please login first!");
    setLoading(true);
    setError(null);
    try {
      const res = await clientConvert(token, from, to, parseFloat(amount));
      setResult(res.data);
      fetchConversions(); // update history
    } catch (e) {
      setError(e.response?.data?.detail || e.message);
    } finally {
      setLoading(false);
    }
  };

  // Fetch user's conversion history
  const fetchConversions = async () => {
    if (!token) return;
    try {
      const res = await clientGetConversions(token);
      setConversions(res.data);
    } catch (e) {
      console.error("Error fetching conversions:", e.response?.data || e.message);
    }
  };

  return (
    <div className="card" style={{ padding: 16, marginTop: 12 }}>
      <h2>Welcome, {email}</h2>

      <div style={{ display: 'flex', marginTop: 12, alignItems: 'center' }}>
        <input 
          type="number" 
          value={amount} 
          onChange={e => setAmount(e.target.value)} 
          style={{ width: 80, marginRight: 8 }}
        />
        <select value={from} onChange={e => setFrom(e.target.value)}>
          {Object.keys(currencies).map(c => (
            <option key={c} value={c}>{c} - {currencies[c]}</option>
          ))}
        </select>
        <select value={to} onChange={e => setTo(e.target.value)} style={{ marginLeft: 8 }}>
          {Object.keys(currencies).map(c => (
            <option key={c} value={c}>{c} - {currencies[c]}</option>
          ))}
        </select>
        <div style={{ display: 'flex', flexDirection: 'column', marginLeft: 8 }}>
          <button onClick={swap} style={{ marginBottom: 6 }}>Swap</button>
          <button onClick={handleConvert} disabled={loading}>
            {loading ? 'Converting...' : 'Convert'}
          </button>
        </div>
      </div>

      {error && <div style={{ color: 'red', marginTop: 10 }}>{error}</div>}

      {result && (
        <div style={{ marginTop: 12 }}>
          <div>Rate: {result.rate}</div>
          <h3>{result.amount} {result.from_currency} = {result.result} {result.to_currency}</h3>
          <div style={{ marginTop: 12 }}>
            <label>History (days)</label>
            <select value={days} onChange={e => setDays(parseInt(e.target.value))}>
              <option value={7}>7</option>
              <option value={14}>14</option>
              <option value={30}>30</option>
            </select>
            <HistoryChart base={from} target={to} days={days} />
          </div>
        </div>
      )}

      <div style={{ marginTop: 20 }}>
        <h3>Your Conversion History</h3>
        <div className="table-responsive">
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
              {conversions.map((c, i) => (
                <tr key={c.id}>
                  <td>{i + 1}</td>
                  <td>{new Date(c.timestamp).toLocaleString()}</td>
                  <td>{c.from_currency}</td>
                  <td>{c.to_currency}</td>
                  <td>{c.amount}</td>
                  <td>{c.result}</td>
                  <td>{c.rate}</td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </div>
  );
}






// import React, { useEffect, useState } from 'react';
// import axios from 'axios';
// import HistoryChart from './HistoryChart';
// import './Converter.css';




// export default function Converter({ token, email }) {
//   const [amount, setAmount] = useState(1);
//   const [from, setFrom] = useState('USD');
//   const [to, setTo] = useState('INR');
//   const [result, setResult] = useState(null);
//   const [loading, setLoading] = useState(false);
//   const [currencies, setCurrencies] = useState({});
//   const [error, setError] = useState(null);
//   const [days, setDays] = useState(7);
//   const [conversions, setConversions] = useState([]);

//   useEffect(() => {
//     fetchCurrencies();
//     if(token) fetchConversions();
//   }, [token]);

//   const fetchCurrencies = async () => {
//     try {
//       const res = await axios.get('http://localhost:8000/currencies');
//       if(res.data.success) setCurrencies(res.data.codes);
//     } catch(e) {
//       console.error(e);
//     }
//   };

//   const swap = () => {
//     const t = from;
//     setFrom(to);
//     setTo(t);
//     setResult(null);
//   };

//   const handleConvert = async () => {
//     if(!token) return alert("Please login first!");
//     setLoading(true);
//     setError(null);
//     try {
//       const res = await axios.post('http://localhost:8000/user/convert', 
//         { from_currency: from, to_currency: to, amount: parseFloat(amount) }, 
//         { headers: { Authorization: `Bearer ${token}` } }
//       );
//       setResult(res.data);
//       fetchConversions();
//     } catch(e) {
//       setError(e.response?.data?.detail || e.message);
//     } finally {
//       setLoading(false);
//     }
//   };

//   // const fetchConversions = async () => {
//   //   if(!token) return;
//   //   try {
//   //     const res = await axios.get('http://localhost:8000/user/conversions', {
//   //       headers: { Authorization: `Bearer ${token}` }
//   //     });
//   //     setConversions(res.data);
//   //   } catch(e) {
//   //     console.error(e);
//   //   }
//   // };

//   const fetchConversions = async () => {
//   if (!token) {
//     console.warn("⚠️ No token found — skipping conversions fetch");
//     return;
//   }

//   try {
//     console.log("🔑 Using token for request:", token);

//     const res = await axios.get("http://localhost:8000/user/conversions", {
//       headers: { Authorization: `Bearer ${token}` },
//     });

//     console.log("✅ Fetched conversions:", res.data);
//     setConversions(res.data);
//   } catch (e) {
//     console.error("❌ Error fetching conversions:", e.response?.data || e.message);
//     if (e.response?.status === 401) {
//       alert("Session expired or unauthorized. Please log in again.");
//     }
//   }
// };


//   return (
//     <div className="card">
//       <h2>Welcome, {email}</h2>

//       <div style={{ display: 'flex', marginTop: 12 }}>
//         <input type="number" value={amount} onChange={e=>setAmount(e.target.value)} />
//         <select value={from} onChange={e=>setFrom(e.target.value)}>
//           {Object.keys(currencies).map(c => <option key={c} value={c}>{c} - {currencies[c]}</option>)}
//         </select>
//         <select value={to} onChange={e=>setTo(e.target.value)}>
//           {Object.keys(currencies).map(c => <option key={c} value={c}>{c} - {currencies[c]}</option>)}
//         </select>
//         <div style={{ display: 'flex', flexDirection: 'column', marginLeft: 8 }}>
//           <button onClick={swap} style={{ marginBottom: 6 }}>Swap</button>
//           <button onClick={handleConvert} disabled={loading}>{loading ? 'Converting...' : 'Convert'}</button>
//         </div>
//       </div>

//       {error && <div style={{ color: 'red', marginTop: 10 }}>{error}</div>}

//       {result && (
//         <div style={{ marginTop: 12 }}>
//           <div>Rate: {result.rate}</div>
//           <h3>{result.amount} {result.from_currency} = {result.result} {result.to_currency}</h3>
//           <div style={{ marginTop: 12 }}>
//             <label>History (days)</label>
//             <select value={days} onChange={e => setDays(e.target.value)}>
//               <option value={7}>7</option>
//               <option value={14}>14</option>
//               <option value={30}>30</option>
//             </select>
//             <HistoryChart base={from} target={to} days={parseInt(days)} />
//           </div>
//         </div>
//       )}

//       <div style={{ marginTop: 20 }}>
//   <h3>Your Conversion History</h3>
//   <div className="table-responsive">
//     <table className="conversion-table">
//       <thead>
//         <tr>
//           <th>#</th>
//           <th>Time</th>
//           <th>From</th>
//           <th>To</th>
//           <th>Amount</th>
//           <th>Result</th>
//           <th>Rate</th>
//         </tr>
//       </thead>
//       <tbody>
//         {conversions.map((c, i) => (
//           <tr key={c.id}>
//             <td>{i + 1}</td>
//             <td>{new Date(c.timestamp).toLocaleString()}</td>
//             <td>{c.from_currency}</td>
//             <td>{c.to_currency}</td>
//             <td>{c.amount}</td>
//             <td>{c.result}</td>
//             <td>{c.rate}</td>
//           </tr>
//         ))}
//       </tbody>
//     </table>
//   </div>
// </div>
// </div>
//   );
// }






