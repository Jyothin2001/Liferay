import React, { useState, useEffect } from "react";
import axios from "axios";

export default function AdminLogsFilter({ token }) {
  const [logs, setLogs] = useState([]);
  const [filters, setFilters] = useState({
    startDate: "",
    endDate: "",
    clientEmail: "",
    fromCurrency: "",
    toCurrency: ""
  });

  const fetchLogs = async () => {
    try {
      const res = await axios.get("http://localhost:8000/admin/conversions", {
        params: filters,
        headers: { Authorization: `Bearer ${token}` } // if you add auth
      });
      setLogs(res.data);
    } catch (err) {
      alert(err.message);
    }
  };

  useEffect(() => {
    if (token) fetchLogs();
  }, [token]);

  return (
    <div>
      <h3>Filter Conversion Logs</h3>

      <div style={{ display: "flex", gap: "10px", marginBottom: "10px" }}>
        <input
          type="date"
          value={filters.startDate}
          onChange={e => setFilters({ ...filters, startDate: e.target.value })}
        />
        <input
          type="date"
          value={filters.endDate}
          onChange={e => setFilters({ ...filters, endDate: e.target.value })}
        />
        <input
          type="text"
          placeholder="Client Email"
          value={filters.clientEmail}
          onChange={e => setFilters({ ...filters, clientEmail: e.target.value })}
        />
        <input
          type="text"
          placeholder="From Currency"
          value={filters.fromCurrency}
          onChange={e => setFilters({ ...filters, fromCurrency: e.target.value })}
        />
        <input
          type="text"
          placeholder="To Currency"
          value={filters.toCurrency}
          onChange={e => setFilters({ ...filters, toCurrency: e.target.value })}
        />
        <button onClick={fetchLogs}>Apply</button>
      </div>

      <table border="1" cellPadding="8" cellSpacing="0">
        <thead>
          <tr>
            <th>#</th>
            <th>Client</th>
            <th>Date</th>
            <th>From</th>
            <th>To</th>
            <th>Amount</th>
            <th>Result</th>
            <th>Rate</th>
          </tr>
        </thead>
        <tbody>
          {logs.map((log, idx) => (
            <tr key={log.id}>
              <td>{idx + 1}</td>
              <td>{log.client_email}</td>
              <td>{new Date(log.timestamp).toLocaleString()}</td>
              <td>{log.from_currency}</td>
              <td>{log.to_currency}</td>
              <td>{log.amount}</td>
              <td>{log.result}</td>
              <td>{log.rate}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}
