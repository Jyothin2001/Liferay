import React, { useEffect, useState } from 'react';
import Select, { components } from 'react-select';
import ReactCountryFlag from 'react-country-flag';
import { clientConvert, clientGetConversions } from '../api';
import HistoryChart from './HistoryChart';
import './Converter.css';

export default function Converter({ token, email, logout }) {
  const [amount, setAmount] = useState(1);
  const [from, setFrom] = useState('USD');
  const [to, setTo] = useState('INR');
  const [result, setResult] = useState(null);
  const [loading, setLoading] = useState(false);
  const [currencies, setCurrencies] = useState({});
  const [error, setError] = useState(null);
  const [days, setDays] = useState(7);
  const [conversions, setConversions] = useState([]);
  const [page, setPage] = useState(1);
  const [loadingCurrencies, setLoadingCurrencies] = useState(true);

  const [chartBase, setChartBase] = useState(from);
  const [chartTarget, setChartTarget] = useState(to);

  const perPage = 5;

  const currencyCountryMap = {
    USD: "US", EUR: "EU", INR: "IN", GBP: "GB", JPY: "JP",
    AUD: "AU", CAD: "CA", CHF: "CH", CNY: "CN", SGD: "SG",
    NZD: "NZ", HKD: "HK", SEK: "SE", NOK: "NO", MXN: "MX",
    ZAR: "ZA", TRY: "TR", BRL: "BR", RUB: "RU", KRW: "KR",
    DKK: "DK", PLN: "PL", THB: "TH", IDR: "ID", MYR: "MY",
    PHP: "PH", VND: "VN", AED: "AE", PKR: "PK", LKR: "LK",
  };

  const getCountryCode = (code) => currencyCountryMap[code] || code.slice(0, 2).toUpperCase();

  const unsupportedCurrencies = [
    "XCD", "ANG", "XPF", "XAF", "XOF", "XDR", "WST", "CW",
  ];

  // ✔ Filter OUT unsupported currencies
  const supportedCurrencies = Object.keys(currencies).filter(
    code => !unsupportedCurrencies.includes(code)
  );

  useEffect(() => {
    fetchCurrencies();
    if (token) fetchConversions();
  }, [token]);

  const fetchCurrencies = async () => {
    try {
      const res = await fetch('http://192.168.0.102:8000/currencies');
      const data = await res.json();
      if (data.success && data.codes) {
        const sortedCodes = Object.keys(data.codes)
          .sort()
          .reduce((acc, key) => { acc[key] = data.codes[key]; return acc; }, {});
        setCurrencies(sortedCodes);
      }
    } catch (e) {
      console.error("Error fetching currencies:", e);
    } finally {
      setLoadingCurrencies(false);
    }
  };

  const swap = () => { setFrom(to); setTo(from); setResult(null); };

  const handleConvert = async () => {
    if (!token) return alert("Please login first!");
    setLoading(true);
    setError(null);

    try {
      const res = await clientConvert(token, from, to, parseFloat(amount));
      console.log("Conversion API Raw Data =", res.data);

      const total = parseFloat(res.data.result) || 0;
      const amt = parseFloat(amount) || 1;
      const rate = total / amt;

      setResult({
        rate: rate.toFixed(4),
        result: total.toFixed(4)
      });

      setChartBase(from);
      setChartTarget(to);
      fetchConversions();

    } catch (e) {
      setError(e.response?.data?.detail || e.message);
    } finally {
      setLoading(false);
    }
  };

  const fetchConversions = async () => {
    if (!token) return;
    try {
      const res = await clientGetConversions(token);
      const sorted = res.data.sort((a, b) => new Date(b.timestamp) - new Date(a.timestamp));
      setConversions(sorted);
    } catch (e) { console.error("Error fetching history:", e); }
  };

  const start = (page - 1) * perPage;
  const paginated = conversions.slice(start, start + perPage);
  const totalPages = Math.ceil(conversions.length / perPage);

  // 🔥 Updated to use supportedCurrencies instead of Object.keys(currencies)
  const options = supportedCurrencies.map(code => ({
    value: code,
    label: `${code} — ${currencies[code]}`,
    countryCode: getCountryCode(code)
  }));

  const Option = (props) => (
    <components.Option {...props}>
      <ReactCountryFlag countryCode={props.data.countryCode} svg style={{ width: '20px', height: '20px', marginRight: '8px' }} />
      {props.data.label}
    </components.Option>
  );

  const SingleValue = (props) => (
    <components.SingleValue {...props}>
      <ReactCountryFlag countryCode={props.data.countryCode} svg style={{ width: '20px', height: '20px', marginRight: '8px' }} />
      {props.data.label}
    </components.SingleValue>
  );

  return (
    <div className="converter-container">
      <div className="converter-header">
        <h2 className="converter-title">Conversions</h2>
        <button className="logout-btn" onClick={logout}>Logout</button>
      </div>

      <div className="converter-form">
        <input type="number" value={amount} onChange={e => setAmount(e.target.value)} className="converter-input" placeholder="Amount" />
        <div className="converter-dropdowns">

          <Select
            value={options.find(o => o.value === from)}
            onChange={opt => setFrom(opt.value)}
            options={options}
            isSearchable
            components={{ Option, SingleValue }}
            className="converter-select"
            placeholder="From"
            menuPortalTarget={document.body}
            menuPosition="fixed"
            styles={{ control: base => ({ ...base, minHeight: '40px', borderRadius: '8px', width: '180px' }) }}
          />

          <button className="swap-btn" onClick={swap}>⇄</button>

          <Select
            value={options.find(o => o.value === to)}
            onChange={opt => setTo(opt.value)}
            options={options}
            isSearchable
            components={{ Option, SingleValue }}
            className="converter-select"
            placeholder="To"
            menuPortalTarget={document.body}
            menuPosition="fixed"
            styles={{ control: base => ({ ...base, minHeight: '40px', borderRadius: '8px', width: '180px' }) }}
          />
        </div>

        <button className="convert-btn" onClick={handleConvert} disabled={loading || loadingCurrencies}>
          {loading ? 'Converting...' : loadingCurrencies ? 'Loading currencies...' : 'Convert'}
        </button>
      </div>

      {error && <div className="converter-error">{error}</div>}

      {result && (
        <div className="converter-result">
          <div>Rate: {result.rate}</div>
          <h3>{amount} {from} = {result.result} {to}</h3>

          <div className="converter-history-select">
            <label>History (days)</label>
            <select value={days} onChange={e => setDays(parseInt(e.target.value))}>
              <option value={7}>7</option>
              <option value={14}>14</option>
              <option value={30}>30</option>
            </select>
          </div>

          <HistoryChart base={chartBase} target={chartTarget} days={days} />
        </div>
      )}

      <h3 className="converter-history-title">Your Conversion History</h3>
      <div className="table-responsive">
        <table className="conversion-table">
          <thead>
            <tr>
              <th>SL NO</th><th>Time</th><th>From</th><th>To</th><th>Amount</th><th>Result</th><th>Rate</th>
            </tr>
          </thead>
          <tbody>
            {paginated.map((c, i) => (
              <tr key={c.id}>
                <td>{start + i + 1}</td>
                <td>{new Date(c.timestamp).toLocaleString(undefined, { year: 'numeric', month: 'short', day: 'numeric', hour: '2-digit', minute: '2-digit', second: '2-digit' })}</td>
                <td><ReactCountryFlag countryCode={getCountryCode(c.from_currency)} svg style={{ width: '20px', marginRight: '5px' }} />{c.from_currency}</td>
                <td><ReactCountryFlag countryCode={getCountryCode(c.to_currency)} svg style={{ width: '20px', marginRight: '5px' }} />{c.to_currency}</td>
                <td>{c.amount}</td>
                <td>{c.result}</td>
                <td>{c.rate}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>

      <div className="converter-pagination">
        <button disabled={page === 1} onClick={() => setPage(page - 1)}>Prev</button>
        <span>Page {page} / {totalPages}</span>
        <button disabled={page === totalPages} onClick={() => setPage(page + 1)}>Next</button>
      </div>
    </div>
  );
}



// import React, { useEffect, useState } from 'react';
// import Select, { components } from 'react-select';
// import ReactCountryFlag from 'react-country-flag';
// import { clientConvert, clientGetConversions } from '../api';
// import HistoryChart from './HistoryChart';
// import './Converter.css';

// export default function Converter({ token, email, logout }) {
//   const [amount, setAmount] = useState(1);
//   const [from, setFrom] = useState('USD');
//   const [to, setTo] = useState('INR');
//   const [result, setResult] = useState(null);
//   const [loading, setLoading] = useState(false);
//   const [currencies, setCurrencies] = useState({});
//   const [error, setError] = useState(null);
//   const [days, setDays] = useState(7);
//   const [conversions, setConversions] = useState([]);
//   const [page, setPage] = useState(1);
//   const [loadingCurrencies, setLoadingCurrencies] = useState(true);

//   // Chart states
//   const [chartBase, setChartBase] = useState(from);
//   const [chartTarget, setChartTarget] = useState(to);

//   const perPage = 5;

//   const currencyCountryMap = {
//     USD: "US", EUR: "EU", INR: "IN", GBP: "GB", JPY: "JP",
//     AUD: "AU", CAD: "CA", CHF: "CH", CNY: "CN", SGD: "SG",
//     NZD: "NZ", HKD: "HK", SEK: "SE", NOK: "NO", MXN: "MX",
//     ZAR: "ZA", TRY: "TR", BRL: "BR", RUB: "RU", KRW: "KR",
//     DKK: "DK", PLN: "PL", THB: "TH", IDR: "ID", MYR: "MY",
//     PHP: "PH", VND: "VN", AED: "AE", PKR: "PK", LKR: "LK",
//   };

//   const getCountryCode = (code) => currencyCountryMap[code] || code.slice(0,2).toUpperCase();

//   const unsupportedCurrencies = [
//   "XCD", "ANG", "XPF", "XAF", "XOF", "XDR", "WST", "CW",
// ];

// // ✔ Added here — filters out unsupported currencies
//   const supportedCurrencies = Object.keys(currencies).filter(
//     code => !unsupportedCurrencies.includes(code)
//   );

//   useEffect(() => {
//     fetchCurrencies();
//     if (token) fetchConversions();
//   }, [token]);

//   const fetchCurrencies = async () => {
//     try {
//       const res = await fetch('http://localhost:8000/currencies');
//       const data = await res.json();
//       if (data.success && data.codes) {
//         const sortedCodes = Object.keys(data.codes)
//           .sort()
//           .reduce((acc, key) => { acc[key] = data.codes[key]; return acc; }, {});
//         setCurrencies(sortedCodes);
//       }
//     } catch (e) {
//       console.error("Error fetching currencies:", e);
//     } finally {
//       setLoadingCurrencies(false);
//     }
//   };

//   const swap = () => { setFrom(to); setTo(from); setResult(null); };

//   // const handleConvert = async () => {
//   //   if (!token) return alert("Please login first!");
//   //   setLoading(true);
//   //   setError(null);
//   //   try {
//   //     const res = await clientConvert(token, from, to, parseFloat(amount));
//   //     setResult(res.data);
//   //     fetchConversions();
//   //     // Update chart only after conversion
//   //     setChartBase(from);
//   //     setChartTarget(to);
//   //   } catch (e) {
//   //     setError(e.response?.data?.detail || e.message);
//   //   } finally {
//   //     setLoading(false);
//   //   }
//   // };
//   const handleConvert = async () => {
//   if (!token) return alert("Please login first!");
//   setLoading(true);
//   setError(null);

//   try {
//     const res = await clientConvert(token, from, to, parseFloat(amount));

//     console.log("Conversion API Raw Data =", res.data);

//     const total = parseFloat(res.data.result) || 0;
//     const amt = parseFloat(amount) || 1;
//     const rate = total / amt; // ✔️ CALCULATE RATE FROM RESULT

//     setResult({
//       rate: rate.toFixed(4),     // 1-unit conversion
//       result: total.toFixed(4)   // total conversion
//     });

//     setChartBase(from);
//     setChartTarget(to);
//     fetchConversions();

//   } catch (e) {
//     setError(e.response?.data?.detail || e.message);
//   } finally {
//     setLoading(false);
//   }
// };



//   const fetchConversions = async () => {
//     if (!token) return;
//     try {
//       const res = await clientGetConversions(token);
//       const sorted = res.data.sort((a,b) => new Date(b.timestamp)-new Date(a.timestamp));
//       setConversions(sorted);
//     } catch (e) { console.error("Error fetching history:", e); }
//   };

//   const start = (page - 1) * perPage;
//   const paginated = conversions.slice(start, start + perPage);
//   const totalPages = Math.ceil(conversions.length / perPage);

//   const options = Object.keys(currencies).map(code => ({
//     value: code,
//     label: `${code} — ${currencies[code]}`,
//     countryCode: getCountryCode(code)
//   }));

//   const Option = (props) => (
//     <components.Option {...props}>
//       <ReactCountryFlag countryCode={props.data.countryCode} svg style={{ width: '20px', height: '20px', marginRight: '8px' }} />
//       {props.data.label}
//     </components.Option>
//   );

//   const SingleValue = (props) => (
//     <components.SingleValue {...props}>
//       <ReactCountryFlag countryCode={props.data.countryCode} svg style={{ width: '20px', height: '20px', marginRight: '8px' }} />
//       {props.data.label}
//     </components.SingleValue>
//   );

//   return (
//     <div className="converter-container">
//       <div className="converter-header">
//         <h2 className="converter-title">Conversions</h2>
//         <button className="logout-btn" onClick={logout}>Logout</button>
//       </div>

//       <div className="converter-form">
//         <input type="number" value={amount} onChange={e => setAmount(e.target.value)} className="converter-input" placeholder="Amount" />
//         <div className="converter-dropdowns">
//           <Select value={options.find(o => o.value === from)} onChange={opt => setFrom(opt.value)} options={options} isSearchable components={{ Option, SingleValue }} className="converter-select" placeholder="From" menuPortalTarget={document.body} menuPosition="fixed" styles={{ control: base => ({ ...base, minHeight:'40px', borderRadius:'8px', width:'180px' }) }} />
//           <button className="swap-btn" onClick={swap}>⇄</button>
//           <Select value={options.find(o => o.value === to)} onChange={opt => setTo(opt.value)} options={options} isSearchable components={{ Option, SingleValue }} className="converter-select" placeholder="To" menuPortalTarget={document.body} menuPosition="fixed" styles={{ control: base => ({ ...base, minHeight:'40px', borderRadius:'8px', width:'180px' }) }} />
//         </div>

//         <button className="convert-btn" onClick={handleConvert} disabled={loading || loadingCurrencies}>
//           {loading ? 'Converting...' : loadingCurrencies ? 'Loading currencies...' : 'Convert'}
//         </button>
//       </div>

//       {error && <div className="converter-error">{error}</div>}

//       {result && (
//         <div className="converter-result">
//           <div>Rate: {result.rate}</div>
//           <h3>{amount} {from} = {result.result} {to}</h3>

//           <div className="converter-history-select">
//             <label>History (days)</label>
//             <select value={days} onChange={e => setDays(parseInt(e.target.value))}>
//               <option value={7}>7</option>
//               <option value={14}>14</option>
          
              
//             </select>
//           </div>

//           <HistoryChart base={chartBase} target={chartTarget} days={days} />
//         </div>
//       )}

//       <h3 className="converter-history-title">Your Conversion History</h3>
//       <div className="table-responsive">
//         <table className="conversion-table">
//           <thead>
//             <tr>
//               <th>SL NO</th><th>Time</th><th>From</th><th>To</th><th>Amount</th><th>Result</th><th>Rate</th>
//             </tr>
//           </thead>
//           <tbody>
//             {paginated.map((c,i) => (
//               <tr key={c.id}>
//                 <td>{start+i+1}</td>
//                 <td>{new Date(c.timestamp).toLocaleString(undefined,{year:'numeric',month:'short',day:'numeric',hour:'2-digit',minute:'2-digit',second:'2-digit'})}</td>
//                 <td><ReactCountryFlag countryCode={getCountryCode(c.from_currency)} svg style={{ width:'20px', marginRight:'5px' }} />{c.from_currency}</td>
//                 <td><ReactCountryFlag countryCode={getCountryCode(c.to_currency)} svg style={{ width:'20px', marginRight:'5px' }} />{c.to_currency}</td>
//                 <td>{c.amount}</td>
//                 <td>{c.result}</td>
//                 <td>{c.rate}</td>
//               </tr>
//             ))}
//           </tbody>
//         </table>
//       </div>

//       <div className="converter-pagination">
//         <button disabled={page===1} onClick={() => setPage(page-1)}>Prev</button>
//         <span>Page {page} / {totalPages}</span>
//         <button disabled={page===totalPages} onClick={() => setPage(page+1)}>Next</button>
//       </div>
//     </div>
//   );
// }



// import React, { useEffect, useState } from 'react';
// import Select, { components } from 'react-select';
// import ReactCountryFlag from 'react-country-flag';
// import { clientConvert, clientGetConversions } from '../api';
// import HistoryChart from './HistoryChart';
// import './Converter.css';

// export default function Converter({ token, email, logout }) {
//   const [amount, setAmount] = useState(1);
//   const [from, setFrom] = useState('USD');
//   const [to, setTo] = useState('INR');
//   const [result, setResult] = useState(null);
//   const [loading, setLoading] = useState(false);
//   const [currencies, setCurrencies] = useState({});
//   const [error, setError] = useState(null);
//   const [days, setDays] = useState(7);
//   const [conversions, setConversions] = useState([]);
//   const [page, setPage] = useState(1);
//   const [loadingCurrencies, setLoadingCurrencies] = useState(true);

//   const perPage = 5;

//   // Map currency to country code (for flags)
//   const currencyCountryMap = {
//     USD: "US", EUR: "EU", INR: "IN", GBP: "GB", JPY: "JP",
//     AUD: "AU", CAD: "CA", CHF: "CH", CNY: "CN", SGD: "SG",
//     NZD: "NZ", HKD: "HK", SEK: "SE", NOK: "NO", MXN: "MX",
//     ZAR: "ZA", TRY: "TR", BRL: "BR", RUB: "RU", KRW: "KR",
//     DKK: "DK", PLN: "PL", THB: "TH", IDR: "ID", MYR: "MY",
//     PHP: "PH", VND: "VN", AED: "AE", PKR: "PK", LKR: "LK",
//   };

//   const getCountryCode = (code) => currencyCountryMap[code] || code.slice(0,2).toUpperCase();

//   // Fetch currencies from API
//   useEffect(() => {
//     fetchCurrencies();
//     if (token) fetchConversions();
//   }, [token]);

//   // const fetchCurrencies = async () => {
//   //   try {
//   //     const res = await fetch('http://localhost:8000/currencies');
//   //     const data = await res.json();
//   //     if (data.success && data.codes) {
//   //       // Sort A→Z
//   //       const sortedCodes = Object.keys(data.codes).sort().reduce((acc, key) => {
//   //         acc[key] = data.codes[key];
//   //         return acc;
//   //       }, {});
//   //       setCurrencies(sortedCodes);
//   //     }
//   //   } catch (e) {
//   //     console.error("Error fetching currencies:", e);
//   //   }
//   // };

//   const fetchCurrencies = async () => {
//   try {
//     const res = await fetch('http://localhost:8000/currencies');
//     const data = await res.json();
//     if (data.success && data.codes) {
//       const sortedCodes = Object.keys(data.codes)
//         .sort()
//         .reduce((acc, key) => {
//           acc[key] = data.codes[key];
//           return acc;
//         }, {});
//       setCurrencies(sortedCodes);
//     } else {
//       setCurrencies(defaultCurrencies); // fallback if API returns nothing
//     }
//   } catch (e) {
//     console.error("Error fetching currencies:", e);
//     setCurrencies(defaultCurrencies); // fallback if API fails
//   } finally {
//     setLoadingCurrencies(false); // mark as loaded
//   }
// };


//   const swap = () => {
//     setFrom(to);
//     setTo(from);
//     setResult(null);
//   };

//   const handleConvert = async () => {
//     if (!token) return alert("Please login first!");
//     setLoading(true);
//     setError(null);
//     try {
//       const res = await clientConvert(token, from, to, parseFloat(amount));
//       setResult(res.data);
//       fetchConversions();
//     } catch (e) {
//       setError(e.response?.data?.detail || e.message);
//     } finally {
//       setLoading(false);
//     }
//   };

//   const fetchConversions = async () => {
//     if (!token) return;
//     try {
//       const res = await clientGetConversions(token);
//       const sorted = res.data.sort((a,b) => new Date(b.timestamp)-new Date(a.timestamp));
//       setConversions(sorted);
//     } catch (e) {
//       console.error("Error fetching history:", e);
//     }
//   };

//   const start = (page - 1) * perPage;
//   const paginated = conversions.slice(start, start + perPage);
//   const totalPages = Math.ceil(conversions.length / perPage);

//   // react-select options with flags
//   const options = Object.keys(currencies).map(code => ({
//     value: code,
//     label: `${code} — ${currencies[code]}`,
//     countryCode: getCountryCode(code)
//   }));

//   const Option = (props) => (
//     <components.Option {...props}>
//       <ReactCountryFlag
//         countryCode={props.data.countryCode}
//         svg
//         style={{ width: '20px', height: '20px', marginRight: '8px' }}
//       />
//       {props.data.label}
//     </components.Option>
//   );

//   const SingleValue = (props) => (
//     <components.SingleValue {...props}>
//       <ReactCountryFlag
//         countryCode={props.data.countryCode}
//         svg
//         style={{ width: '20px', height: '20px', marginRight: '8px' }}
//       />
//       {props.data.label}
//     </components.SingleValue>
//   );

//   return (
//     <div className="converter-container">
//       <div className="converter-header">
//         <h2 className="converter-title">Conversions</h2>
//         <button className="logout-btn" onClick={logout}>Logout</button>
//       </div>

//       <div className="converter-form">
//         <input
//           type="number"
//           value={amount}
//           onChange={e => setAmount(e.target.value)}
//           className="converter-input"
//           placeholder="Amount"
//         />

//         <div className="converter-dropdowns">
//           <Select
//             value={options.find(o => o.value === from)}
//             onChange={opt => setFrom(opt.value)}
//             options={options}
//             isSearchable
//             components={{ Option, SingleValue }}
//             className="converter-select"
//             placeholder="From"
//             styles={{
//               control: base => ({ ...base, minHeight: '40px', borderRadius: '8px', width: '180px' }),
//               menu: base => ({ ...base, maxHeight: '300px' }),
//             }}
//             menuPortalTarget={document.body}
//             menuPosition="fixed"
//           />

//           <button className="swap-btn" onClick={swap}>⇄</button>

//           <Select
//             value={options.find(o => o.value === to)}
//             onChange={opt => setTo(opt.value)}
//             options={options}
//             isSearchable
//             components={{ Option, SingleValue }}
//             className="converter-select"
//             placeholder="To"
//             styles={{
//               control: base => ({ ...base, minHeight: '40px', borderRadius: '8px', width: '180px' }),
//               menu: base => ({ ...base, maxHeight: '300px' }),
//             }}
//             menuPortalTarget={document.body}
//             menuPosition="fixed"
//           />
//         </div>

//         {/* <button className="convert-btn" onClick={handleConvert} disabled={loading}>
//           {loading ? 'Converting...' : 'Convert'}
//         </button> */}
//         <button
//   className="convert-btn"
//   onClick={handleConvert}
//   disabled={loading || loadingCurrencies} // disable until currencies fetched
// >
//   {loading ? 'Converting...' : loadingCurrencies ? 'Loading currencies...' : 'Convert'}
// </button>

//       </div>

//       {error && <div className="converter-error">{error}</div>}

//       {result && (
//         <div className="converter-result">
//           <div>Rate: {result.rate}</div>
//           <h3>{amount} {from} = {result.result} {to}</h3>

//           <div className="converter-history-select">
//             <label>History (days)</label>
//             <select value={days} onChange={e => setDays(parseInt(e.target.value))}>
//               <option value={7}>7</option>
//               <option value={14}>14</option>
//               <option value={30}>30</option>
//             </select>
//           </div>

//           <HistoryChart base={from} target={to} days={days} />
//         </div>
//       )}

//       <h3 className="converter-history-title">Your Conversion History</h3>
//       <div className="table-responsive">
//         <table className="conversion-table">
//           <thead>
//             <tr>
//               <th>#</th>
//               <th>Time</th>
//               <th>From</th>
//               <th>To</th>
//               <th>Amount</th>
//               <th>Result</th>
//               <th>Rate</th>
//             </tr>
//           </thead>
//           <tbody>
//             {paginated.map((c, i) => (
//               <tr key={c.id}>
//                 <td>{start + i + 1}</td>
//                 {/* <td>{new Date(c.timestamp).toLocaleString()}</td> */}
//                 <td>
//   {new Date(c.timestamp).toLocaleString(undefined, {
//     year: 'numeric',
//     month: 'short',
//     day: 'numeric',
//     hour: '2-digit',
//     minute: '2-digit',
//     second: '2-digit',
//   })}
// </td>

//                 <td>
//                   <ReactCountryFlag countryCode={getCountryCode(c.from_currency)} svg style={{ width: '20px', marginRight: '5px' }} />
//                   {c.from_currency}
//                 </td>
//                 <td>
//                   <ReactCountryFlag countryCode={getCountryCode(c.to_currency)} svg style={{ width: '20px', marginRight: '5px' }} />
//                   {c.to_currency}
//                 </td>
//                 <td>{c.amount}</td>
//                 <td>{c.result}</td>
//                 <td>{c.rate}</td>
//               </tr>
//             ))}
//           </tbody>
//         </table>
//       </div>

//       <div className="converter-pagination">
//         <button disabled={page === 1} onClick={() => setPage(page - 1)}>Prev</button>
//         <span>Page {page} / {totalPages}</span>
//         <button disabled={page === totalPages} onClick={() => setPage(page + 1)}>Next</button>
//       </div>
//     </div>
//   );
// }



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
//   const rowsPerPage = 8;

//   const [filterFrom, setFilterFrom] = useState('');
//   const [filterTo, setFilterTo] = useState('');
//   const [filterStartDate, setFilterStartDate] = useState('');
//   const [filterEndDate, setFilterEndDate] = useState('');
//   const [minAmount, setMinAmount] = useState('');
//   const [maxAmount, setMaxAmount] = useState('');
//   const [sortOrder, setSortOrder] = useState('desc');

//   const currencyCountryMap = { USD:"US", EUR:"EU", INR:"IN", GBP:"GB", JPY:"JP", AUD:"AU", CAD:"CA", CHF:"CH", CNY:"CN", SGD:"SG", NZD:"NZ", HKD:"HK", SEK:"SE", NOK:"NO", MXN:"MX", ZAR:"ZA", TRY:"TR", BRL:"BR", RUB:"RU", KRW:"KR", DKK:"DK", PLN:"PL", THB:"TH", IDR:"ID", MYR:"MY", PHP:"PH", VND:"VN", AED:"AE", PKR:"PK", LKR:"LK" };
//   const getCountryCode = (code) => currencyCountryMap[code] || code.slice(0,2).toUpperCase();

//   const login = async () => {
//     try {
//       const res = await axios.post('http://192.168.0.102:8000/admin/login', { email, password });
//       setToken(res.data.access_token);
//       localStorage.setItem('admin_token', res.data.access_token);
//       alert('Logged in');
//     } catch (e) {
//       alert(e.response?.data?.detail || e.message);
//     }
//   };

//   const fetchLogs = async () => {
//     try {
//       const res = await axios.get('http://192.168.0.102:8000/admin/conversions', {
//         headers: { Authorization: 'Bearer ' + token },
//       });
//       setLogs(res.data);
//     } catch (e) {}
//   };

//   // 🔥 Auto refresh logs when user does new conversions
//   useEffect(() => {
//     if (!token) return;

//     fetchLogs();                   // initial render
//     const interval = setInterval(() => fetchLogs(), 5000);  // every 5 sec

//     return () => clearInterval(interval);
//   }, [token]);

//   const deleteLog = async (id) => {
//     if (!window.confirm("Delete this record?")) return;
//     try {
//       const adminToken = localStorage.getItem('admin_token');
//       await axios.delete(`http://192.168.0.102:8000/admin/delete_conversion/${id}`, {
//         headers: { Authorization: `Bearer ${adminToken}` },
//       });
//       setLogs((prev) => prev.filter((l) => l.id !== id));
//     } catch (err) {
//       alert("Delete failed");
//     }
//   };

//   // Filter logic
//   const filteredLogs = logs.filter((log) => {
//     const logDate = new Date(log.timestamp).toISOString().split("T")[0];

//     if (filterStartDate && !filterEndDate) return logDate === filterStartDate;
//     if (!filterStartDate && filterEndDate) return logDate === filterEndDate;
//     if (filterStartDate && logDate < filterStartDate) return false;
//     if (filterEndDate && logDate > filterEndDate) return false;

//     if (filterFrom && log.from_currency.toUpperCase() !== filterFrom.toUpperCase().trim()) return false;
//     if (filterTo && log.to_currency.toUpperCase() !== filterTo.toUpperCase().trim()) return false;
//     if (minAmount && Number(log.amount) < Number(minAmount)) return false;
//     if (maxAmount && Number(log.amount) > Number(maxAmount)) return false;

//     return true;
//   });

//   const sortedLogs = [...filteredLogs].sort((a, b) =>
//     sortOrder === "asc" ? a.amount - b.amount : b.amount - a.amount
//   );

//   const indexOfLastRow = currentPage * rowsPerPage;
//   const indexOfFirstRow = indexOfLastRow - rowsPerPage;
//   const currentRows = sortedLogs.slice(indexOfFirstRow, indexOfLastRow);
//   const totalPages = Math.ceil(sortedLogs.length / rowsPerPage);

//   return (
//     <div className="admin-wrapper">
//       {!token ? (
//         <div className="admin-login-box">
//           <h2>Admin Sign In</h2>
//           <input type="email" value={email} onChange={(e)=>setEmail(e.target.value)} placeholder="Email"/>
//           <input type="password" value={password} onChange={(e)=>setPassword(e.target.value)} placeholder="Password"/>
//           <button onClick={login}>Sign In</button>
//         </div>
//       ) : (
//         <>
//           <div className="admin-panel">
//             <div className="admin-header-row">
//               <h2>Conversion Logs</h2>
//               <button className="logout-btn" onClick={() => { setToken(''); localStorage.removeItem('admin_token'); setLogs([]); onLogout(); }}>
//                 Logout
//               </button>
//             </div>

//             {/* Filters */}
//             <div className="filters">
//               <input type="text" placeholder="From" value={filterFrom} onChange={(e)=>setFilterFrom(e.target.value)} />
//               <input type="text" placeholder="To" value={filterTo} onChange={(e)=>setFilterTo(e.target.value)} />
//               <input type="date" value={filterStartDate} onChange={(e)=>setFilterStartDate(e.target.value)} />
//               <input type="date" value={filterEndDate} onChange={(e)=>setFilterEndDate(e.target.value)} />
//               <input type="number" placeholder="Min Amount" value={minAmount} onChange={(e)=>setMinAmount(e.target.value)} />
//               <input type="number" placeholder="Max Amount" value={maxAmount} onChange={(e)=>setMaxAmount(e.target.value)} />
//               <select value={sortOrder} onChange={(e)=>setSortOrder(e.target.value)}>
//                 <option value="desc">Amount: High → Low</option>
//                 <option value="asc">Amount: Low → High</option>
//               </select>
//             </div>

//             {/* TABLE */}
//             <div className="table-wrapper">
//               <table className="conversion-table">
//                 <thead>
//                   <tr>
//                     <th>SL NO</th>
//                     <th>Time</th>
//                     <th>From</th>
//                     <th>To</th>
//                     <th>Amount</th>
//                     <th>Result</th>
//                     <th>Rate</th>
//                     <th>Action</th>
//                   </tr>
//                 </thead>
//                 <tbody>
//                   {currentRows.map((l, idx) => (
//                     <tr key={l.id}>
//                       <td>{indexOfFirstRow + idx + 1}</td>
//                       <td>{new Date(l.timestamp).toLocaleString()}</td>
//                       <td><ReactCountryFlag countryCode={getCountryCode(l.from_currency)} svg /> {l.from_currency}</td>
//                       <td><ReactCountryFlag countryCode={getCountryCode(l.to_currency)} svg /> {l.to_currency}</td>
//                       <td>{l.amount}</td>
//                       <td>{l.result}</td>
//                       <td>{l.rate}</td>
//                       <td><button onClick={() => deleteLog(l.id)} style={{ color: "red" }}>🗑Delete</button></td>
//                     </tr>
//                   ))}
//                 </tbody>
//               </table>

//               <div className="pagination">
//                 <button disabled={currentPage === 1} onClick={() => setCurrentPage(currentPage - 1)}>Previous</button>
//                 <span>Page {currentPage} / {totalPages}</span>
//                 <button disabled={currentPage === totalPages} onClick={() => setCurrentPage(currentPage + 1)}>Next</button>
//               </div>
//             </div>
//           </div>

//           <AdminAnalytics token={token} />
//         </>
//       )}
//     </div>
//   );
// }



// import React, { useEffect, useState } from 'react';
// import Select, { components } from 'react-select';
// import ReactCountryFlag from 'react-country-flag';
// import { clientConvert, clientGetConversions } from '../api';
// import HistoryChart from './HistoryChart';
// import './Converter.css';
// import QrResult from "./QrResult";

// export default function Converter({ token, email, logout }) {
//   const [amount, setAmount] = useState(1);
//   const [from, setFrom] = useState('USD');
//   const [to, setTo] = useState('INR');
//   const [result, setResult] = useState(null);
//   const [loading, setLoading] = useState(false);
//   const [currencies, setCurrencies] = useState({});
//   const [error, setError] = useState(null);
//   const [days, setDays] = useState(7);
//   const [conversions, setConversions] = useState([]);
//   const [page, setPage] = useState(1);
//   const [showQR, setShowQR] = useState(false);

//   const perPage = 5;

//   const currencyCountryMap = {
//     USD: "US", EUR: "EU", INR: "IN", GBP: "GB", JPY: "JP",
//     AUD: "AU", CAD: "CA", CHF: "CH", CNY: "CN", SGD: "SG",
//     NZD: "NZ", HKD: "HK", SEK: "SE", NOK: "NO", MXN: "MX",
//     ZAR: "ZA", TRY: "TR", BRL: "BR", RUB: "RU", KRW: "KR",
//     DKK: "DK", PLN: "PL", THB: "TH", IDR: "ID", MYR: "MY",
//     PHP: "PH", VND: "VN", AED: "AE", PKR: "PK", LKR: "LK",
//   };

//   const getCountryCode = (code) => currencyCountryMap[code] || code.slice(0,2).toUpperCase();

//   const unsupportedCurrencies = [
//     "XCD", "ANG", "XPF", "XAF", "XOF", "XDR", "WST", "CW",
//   ];

//   useEffect(() => {
//     fetchCurrencies();
//     if (token) fetchConversions();
//   }, [token]);

//   const fetchCurrencies = async () => {
//     try {
//       const res = await fetch('http://192.168.0.102:8000/currencies');
//       const data = await res.json();
//       if (data.success && data.codes) {
//         const sortedCodes = Object.keys(data.codes).sort().reduce((acc, key) => {
//           acc[key] = data.codes[key];
//           return acc;
//         }, {});
//         setCurrencies(sortedCodes);
//       }
//     } catch (e) {
//       console.error("Error fetching currencies:", e);
//     }
//   };

//   const swap = () => {
//     setFrom(to);
//     setTo(from);
//     setResult(null);
//     setShowQR(false);
//   };

//   // const handleConvert = async () => {
//   //   if (!token) return alert("Please login first!");

//   //   setLoading(true);
//   //   setError(null);
//   //   setShowQR(false);

//   //   try {
//   //     const res = await clientConvert(token, from, to, parseFloat(amount));
//   //     setResult(res.data);
//   //     fetchConversions();
//   //   } catch (e) {
//   //     let err = e.response?.data?.detail;

//   //     if (Array.isArray(err)) {
//   //       setError(err[0]?.msg || "Validation error");
//   //     } else if (typeof err === "object") {
//   //       setError(err.msg || JSON.stringify(err));
//   //     } else {
//   //       setError(err || e.message || "Conversion failed.");
//   //     }
//   //   } finally {
//   //     setLoading(false);
//   //   }
//   // };


//   const handleConvert = async () => {
//   if (!token) return alert("Please login first!");
  
//   setLoading(true);
//   setError(null);
//   setShowQR(false);

//   // -------- Amount Validation --------
//   if (!amount || isNaN(amount)) {
//     setError("🚫 Please enter a valid amount.");
//     setLoading(false);
//     return;
//   }
//   if (parseFloat(amount) <= 0) {
//     setError("🚫 Amount must be greater than zero.");
//     setLoading(false);
//     return;
//   }

//   try {
//     const res = await clientConvert(token, from, to, parseFloat(amount));
//     setResult(res.data);
//     fetchConversions();
//   } catch (e) {
//     let err = e.response?.data?.detail;

//     if (Array.isArray(err)) {
//       setError(err[0]?.msg || "Validation error");
//     } else if (typeof err === "object") {
//       setError(err.msg || JSON.stringify(err));
//     } else {
//       setError(err || e.message || "Conversion failed.");
//     }
//   } finally {
//     setLoading(false);
//   }
// };


//   const fetchConversions = async () => {
//     if (!token) return;
//     try {
//       const res = await clientGetConversions(token);
//       const sorted = res.data.sort((a,b) => new Date(b.timestamp)-new Date(a.timestamp));
//       setConversions(sorted);
//     } catch (e) {
//       console.error("Error fetching history:", e);
//     }
//   };

//   const start = (page - 1) * perPage;
//   const paginated = conversions.slice(start, start + perPage);
//   const totalPages = Math.ceil(conversions.length / perPage);

//   const supportedCurrencies = Object.keys(currencies).filter(
//     code => !unsupportedCurrencies.includes(code)
//   );

//   const options = supportedCurrencies.map(code => ({
//     value: code,
//     label: `${code} — ${currencies[code]}`,
//     countryCode: getCountryCode(code)
//   }));

//   const Option = (props) => (
//     <components.Option {...props}>
//       <ReactCountryFlag
//         countryCode={props.data.countryCode}
//         svg
//         style={{ width: '20px', height: '20px', marginRight: '8px' }}
//       />
//       {props.data.label}
//     </components.Option>
//   );

//   const SingleValue = (props) => (
//     <components.SingleValue {...props}>
//       <ReactCountryFlag
//         countryCode={props.data.countryCode}
//         svg
//         style={{ width: '20px', height: '20px', marginRight: '8px' }}
//       />
//       {props.data.label}
//     </components.SingleValue>
//   );

//   return (
//     <div className="converter-container">
//       <div className="converter-header">
//         <h2>Conversions</h2>
//         <button className="logout-btn" onClick={logout}>Logout</button>
//       </div>

//       <div className="converter-form">
//         <input
//           type="number"
//           value={amount}
//           onChange={e => setAmount(e.target.value)}
//           className="converter-input"
//           placeholder="Amount"
//         />

//         <div className="converter-dropdowns">
//           <Select
//             value={options.find(o => o.value === from)}
//             onChange={opt => setFrom(opt.value)}
//             options={options}
//             isSearchable
//             components={{ Option, SingleValue }}
//             placeholder="From"
//             styles={{
//               control: base => ({ ...base, minHeight: '40px', borderRadius: '8px', width: '270px' }),
//             }}
//           />

//           <button className="swap-btn" onClick={swap}>⇄</button>

//           <Select
//             value={options.find(o => o.value === to)}
//             onChange={opt => setTo(opt.value)}
//             options={options}
//             isSearchable
//             components={{ Option, SingleValue }}
//             placeholder="To"
//             styles={{
//               control: base => ({ ...base, minHeight: '40px', borderRadius: '8px', width: '270px' }),
//             }}
//           />
//         </div>

//         <button className="convert-btn" onClick={handleConvert} disabled={loading}>
//           {loading ? 'Converting...' : 'Convert'}
//         </button>
//       </div>

//       {error && (
//         <div className="converter-error">
//           {typeof error === "string" ? error : JSON.stringify(error)}
//         </div>
//       )}

//       {result && (
//         <div className="converter-result">

//           {result && amount && (
//             <>
//               <div>Rate: {result.rate ? parseFloat(result.rate).toFixed(4) : "—"}</div>
//               <div>
//                 Exchange Rate (1 {from} → {to}): {(parseFloat(result.result) / parseFloat(amount)).toFixed(4)}
//               </div>
//               <h2>
//                 {amount} {from} = {parseFloat(result.result).toFixed(4)} {to}
//               </h2>
//             </>
//           )}

//           <div className="converter-history-select">
//             <label>History (days)</label>
//             <select value={days} onChange={e => setDays(parseInt(e.target.value))}>
//               <option value={7}>7</option>
//               <option value={14}>14</option>
//             </select>
//           </div>

//           <HistoryChart base={from} target={to} days={days} />

//           <button className="qr-btn" onClick={() => setShowQR(!showQR)}>
//             {showQR ? "Hide QR Code" : "Generate QR Code"}
//           </button>

//           {showQR && (
//             <QrResult
//               value={`
// Currency Conversion Result

// Amount: ${amount} ${from}
// Converted To: ${to}
// Exchange Rate: 1 ${from} = ${(parseFloat(result.result) / parseFloat(amount)).toFixed(4)} ${to}

// Converted Amount: ${parseFloat(result.result).toFixed(4)} ${to}

// Date & Time: ${new Date().toLocaleString()}
// Source: CurrencyPro Converter
// `}
//             />
//           )}
//         </div>
//       )}

//       <h3>Your Conversion History</h3>
//       <table className="conversion-table">
//         <thead>
//           <tr>
//             <th>SL No</th>
//             <th>Time</th>
//             <th>From</th>
//             <th>To</th>
//             <th>Amount</th>
//             <th>Result</th>
//             <th>Rate</th>
//           </tr>
//         </thead>
//         <tbody>
//           {paginated.map((c, i) => (
//             <tr key={c.id}>
//               <td>{start + i + 1}</td>
//               <td>{new Date(c.timestamp).toLocaleString()}</td>
//               <td><ReactCountryFlag countryCode={getCountryCode(c.from_currency)} svg /> {c.from_currency}</td>
//               <td><ReactCountryFlag countryCode={getCountryCode(c.to_currency)} svg /> {c.to_currency}</td>
//               <td>{c.amount}</td>
//               <td>{c.result}</td>
//               <td>{c.rate}</td>
//             </tr>
//           ))}
//         </tbody>
//       </table>

//       <div className="converter-pagination">
//         <button disabled={page === 1} onClick={() => setPage(page - 1)}>Prev</button>
//         <span>Page {page} / {totalPages}</span>
//         <button disabled={page === totalPages} onClick={() => setPage(page + 1)}>Next</button>
//       </div>
//     </div>
//   );
// }


// import React, { useEffect, useState } from 'react';
// import Select, { components } from 'react-select';
// import ReactCountryFlag from 'react-country-flag';
// import { clientConvert, clientGetConversions } from '../api';
// import HistoryChart from './HistoryChart';
// import './Converter.css';
// import QrResult from "./QrResult";

// export default function Converter({ token, email, logout }) {
//   const [amount, setAmount] = useState(1);
//   const [from, setFrom] = useState('USD');
//   const [to, setTo] = useState('INR');
//   const [result, setResult] = useState(null);
//   const [loading, setLoading] = useState(false);
//   const [currencies, setCurrencies] = useState({});
//   const [error, setError] = useState(null);
//   const [days, setDays] = useState(7);
//   const [conversions, setConversions] = useState([]);
//   const [page, setPage] = useState(1);
//   const [showQR, setShowQR] = useState(false); // 👈 NEW STATE
//   const perPage = 5;

//   // Flag map
//   const currencyCountryMap = {
//     USD: "US", EUR: "EU", INR: "IN", GBP: "GB", JPY: "JP",
//     AUD: "AU", CAD: "CA", CHF: "CH", CNY: "CN", SGD: "SG",
//     NZD: "NZ", HKD: "HK", SEK: "SE", NOK: "NO", MXN: "MX",
//     ZAR: "ZA", TRY: "TR", BRL: "BR", RUB: "RU", KRW: "KR",
//     DKK: "DK", PLN: "PL", THB: "TH", IDR: "ID", MYR: "MY",
//     PHP: "PH", VND: "VN", AED: "AE", PKR: "PK", LKR: "LK",
//   };

//   const getCountryCode = (code) => currencyCountryMap[code] || code.slice(0,2).toUpperCase();

//   const unsupportedCurrencies = [
//     "XCD", "ANG", "XPF", "XAF", "XOF", "XDR", "WST", "CW",
//   ];

//   useEffect(() => {
//     fetchCurrencies();
//     if (token) fetchConversions();
//   }, [token]);

//   const fetchCurrencies = async () => {
//     try {
//       const res = await fetch('http://192.168.0.102:8000/currencies');
//       const data = await res.json();
//       if (data.success && data.codes) {
//         const sortedCodes = Object.keys(data.codes).sort().reduce((acc, key) => {
//           acc[key] = data.codes[key];
//           return acc;
//         }, {});
//         setCurrencies(sortedCodes);
//       }
//     } catch (e) {
//       console.error("Error fetching currencies:", e);
//     }
//   };

//   const swap = () => {
//     setFrom(to);
//     setTo(from);
//     setResult(null);
//     setShowQR(false); // reset QR on swap
//   };

//   const handleConvert = async () => {
//     if (!token) return alert("Please login first!");

//     setLoading(true);
//     setError(null);
//     setShowQR(false); // reset QR on new conversion

//     try {
//       const res = await clientConvert(token, from, to, parseFloat(amount));
//       setResult(res.data);
//       fetchConversions();
//     } catch (e) {
//       setError(e.response?.data?.detail || e.message);
//     } finally {
//       setLoading(false);
//     }
//   };

//   const fetchConversions = async () => {
//     if (!token) return;
//     try {
//       const res = await clientGetConversions(token);
//       const sorted = res.data.sort((a,b) => new Date(b.timestamp)-new Date(a.timestamp));
//       setConversions(sorted);
//     } catch (e) {
//       console.error("Error fetching history:", e);
//     }
//   };

//   const start = (page - 1) * perPage;
//   const paginated = conversions.slice(start, start + perPage);
//   const totalPages = Math.ceil(conversions.length / perPage);

//   const supportedCurrencies = Object.keys(currencies).filter(
//     code => !unsupportedCurrencies.includes(code)
//   );

//   const options = supportedCurrencies.map(code => ({
//     value: code,
//     label: `${code} — ${currencies[code]}`,
//     countryCode: getCountryCode(code)
//   }));

//   const Option = (props) => (
//     <components.Option {...props}>
//       <ReactCountryFlag
//         countryCode={props.data.countryCode}
//         svg
//         style={{ width: '20px', height: '20px', marginRight: '8px' }}
//       />
//       {props.data.label}
//     </components.Option>
//   );

//   const SingleValue = (props) => (
//     <components.SingleValue {...props}>
//       <ReactCountryFlag
//         countryCode={props.data.countryCode}
//         svg
//         style={{ width: '20px', height: '20px', marginRight: '8px' }}
//       />
//       {props.data.label}
//     </components.SingleValue>
//   );

//   return (
//     <div className="converter-container">
//       <div className="converter-header">
//         <h2>Conversions</h2>
//         <button className="logout-btn" onClick={logout}>Logout</button>
//       </div>

//       <div className="converter-form">
//         <input
//           type="number"
//           value={amount}
//           onChange={e => setAmount(e.target.value)}
//           className="converter-input"
//           placeholder="Amount"
//         />

//         <div className="converter-dropdowns">
//           <Select
//             value={options.find(o => o.value === from)}
//             onChange={opt => setFrom(opt.value)}
//             options={options}
//             isSearchable
//             components={{ Option, SingleValue }}
//             placeholder="From"
//             styles={{
//               control: base => ({ ...base, minHeight: '40px', borderRadius: '8px', width: '270px' }),
//             }}
//           />

//           <button className="swap-btn" onClick={swap}>⇄</button>

//           <Select
//             value={options.find(o => o.value === to)}
//             onChange={opt => setTo(opt.value)}
//             options={options}
//             isSearchable
//             components={{ Option, SingleValue }}
//             placeholder="To"
//             styles={{
//               control: base => ({ ...base, minHeight: '40px', borderRadius: '8px', width: '270px' }),
//             }}
//           />
//         </div>

//         <button className="convert-btn" onClick={handleConvert} disabled={loading}>
//           {loading ? 'Converting...' : 'Convert'}
//         </button>
//       </div>

//       {error && <div className="converter-error">{error}</div>}

//       {result && (
//         <div className="converter-result">
//           {/* <div>Rate: </div> */}
//           {/* <h3>{amount} {from} = {result.result} {to}</h3> */}
//          {result && amount && (
//     <>
//       <div>Rate: {result.rate ? parseFloat(result.rate).toFixed(4) : "—"}</div>
//       <div>
//         Exchange Rate (1 {from} → {to}): {(parseFloat(result.result) / parseFloat(amount)).toFixed(4)}
//       </div>

//       {/* Converted Amount */}
//       <h2>
//         {amount} {from} = {parseFloat(result.result).toFixed(4)} {to}
//       </h2>
//     </>
//   )}
         

//           <div className="converter-history-select">
//             <label>History (days)</label>
//             <select value={days} onChange={e => setDays(parseInt(e.target.value))}>
//               <option value={7}>7</option>
//               <option value={14}>14</option>
//               {/* <option value={30}>30</option> */}
//             </select>
//           </div>

//           <HistoryChart base={from} target={to} days={days} />

//           {/* QR BUTTON */}
//           <button
//             className="qr-btn"
//             onClick={() => setShowQR(!showQR)}
//           >
//             {showQR ? "Hide QR Code" : "Generate QR Code"}
//           </button>

//           {/* SHOW QR ONLY WHEN CLICKED */}
//           {showQR && (
//             <QrResult
//   value={`
// Currency Conversion Result

// Amount: ${amount} ${from}
// Converted To: ${to}
// Exchange Rate: 1 ${from} = ${(parseFloat(result.result) / parseFloat(amount)).toFixed(4)} ${to}

// Converted Amount: ${parseFloat(result.result).toFixed(4)} ${to}

// Date & Time: ${new Date().toLocaleString()}
// Source: CurrencyPro Converter
// `}
// />
//           )}

//         </div>
//       )}

//       <h3>Your Conversion History</h3>
//       <table className="conversion-table">
//         <thead>
//           <tr>
//             <th>#</th>
//             <th>Time</th>
//             <th>From</th>
//             <th>To</th>
//             <th>Amount</th>
//             <th>Result</th>
//             <th>Rate</th>
//           </tr>
//         </thead>
//         <tbody>
//           {paginated.map((c, i) => (
//             <tr key={c.id}>
//               <td>{start + i + 1}</td>
//               <td>{new Date(c.timestamp).toLocaleString()}</td>
//               <td>
//                 <ReactCountryFlag countryCode={getCountryCode(c.from_currency)} svg />
//                 {c.from_currency}
//               </td>
//               <td>
//                 <ReactCountryFlag countryCode={getCountryCode(c.to_currency)} svg />
//                 {c.to_currency}
//               </td>
//               <td>{c.amount}</td>
//               <td>{c.result}</td>
//               <td>{c.rate}</td>
//             </tr>
//           ))}
//         </tbody>
//       </table>

//       <div className="converter-pagination">
//         <button disabled={page === 1} onClick={() => setPage(page - 1)}>Prev</button>
//         <span>Page {page} / {totalPages}</span>
//         <button disabled={page === totalPages} onClick={() => setPage(page + 1)}>Next</button>
//       </div>
//     </div>
//   );
// }



// import React, { useEffect, useState } from 'react';
// import Select, { components } from 'react-select';
// import ReactCountryFlag from 'react-country-flag';
// import { clientConvert, clientGetConversions } from '../api';
// import HistoryChart from './HistoryChart';
// import './Converter.css';
// import QrResult from "./QrResult";


// export default function Converter({ token, email, logout }) {
//   const [amount, setAmount] = useState(1);
//   const [from, setFrom] = useState('USD');
//   const [to, setTo] = useState('INR');
//   const [result, setResult] = useState(null);
//   const [loading, setLoading] = useState(false);
//   const [currencies, setCurrencies] = useState({});
//   const [error, setError] = useState(null);
//   const [days, setDays] = useState(7);
//   const [conversions, setConversions] = useState([]);
//   const [page, setPage] = useState(1);
//   const [showQR, setShowQR] = useState(false); 
//   const perPage = 5;

//   // Flag map
//   const currencyCountryMap = {
//     USD: "US", EUR: "EU", INR: "IN", GBP: "GB", JPY: "JP",
//     AUD: "AU", CAD: "CA", CHF: "CH", CNY: "CN", SGD: "SG",
//     NZD: "NZ", HKD: "HK", SEK: "SE", NOK: "NO", MXN: "MX",
//     ZAR: "ZA", TRY: "TR", BRL: "BR", RUB: "RU", KRW: "KR",
//     DKK: "DK", PLN: "PL", THB: "TH", IDR: "ID", MYR: "MY",
//     PHP: "PH", VND: "VN", AED: "AE", PKR: "PK", LKR: "LK",
//   };

//   const getCountryCode = (code) => currencyCountryMap[code] || code.slice(0,2).toUpperCase();

//   // ❗ Unsupported currencies (no flags)
//   const unsupportedCurrencies = [
//     "XCD", "ANG", "XPF", "XAF", "XOF", "XDR", "WST",   "CW",
//   ];

//   useEffect(() => {
//     fetchCurrencies();
//     if (token) fetchConversions();
//   }, [token]);

//   const fetchCurrencies = async () => {
//     try {
//       const res = await fetch('http://localhost:8000/currencies');
//       const data = await res.json();
//       if (data.success && data.codes) {
//         const sortedCodes = Object.keys(data.codes).sort().reduce((acc, key) => {
//           acc[key] = data.codes[key];
//           return acc;
//         }, {});
//         setCurrencies(sortedCodes);
//       }
//     } catch (e) {
//       console.error("Error fetching currencies:", e);
//     }
//   };

//   const swap = () => {
//     setFrom(to);
//     setTo(from);
//     setResult(null);
//   };

//   const handleConvert = async () => {
//     if (!token) return alert("Please login first!");

//     setLoading(true);
//     setError(null);
//     try {
//       const res = await clientConvert(token, from, to, parseFloat(amount));
//       setResult(res.data);
//       fetchConversions();
//     } catch (e) {
//       setError(e.response?.data?.detail || e.message);
//     } finally {
//       setLoading(false);
//     }
//   };

//   const fetchConversions = async () => {
//     if (!token) return;
//     try {
//       const res = await clientGetConversions(token);
//       const sorted = res.data.sort((a,b) => new Date(b.timestamp)-new Date(a.timestamp));
//       setConversions(sorted);
//     } catch (e) {
//       console.error("Error fetching history:", e);
//     }
//   };

//   const start = (page - 1) * perPage;
//   const paginated = conversions.slice(start, start + perPage);
//   const totalPages = Math.ceil(conversions.length / perPage);

//   // ✅ Filter out currencies with missing flags
//   const supportedCurrencies = Object.keys(currencies).filter(
//     code => !unsupportedCurrencies.includes(code)
//   );

//   const options = supportedCurrencies.map(code => ({
//     value: code,
//     label: `${code} — ${currencies[code]}`,
//     countryCode: getCountryCode(code)
//   }));

//   // React-select with flags
//   const Option = (props) => (
//     <components.Option {...props}>
//       <ReactCountryFlag
//         countryCode={props.data.countryCode}
//         svg
//         style={{ width: '20px', height: '20px', marginRight: '8px' }}
//       />
//       {props.data.label}
//     </components.Option>
//   );

//   const SingleValue = (props) => (
//     <components.SingleValue {...props}>
//       <ReactCountryFlag
//         countryCode={props.data.countryCode}
//         svg
//         style={{ width: '20px', height: '20px', marginRight: '8px' }}
//       />
//       {props.data.label}
//     </components.SingleValue>
//   );

//   return (
    
//     <div className="converter-container">
//       <div className="converter-header">
//         <h2>Conversions</h2>
//         <button className="logout-btn" onClick={logout}>Logout</button>
//       </div>

//       <div className="converter-form">
//         <input
//           type="number"
//           value={amount}
//           onChange={e => setAmount(e.target.value)}
//           className="converter-input"
//           placeholder="Amount"
//         />

//         <div className="converter-dropdowns">
//           <Select
//             value={options.find(o => o.value === from)}
//             onChange={opt => setFrom(opt.value)}
//             options={options}
//             isSearchable
//             components={{ Option, SingleValue }}
//             placeholder="From"
//             styles={{
//               control: base => ({ ...base, minHeight: '40px', borderRadius: '8px', width: '270px' }),
//             }}
//           />

//           <button className="swap-btn" onClick={swap}>⇄</button>

//           <Select
//             value={options.find(o => o.value === to)}
//             onChange={opt => setTo(opt.value)}
//             options={options}
//             isSearchable
//             components={{ Option, SingleValue }}
//             placeholder="To"
//             styles={{
//               control: base => ({ ...base, minHeight: '40px', borderRadius: '8px', width: '270px' }),
//             }}
//           />
//         </div>

//         <button className="convert-btn" onClick={handleConvert} disabled={loading}>
//           {loading ? 'Converting...' : 'Convert'}
//         </button>
//       </div>

//       {error && <div className="converter-error">{error}</div>}

//       {result && (
//         <div className="converter-result">
//           <div>Rate: {result.rate}</div>
//           <h3>{amount} {from} = {result.result} {to}</h3>

//           <div className="converter-history-select">
//             <label>History (days)</label>
//             <select value={days} onChange={e => setDays(parseInt(e.target.value))}>
//               <option value={7}>7</option>
//               <option value={14}>14</option>
//               <option value={30}>30</option>
//             </select>
//           </div>

//           <HistoryChart base={from} target={to} days={days} />
//           <QrResult
//  value={`
// Currency Conversion Result

// Amount: ${amount} ${from}
// Converted To: ${to}
// Exchange Rate: 1 ${from} = ${result.rate} ${to}
// Converted Amount: ${result.result} ${to}

// Date & Time: ${new Date().toLocaleString()}
// Source: Currency Converter App
// `}
// />

//         </div>
//       )}

//       <h3>Your Conversion History</h3>
//       <table className="conversion-table">
//         <thead>
//           <tr>
//             <th>#</th>
//             <th>Time</th>
//             <th>From</th>
//             <th>To</th>
//             <th>Amount</th>
//             <th>Result</th>
//             <th>Rate</th>
//           </tr>
//         </thead>
//         <tbody>
//           {paginated.map((c, i) => (
//             <tr key={c.id}>
//               <td>{start + i + 1}</td>
//               <td>{new Date(c.timestamp).toLocaleString()}</td>
//               <td>
//                 <ReactCountryFlag countryCode={getCountryCode(c.from_currency)} svg />
//                 {c.from_currency}
//               </td>
//               <td>
//                 <ReactCountryFlag countryCode={getCountryCode(c.to_currency)} svg />
//                 {c.to_currency}
//               </td>
//               <td>{c.amount}</td>
//               <td>{c.result}</td>
//               <td>{c.rate}</td>
//             </tr>
//           ))}
//         </tbody>
//       </table>

//       <div className="converter-pagination">
//         <button disabled={page === 1} onClick={() => setPage(page - 1)}>Prev</button>
//         <span>Page {page} / {totalPages}</span>
//         <button disabled={page === totalPages} onClick={() => setPage(page + 1)}>Next</button>
//       </div>
//     </div>
//   );
// }





// import React, { useEffect, useState } from 'react';
// import Select, { components } from 'react-select';
// import ReactCountryFlag from 'react-country-flag';
// import { clientConvert, clientGetConversions } from '../api';
// import HistoryChart from './HistoryChart';
// import './Converter.css';

// export default function Converter({ token, email, logout }) {
//   const [amount, setAmount] = useState(1);
//   const [from, setFrom] = useState('USD');
//   const [to, setTo] = useState('INR');
//   const [result, setResult] = useState(null);
//   const [loading, setLoading] = useState(false);
//   const [currencies, setCurrencies] = useState({});
//   const [error, setError] = useState(null);
//   const [days, setDays] = useState(7);
//   const [conversions, setConversions] = useState([]);
//   const [page, setPage] = useState(1);
//   const perPage = 5;

//   // Map currency to country code (for flags)
//   const currencyCountryMap = {
//     USD: "US", EUR: "EU", INR: "IN", GBP: "GB", JPY: "JP",
//     AUD: "AU", CAD: "CA", CHF: "CH", CNY: "CN", SGD: "SG",
//     NZD: "NZ", HKD: "HK", SEK: "SE", NOK: "NO", MXN: "MX",
//     ZAR: "ZA", TRY: "TR", BRL: "BR", RUB: "RU", KRW: "KR",
//     DKK: "DK", PLN: "PL", THB: "TH", IDR: "ID", MYR: "MY",
//     PHP: "PH", VND: "VN", AED: "AE", PKR: "PK", LKR: "LK",
//   };
//    // 🚫 Block unsupported currencies (these will not show in dropdown)
//    const unsupportedCurrencies = [
//     "XCD", "ANG", "XPF", "XAF", "XOF", "XDR", "WST"
//      ];
//   const getCountryCode = (code) => currencyCountryMap[code] || code.slice(0,2).toUpperCase();

//   // Fetch currencies from API
//   useEffect(() => {
//     fetchCurrencies();
//     if (token) fetchConversions();
//   }, [token]);

//   const fetchCurrencies = async () => {
//     try {
//       const res = await fetch('http://localhost:8000/currencies');
//       const data = await res.json();
//       if (data.success && data.codes) {
//         // Sort A→Z
//         const sortedCodes = Object.keys(data.codes).sort().reduce((acc, key) => {
//           acc[key] = data.codes[key];
//           return acc;
//         }, {});
//         setCurrencies(sortedCodes);
//       }
//     } catch (e) {
//       console.error("Error fetching currencies:", e);
//     }
//   };

//   const swap = () => {
//     setFrom(to);
//     setTo(from);
//     setResult(null);
//   };

//   const handleConvert = async () => {
//     if (!token) return alert("Please login first!");
//     setLoading(true);
//     setError(null);
//     try {
//       const res = await clientConvert(token, from, to, parseFloat(amount));
//       setResult(res.data);
//       fetchConversions();
//     } catch (e) {
//       setError(e.response?.data?.detail || e.message);
//     } finally {
//       setLoading(false);
//     }
//   };

//   const fetchConversions = async () => {
//     if (!token) return;
//     try {
//       const res = await clientGetConversions(token);
//       const sorted = res.data.sort((a,b) => new Date(b.timestamp)-new Date(a.timestamp));
//       setConversions(sorted);
//     } catch (e) {
//       console.error("Error fetching history:", e);
//     }
//   };

//   const start = (page - 1) * perPage;
//   const paginated = conversions.slice(start, start + perPage);
//   const totalPages = Math.ceil(conversions.length / perPage);

//   // react-select options with flags
//   const options = Object.keys(currencies).map(code => ({
//     value: code,
//     label: `${code} — ${currencies[code]}`,
//     countryCode: getCountryCode(code)
//   }));

//   const Option = (props) => (
//     <components.Option {...props}>
//       <ReactCountryFlag
//         countryCode={props.data.countryCode}
//         svg
//         style={{ width: '20px', height: '20px', marginRight: '8px' }}
//       />
//       {props.data.label}
//     </components.Option>
//   );

//   const SingleValue = (props) => (
//     <components.SingleValue {...props}>
//       <ReactCountryFlag
//         countryCode={props.data.countryCode}
//         svg
//         style={{ width: '20px', height: '20px', marginRight: '8px' }}
//       />
//       {props.data.label}
//     </components.SingleValue>
//   );

//   return (
//     <div className="converter-container">
//       <div className="converter-header">
//         <h2 className="converter-title">Conversions</h2>
//         <button className="logout-btn" onClick={logout}>Logout</button>
//       </div>

//       <div className="converter-form">
//         <input
//           type="number"
//           value={amount}
//           onChange={e => setAmount(e.target.value)}
//           className="converter-input"
//           placeholder="Amount"
//         />

//         <div className="converter-dropdowns">
//           <Select
//             value={options.find(o => o.value === from)}
//             onChange={opt => setFrom(opt.value)}
//             options={options}
//             isSearchable
//             components={{ Option, SingleValue }}
//             className="converter-select"
//             placeholder="From"
//             styles={{
//               control: base => ({ ...base, minHeight: '40px', borderRadius: '8px', width: '270px' }),
//               menu: base => ({ ...base, maxHeight: '300px' }),
//             }}
//             menuPortalTarget={document.body}
//             menuPosition="fixed"
//           />

//           <button className="swap-btn" onClick={swap}>⇄</button>

//           <Select
//             value={options.find(o => o.value === to)}
//             onChange={opt => setTo(opt.value)}
//             options={options}
//             isSearchable
//             components={{ Option, SingleValue }}
//             className="converter-select"
//             placeholder="To"
//             styles={{
//               control: base => ({ ...base, minHeight: '40px', borderRadius: '8px', width: '270px' }),
//               menu: base => ({ ...base, maxHeight: '300px' }),
//             }}
//             menuPortalTarget={document.body}
//             menuPosition="fixed"
//           />
//         </div>

//         <button className="convert-btn" onClick={handleConvert} disabled={loading}>
//           {loading ? 'Converting...' : 'Convert'}
//         </button>
//       </div>

//       {error && <div className="converter-error">{error}</div>}

//       {result && (
//         <div className="converter-result">
//           <div>Rate: {result.rate}</div>
//           <h3>{amount} {from} = {result.result} {to}</h3>

//           <div className="converter-history-select">
//             <label>History (days)</label>
//             <select value={days} onChange={e => setDays(parseInt(e.target.value))}>
//               <option value={7}>7</option>
//               <option value={14}>14</option>
//               <option value={30}>30</option>
//             </select>
//           </div>

//           <HistoryChart base={from} target={to} days={days} />
//         </div>
//       )}

//       <h3 className="converter-history-title">Your Conversion History</h3>
//       <div className="table-responsive">
//         <table className="conversion-table">
//           <thead>
//             <tr>
//               <th>#</th>
//               <th>Time</th>
//               <th>From</th>
//               <th>To</th>
//               <th>Amount</th>
//               <th>Result</th>
//               <th>Rate</th>
//             </tr>
//           </thead>
//           <tbody>
//             {paginated.map((c, i) => (
//               <tr key={c.id}>
//                 <td>{start + i + 1}</td>
//                 {/* <td>{new Date(c.timestamp).toLocaleString()}</td> */}
//                 <td>
//   {new Date(c.timestamp).toLocaleString(undefined, {
//     year: 'numeric',
//     month: 'short',
//     day: 'numeric',
//     hour: '2-digit',
//     minute: '2-digit',
//     second: '2-digit',
//   })}
// </td>

//                 <td>
//                   <ReactCountryFlag countryCode={getCountryCode(c.from_currency)} svg style={{ width: '20px', marginRight: '5px' }} />
//                   {c.from_currency}
//                 </td>
//                 <td>
//                   <ReactCountryFlag countryCode={getCountryCode(c.to_currency)} svg style={{ width: '20px', marginRight: '5px' }} />
//                   {c.to_currency}
//                 </td>
//                 <td>{c.amount}</td>
//                 <td>{c.result}</td>
//                 <td>{c.rate}</td>
//               </tr>
//             ))}
//           </tbody>
//         </table>
//       </div>

//       <div className="converter-pagination">
//         <button disabled={page === 1} onClick={() => setPage(page - 1)}>Prev</button>
//         <span>Page {page} / {totalPages}</span>
//         <button disabled={page === totalPages} onClick={() => setPage(page + 1)}>Next</button>
//       </div>
//     </div>
//   );
// }





// import React, { useEffect, useState } from 'react';
// import Select, { components } from 'react-select';
// import ReactCountryFlag from 'react-country-flag';
// import { clientConvert, clientGetConversions } from '../api';
// import HistoryChart from './HistoryChart';
// import './Converter.css';

// export default function Converter({ token, email, logout }) {
//   const [amount, setAmount] = useState(1);
//   const [from, setFrom] = useState('USD');
//   const [to, setTo] = useState('INR');
//   const [result, setResult] = useState(null);
//   const [loading, setLoading] = useState(false);
//   const [currencies, setCurrencies] = useState({});
//   const [error, setError] = useState(null);
//   const [days, setDays] = useState(7);
//   const [conversions, setConversions] = useState([]);
//   const [page, setPage] = useState(1);
//   const perPage = 5;

//   // Map currency codes to country codes
//   const currencyCountryMap = {
//     USD: "US", EUR: "EU", INR: "IN", GBP: "GB", JPY: "JP",
//     AUD: "AU", CAD: "CA", CHF: "CH", CNY: "CN", SGD: "SG",
//     NZD: "NZ", HKD: "HK", SEK: "SE", NOK: "NO", MXN: "MX",
//     ZAR: "ZA", TRY: "TR", BRL: "BR", RUB: "RU", KRW: "KR",
//     DKK: "DK", PLN: "PL", THB: "TH", IDR: "ID", MYR: "MY",
//     PHP: "PH", VND: "VN", AED: "AE", PKR: "PK", LKR: "LK",
//   };

//   const getCountryCode = (code) => currencyCountryMap[code] || "UN";

//   useEffect(() => {
//     fetchCurrencies();
//     if (token) fetchConversions();
//   }, [token]);

//   const fetchCurrencies = async () => {
//     try {
//       const res = await fetch('http://localhost:8000/currencies');
//       const data = await res.json();
//       if (data.success) setCurrencies(data.codes);
//     } catch (e) {
//       console.error("Error fetching currencies:", e);
//     }
//   };

//   const swap = () => {
//     const t = from;
//     setFrom(to);
//     setTo(t);
//     setResult(null);
//   };

//   const handleConvert = async () => {
//     if (!token) return alert("Please login first!");
//     setLoading(true);
//     setError(null);
//     try {
//       const res = await clientConvert(token, from, to, parseFloat(amount));
//       setResult(res.data);
//       fetchConversions();
//     } catch (e) {
//       setError(e.response?.data?.detail || e.message);
//     } finally {
//       setLoading(false);
//     }
//   };

//   const fetchConversions = async () => {
//     if (!token) return;
//     try {
//       const res = await clientGetConversions(token);
//       const sorted = res.data.sort((a, b) => new Date(b.timestamp) - new Date(a.timestamp));
//       setConversions(sorted);
//     } catch (e) {
//       console.error("Error fetching history:", e);
//     }
//   };

//   // Pagination
//   const start = (page - 1) * perPage;
//   const paginated = conversions.slice(start, start + perPage);
//   const totalPages = Math.ceil(conversions.length / perPage);

//   // react-select options dynamically from API
//   const options = Object.keys(currencies).map(code => ({
//     value: code,
//     label: `${code} — ${currencies[code]}`,
//     countryCode: getCountryCode(code),
//   }));

//   // Custom Option component with flag
//   const Option = (props) => (
//     <components.Option {...props}>
//       <ReactCountryFlag
//         countryCode={props.data.countryCode}
//         svg
//         style={{ width: '20px', height: '20px', marginRight: '8px' }}
//       />
//       {props.data.label}
//     </components.Option>
//   );

//   // Custom SingleValue component for selected value
//   const SingleValue = (props) => (
//     <components.SingleValue {...props}>
//       <ReactCountryFlag
//         countryCode={props.data.countryCode}
//         svg
//         style={{ width: '20px', height: '20px', marginRight: '8px' }}
//       />
//       {props.data.label}
//     </components.SingleValue>
//   );

//   return (
//     <div className="converter-container">
//       {/* Header with Logout */}
//       <div className="converter-header">
//         <h2 className="converter-title">Conversions</h2>
//         <button className="logout-btn" onClick={logout}>Logout</button>
//       </div>

//       {/* Conversion Form */}
//       <div className="converter-form">
//         <input
//           type="number"
//           value={amount}
//           onChange={e => setAmount(e.target.value)}
//           className="converter-input"
//         />

//         <Select
//           value={options.find(o => o.value === from)}
//           onChange={opt => setFrom(opt.value)}
//           options={options}
//           isSearchable
//           components={{ Option, SingleValue }}
//           placeholder="From currency"
//           className="converter-select"
//           styles={{
//             control: base => ({ ...base, minHeight: '40px', borderRadius: '8px', width: '150px' }),
//             input: base => ({ ...base, margin: 0, width: '100%' }),
//           }}
//         />

//         <Select
//           value={options.find(o => o.value === to)}
//           onChange={opt => setTo(opt.value)}
//           options={options}
//           isSearchable
//           components={{ Option, SingleValue }}
//           placeholder="To currency"
//           className="converter-select"
//           styles={{
//             control: base => ({ ...base, minHeight: '40px', borderRadius: '8px', width: '150px' }),
//             input: base => ({ ...base, margin: 0, width: '100%' }),
//           }}
//         />

//         <div className="converter-buttons">
//           <button onClick={swap}>Swap</button>
//           <button onClick={handleConvert} disabled={loading}>
//             {loading ? 'Converting...' : 'Convert'}
//           </button>
//         </div>
//       </div>

//       {error && <div className="converter-error">{error}</div>}

//       {result && (
//         <div className="converter-result">
//           <div>Rate: {result.rate}</div>
//           <h3>{amount} {from} = {result.result} {to}</h3>

//           <div className="converter-history-select">
//             <label>History (days)</label>
//             <select value={days} onChange={e => setDays(parseInt(e.target.value))}>
//               <option value={7}>7</option>
//               <option value={14}>14</option>
//               <option value={30}>30</option>
//             </select>
//           </div>

//           <HistoryChart base={from} target={to} days={days} />
//         </div>
//       )}

//       <h3 className="converter-history-title">Your Conversion History</h3>
//       <div className="table-responsive">
//         <table className="conversion-table">
//           <thead>
//             <tr>
//               <th>#</th>
//               <th>Time</th>
//               <th>From</th>
//               <th>To</th>
//               <th>Amount</th>
//               <th>Result</th>
//               <th>Rate</th>
//             </tr>
//           </thead>
//           <tbody>
//             {paginated.map((c, i) => (
//               <tr key={c.id}>
//                 <td>{start + i + 1}</td>
//                 <td>{new Date(c.timestamp).toLocaleString()}</td>
//                 <td>
//                   <ReactCountryFlag countryCode={getCountryCode(c.from_currency)} svg style={{ width: '20px', marginRight: '5px' }} />
//                   {c.from_currency}
//                 </td>
//                 <td>
//                   <ReactCountryFlag countryCode={getCountryCode(c.to_currency)} svg style={{ width: '20px', marginRight: '5px' }} />
//                   {c.to_currency}
//                 </td>
//                 <td>{c.amount}</td>
//                 <td>{c.result}</td>
//                 <td>{c.rate}</td>
//               </tr>
//             ))}
//           </tbody>
//         </table>
//       </div>

//       <div className="converter-pagination">
//         <button disabled={page === 1} onClick={() => setPage(page - 1)}>Prev</button>
//         <span>Page {page} / {totalPages}</span>
//         <button disabled={page === totalPages} onClick={() => setPage(page + 1)}>Next</button>
//       </div>
//     </div>
//   );
// }







// import React, { useEffect, useState } from 'react';
// import { clientConvert, clientGetConversions } from '../api';
// import HistoryChart from './HistoryChart';
// import './Converter.css';

// export default function Converter({ token, email, logout }) {
//   const [amount, setAmount] = useState(1);
//   const [from, setFrom] = useState('USD');
//   const [to, setTo] = useState('INR');
//   const [result, setResult] = useState(null);
//   const [loading, setLoading] = useState(false);
//   const [currencies, setCurrencies] = useState({});
//   const [error, setError] = useState(null);
//   const [days, setDays] = useState(7);
//   const [conversions, setConversions] = useState([]);
//   const [page, setPage] = useState(1);
//   const perPage = 5;

//   useEffect(() => {
//     fetchCurrencies();
//     if (token) fetchConversions();
//   }, [token]);

//   const fetchCurrencies = async () => {
//     try {
//       const res = await fetch('http://localhost:8000/currencies');
//       const data = await res.json();
//       if (data.success) setCurrencies(data.codes);
//     } catch (e) {
//       console.error("Error fetching currencies:", e);
//     }
//   };

//   const swap = () => {
//     const t = from;
//     setFrom(to);
//     setTo(t);
//     setResult(null);
//   };

//   const handleConvert = async () => {
//     if (!token) return alert("Please login first!");
//     setLoading(true);
//     setError(null);
//     try {
//       const res = await clientConvert(token, from, to, parseFloat(amount));
//       setResult(res.data);
//       fetchConversions();
//     } catch (e) {
//       setError(e.response?.data?.detail || e.message);
//     } finally {
//       setLoading(false);
//     }
//   };

//   const fetchConversions = async () => {
//     if (!token) return;
//     try {
//       const res = await clientGetConversions(token);
//       setConversions(res.data);

//       const sorted = res.data.sort((a, b) => new Date(b.timestamp) - new Date(a.timestamp));
//       setConversions(sorted);
//     } catch (e) {
//       console.error("Error history:", e);
//     }
//   };

//   // Pagination
//   const start = (page - 1) * perPage;
//   const paginated = conversions.slice(start, start + perPage);
//   const totalPages = Math.ceil(conversions.length / perPage);

//   return (
//     <div className="converter-container">
//       {/* Header with Logout */}
//       <div className="converter-header">
//         <h2 className="converter-title">Conversions</h2>
//         <button className="logout-btn" onClick={logout || (() => {})}>Logout</button>
//       </div>

//       {/* Conversion Form */}
//       <div className="converter-form">
//         <input 
//           type="number"
//           value={amount}
//           onChange={e => setAmount(e.target.value)}
//           className="converter-input"
//         />
//         <select value={from} onChange={e => setFrom(e.target.value)} className="converter-select">
//           {Object.keys(currencies).map(c => (
//             <option key={c} value={c}>{c} - {currencies[c]}</option>
//           ))}
//         </select>
//         <select value={to} onChange={e => setTo(e.target.value)} className="converter-select">
//           {Object.keys(currencies).map(c => (
//             <option key={c} value={c}>{c} - {currencies[c]}</option>
//           ))}
//         </select>

//         <div className="converter-buttons">
//           <button onClick={swap}>Swap</button>
//           <button onClick={handleConvert} disabled={loading}>
//             {loading ? 'Converting...' : 'Convert'}
//           </button>
//         </div>
//       </div>

//       {error && <div className="converter-error">{error}</div>}

//       {result && (
//         <div className="converter-result">
//           <div>Rate: {result.rate}</div>
//           <h3>{result.amount} {result.from_currency} = {result.result} {result.to_currency}</h3>

//           <div className="converter-history-select">
//             <label>History (days)</label>
//             <select value={days} onChange={e => setDays(parseInt(e.target.value))}>
//               <option value={7}>7</option>
//               <option value={14}>14</option>
//               <option value={30}>30</option>
//             </select>
//           </div>

//           <HistoryChart base={from} target={to} days={days} />
//         </div>
//       )}

//       <h3 className="converter-history-title">Your Conversion History</h3>
//       <div className="table-responsive">
//         <table className="conversion-table">
//           <thead>
//             <tr>
//               <th>#</th>
//               <th>Time</th>
//               <th>From</th>
//               <th>To</th>
//               <th>Amount</th>
//               <th>Result</th>
//               <th>Rate</th>
//             </tr>
//           </thead>
//           <tbody>
//             {paginated.map((c, i) => (
//               <tr key={c.id}>
//                 <td>{start + i + 1}</td>
//                 <td>{new Date(c.timestamp).toLocaleString()}</td>
//                 <td>{c.from_currency}</td>
//                 <td>{c.to_currency}</td>
//                 <td>{c.amount}</td>
//                 <td>{c.result}</td>
//                 <td>{c.rate}</td>
//               </tr>
//             ))}
//           </tbody>
//         </table>
//       </div>

//       <div className="converter-pagination">
//         <button disabled={page === 1} onClick={() => setPage(page - 1)}>Prev</button>
//         <span>Page {page} / {totalPages}</span>
//         <button disabled={page === totalPages} onClick={() => setPage(page + 1)}>Next</button>
//       </div>
//     </div>
//   );
// }





// import React, { useEffect, useState } from 'react';
// import { clientConvert, clientGetConversions } from '../api'; // import client API functions
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

//   // Load currencies and conversion history on mount
//   useEffect(() => {
//     fetchCurrencies();
//     if (token) fetchConversions();
//   }, [token]);

//   // Fetch available currencies
//   const fetchCurrencies = async () => {
//     try {
//       const res = await fetch('http://localhost:8000/currencies');
//       const data = await res.json();
//       if (data.success) setCurrencies(data.codes);
//     } catch (e) {
//       console.error("Error fetching currencies:", e);
//     }
//   };

//   // Swap "from" and "to" currencies
//   const swap = () => {
//     const t = from;
//     setFrom(to);
//     setTo(t);
//     setResult(null);
//   };

//   // Handle currency conversion
//   const handleConvert = async () => {
//     if (!token) return alert("Please login first!");
//     setLoading(true);
//     setError(null);
//     try {
//       const res = await clientConvert(token, from, to, parseFloat(amount));
//       setResult(res.data);
//       fetchConversions(); // update history
//     } catch (e) {
//       setError(e.response?.data?.detail || e.message);
//     } finally {
//       setLoading(false);
//     }
//   };

//   // Fetch user's conversion history
//   const fetchConversions = async () => {
//     if (!token) return;
//     try {
//       const res = await clientGetConversions(token);
//       setConversions(res.data);
//     } catch (e) {
//       console.error("Error fetching conversions:", e.response?.data || e.message);
//     }
//   };

//   return (
//     <div className="card" style={{ padding: 16, marginTop: 12 }}>
//       <h2>Welcome, {email}</h2>

//       <div style={{ display: 'flex', marginTop: 12, alignItems: 'center' }}>
//         <input 
//           type="number" 
//           value={amount} 
//           onChange={e => setAmount(e.target.value)} 
//           style={{ width: 80, marginRight: 8 }}
//         />
//         <select value={from} onChange={e => setFrom(e.target.value)}>
//           {Object.keys(currencies).map(c => (
//             <option key={c} value={c}>{c} - {currencies[c]}</option>
//           ))}
//         </select>
//         <select value={to} onChange={e => setTo(e.target.value)} style={{ marginLeft: 8 }}>
//           {Object.keys(currencies).map(c => (
//             <option key={c} value={c}>{c} - {currencies[c]}</option>
//           ))}
//         </select>
//         <div style={{ display: 'flex', flexDirection: 'column', marginLeft: 8 }}>
//           <button onClick={swap} style={{ marginBottom: 6 }}>Swap</button>
//           <button onClick={handleConvert} disabled={loading}>
//             {loading ? 'Converting...' : 'Convert'}
//           </button>
//         </div>
//       </div>

//       {error && <div style={{ color: 'red', marginTop: 10 }}>{error}</div>}

//       {result && (
//         <div style={{ marginTop: 12 }}>
//           <div>Rate: {result.rate}</div>
//           <h3>{result.amount} {result.from_currency} = {result.result} {result.to_currency}</h3>
//           <div style={{ marginTop: 12 }}>
//             <label>History (days)</label>
//             <select value={days} onChange={e => setDays(parseInt(e.target.value))}>
//               <option value={7}>7</option>
//               <option value={14}>14</option>
//               <option value={30}>30</option>
//             </select>
//             <HistoryChart base={from} target={to} days={days} />
//           </div>
//         </div>
//       )}

//       <div style={{ marginTop: 20 }}>
//         <h3>Your Conversion History</h3>
//         <div className="table-responsive">
//           <table className="conversion-table">
//             <thead>
//               <tr>
//                 <th>#</th>
//                 <th>Time</th>
//                 <th>From</th>
//                 <th>To</th>
//                 <th>Amount</th>
//                 <th>Result</th>
//                 <th>Rate</th>
//               </tr>
//             </thead>
//             <tbody>
//               {conversions.map((c, i) => (
//                 <tr key={c.id}>
//                   <td>{i + 1}</td>
//                   <td>{new Date(c.timestamp).toLocaleString()}</td>
//                   <td>{c.from_currency}</td>
//                   <td>{c.to_currency}</td>
//                   <td>{c.amount}</td>
//                   <td>{c.result}</td>
//                   <td>{c.rate}</td>
//                 </tr>
//               ))}
//             </tbody>
//           </table>
//         </div>
//       </div>
//     </div>
//   );
// }






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






