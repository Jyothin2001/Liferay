// import React, { useEffect, useState } from "react";
// import axios from "axios";
// import { BarChart, Bar, XAxis, YAxis, Tooltip, ResponsiveContainer } from "recharts";

// export default function AdminAnalytics({ token }) {
//   const [logs, setLogs] = useState([]);
//   const [users, setUsers] = useState([]);
//   const [loading, setLoading] = useState(true);

//   useEffect(() => {
//     const fetchData = async () => {
//       try {
//         const logRes = await axios.get("http://localhost:8000/admin/conversions", {
//           headers: { Authorization: `Bearer ${token}` }
//         });
//         setLogs(logRes.data);

//         const userRes = await axios.get("http://localhost:8000/admin/users", {
//           headers: { Authorization: `Bearer ${token}` }
//         });
//         setUsers(userRes.data);

//         setLoading(false);
//       } catch (e) {
//         alert(e.response?.data?.detail || e.message);
//       }
//     };
//     fetchData();
//   }, [token]);

//   if (loading) return <p>Loading...</p>;

//   // ---------------- Dashboard stats ----------------
//   const totalConversions = logs.length;
//   const totalClients = users.length;

//   // Popular currency pairs
//   const pairCounts = {};
//   logs.forEach(log => {
//     const pair = `${log.from_currency} → ${log.to_currency}`;
//     pairCounts[pair] = (pairCounts[pair] || 0) + 1;
//   });
//   const popularPairs = Object.entries(pairCounts)
//     .sort((a, b) => b[1] - a[1])
//     .slice(0, 5)
//     .map(([pair, count]) => ({ pair, count }));

//   // Daily conversions
//   const dailyCounts = {};
//   logs.forEach(log => {
//     const day = new Date(log.timestamp).toLocaleDateString();
//     dailyCounts[day] = (dailyCounts[day] || 0) + 1;
//   });
//   const dailyData = Object.entries(dailyCounts)
//     .map(([date, count]) => ({ date, count }))
//     .sort((a, b) => new Date(a.date) - new Date(b.date));

//   // ---------------- Export CSV ----------------
//   const exportCSV = () => {
//     if (!logs.length) return;

//     const headers = Object.keys(logs[0]);
//     const replacer = (key, value) => (value === null ? "" : value);
//     const csvRows = [
//       headers.join(","), // header row
//       ...logs.map(row =>
//         headers.map(field => JSON.stringify(row[field], replacer)).join(",")
//       )
//     ];

//     const csv = csvRows.join("\n");
//     const blob = new Blob([csv], { type: "text/csv;charset=utf-8;" });
//     const url = URL.createObjectURL(blob);
//     const link = document.createElement("a");
//     link.href = url;
//     link.setAttribute("download", `conversion_logs_${Date.now()}.csv`);
//     document.body.appendChild(link);
//     link.click();
//     document.body.removeChild(link);
//   };

//   return (
//     <div style={{ padding: "20px" }}>
//       <h2>Admin Analytics Dashboard</h2>

//       <div style={{ display: "flex", gap: "20px", marginBottom: "30px" }}>
//         <div style={{ background: "#1f3c88", color: "#fff", padding: "20px", borderRadius: "10px", flex: 1 }}>
//           <h3>Total Conversions</h3>
//           <p style={{ fontSize: "24px", fontWeight: "bold" }}>{totalConversions}</p>
//         </div>
//         <div style={{ background: "#3e8ed0", color: "#fff", padding: "20px", borderRadius: "10px", flex: 1 }}>
//           <h3>Total Clients</h3>
//           <p style={{ fontSize: "24px", fontWeight: "bold" }}>{totalClients}</p>
//         </div>
//       </div>

//       <div style={{ marginBottom: "30px" }}>
//         <h3>Popular Currency Pairs</h3>
//         <ul>
//           {popularPairs.map(p => (
//             <li key={p.pair}>
//               {p.pair}: {p.count} conversions
//             </li>
//           ))}
//         </ul>
//       </div>

//       <div style={{ marginBottom: "30px" }}>
//         <h3>Conversions per Day</h3>
//         <ResponsiveContainer width="100%" height={300}>
//           <BarChart data={dailyData}>
//             <XAxis dataKey="date" />
//             <YAxis />
//             <Tooltip />
//             <Bar dataKey="count" fill="#1f3c88" />
//           </BarChart>
//         </ResponsiveContainer>
//       </div>

//       <button
//         onClick={exportCSV}
//         style={{ padding: "10px 20px", borderRadius: "5px", cursor: "pointer" }}
//       >
//         Export Logs as CSV
//       </button>
//     </div>
//   );
// }
import React, { useEffect, useState } from "react";
import axios from "axios";
import { BarChart, Bar, XAxis, YAxis, Tooltip, ResponsiveContainer } from "recharts";
import "./AdminAnalytics.css";

export default function AdminAnalytics({ token }) {
  const [logs, setLogs] = useState([]);
  const [users, setUsers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [activeTab, setActiveTab] = useState("stats");

  useEffect(() => {
    const fetchData = async () => {
      try {
        const logRes = await axios.get("http://localhost:8000/admin/conversions", {
          headers: { Authorization: `Bearer ${token}` }
        });
        setLogs(Array.isArray(logRes.data) ? logRes.data : logRes.data.conversions || []);

        const userRes = await axios.get("http://localhost:8000/admin/users", {
          headers: { Authorization: `Bearer ${token}` }
        });
        setUsers(Array.isArray(userRes.data) ? userRes.data : userRes.data.users || []);

        setLoading(false);
      } catch (e) {
        alert(e.response?.data?.detail || e.message);
      }
    };
    fetchData();
  }, [token]);

  if (loading) return <p className="loading">Loading...</p>;

  // ---------------- Dashboard stats ----------------
  const totalConversions = logs.length;
  const totalClients = users.length;

  // Popular currency pairs
  const pairCounts = {};
  logs.forEach(log => {
    const pair = `${log.from_currency} → ${log.to_currency}`;
    pairCounts[pair] = (pairCounts[pair] || 0) + 1;
  });
  const popularPairs = Object.entries(pairCounts)
    .sort((a, b) => b[1] - a[1])
    .slice(0, 5)
    .map(([pair, count]) => ({ pair, count }));

  // Daily conversions
  const dailyCounts = {};
  logs.forEach(log => {
    const day = new Date(log.timestamp).toLocaleDateString();
    dailyCounts[day] = (dailyCounts[day] || 0) + 1;
  });
  const dailyData = Object.entries(dailyCounts)
    .map(([date, count]) => ({ date, count }))
    .sort((a, b) => new Date(a.date) - new Date(b.date));

  // Export CSV
  const exportCSV = () => {
    if (!logs.length) return;
    const headers = Object.keys(logs[0]);
    const replacer = (key, value) => (value === null ? "" : value);
    const csvRows = [
      headers.join(","),
      ...logs.map(row =>
        headers.map(field => JSON.stringify(row[field], replacer)).join(",")
      )
    ];
    const csv = csvRows.join("\n");
    const blob = new Blob([csv], { type: "text/csv;charset=utf-8;" });
    const url = URL.createObjectURL(blob);
    const link = document.createElement("a");
    link.href = url;
    link.setAttribute("download", `conversion_logs_${Date.now()}.csv`);
    document.body.appendChild(link);
    link.click();
    document.body.removeChild(link);
  };

  return (
    <div className="dashboard-container">
      <div className="header-with-export">
        <h2 className="dashboard-title">Admin Analytics Dashboard</h2>
       
      </div>

      <div className="tabs">
        {["stats", "pairs", "daily"].map(tab => (
          <button
            key={tab}
            className={`tab-btn ${activeTab === tab ? "active" : ""}`}
            onClick={() => setActiveTab(tab)}
          >
            {tab === "stats" ? "Stats" : tab === "pairs" ? "Popular Pairs" : "Daily Conversions"}
          </button>
        ))}
      </div>

      <div className="tab-content">
        {/* Stats Tab */}
        <div className={`tab-panel ${activeTab === "stats" ? "visible" : "hidden"}`}>
          <div className="stats-cards">
            <div className="card">
              <h3>Total Conversions</h3>
              <p>{totalConversions}</p>
            </div>
            <div className="card">
              <h3>Total Clients</h3>
              <p>{totalClients}</p>
            </div>
          </div>
        </div>

        {/* Popular Pairs Tab */}
        <div className={`tab-panel ${activeTab === "pairs" ? "visible" : "hidden"}`}>
          <h3>Popular Currency Pairs</h3>
          <ul className="pair-list">
            {popularPairs.map(p => (
              <li key={p.pair}>
                <strong>{p.pair}</strong>: {p.count} conversions
              </li>
            ))}
          </ul>
        </div>

        {/* Daily Conversions Tab */}
        <div className={`tab-panel ${activeTab === "daily" ? "visible" : "hidden"}`}>
          <h3>Conversions per Day</h3>
          <ResponsiveContainer width="100%" height={300}>
            <BarChart data={dailyData}>
              <XAxis dataKey="date" />
              <YAxis />
              <Tooltip />
              <Bar dataKey="count" fill="#1f3c88" />
            </BarChart>
          </ResponsiveContainer>
        </div>
         <button onClick={exportCSV} className="export-btn-top">Export Logs as CSV</button>
      </div>
    </div>
  );
}
