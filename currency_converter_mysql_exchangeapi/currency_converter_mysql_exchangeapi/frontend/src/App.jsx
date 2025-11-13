import React, { useState } from "react";
import Converter from './components/Converter';
import AdminPanel from './components/AdminPanel';
import { clientLogin , clientRegister,adminLogin } from "./api";
import './ClientView.css'; // path must be correct
import "./App.css";



export default function App() {
  const [view, setView] = useState('client'); // switch between client/admin

  // ----------------------------
  // Client states
  // ----------------------------
  const [clientEmail, setClientEmail] = useState("");
  const [clientPassword, setClientPassword] = useState("");
  const [clientToken, setClientToken] = useState(localStorage.getItem("client_token") || "");

  // ----------------------------
  // Admin states
  // ----------------------------
  const [adminEmail, setAdminEmail] = useState("");
  const [adminPassword, setAdminPassword] = useState("");
  const [adminToken, setAdminToken] = useState(localStorage.getItem("admin_token") || "");

  // ----------------------------
  // Client Handlers
  // ----------------------------
  const handleClientRegister = async () => {
    try {
      await clientRegister(clientEmail, clientPassword);
      alert("Registered successfully!");
    } catch(e) {
      alert(e.response?.data?.detail || "Registration failed");
    }
  };

  const handleClientLogin = async () => {
    try {
      const res = await clientLogin(clientEmail, clientPassword);
        console.log("✅ Login response:", res.data);
      setClientToken(res.data.access_token);
      localStorage.setItem("client_token", res.data.access_token);
    } catch(e) {
        console.error("❌ Login failed:");
      alert(e.response?.data?.detail || "Login failed");
    }
  };

//   const handleClientLogin = async () => {
//   try {
//     const res = await login(email, password);
//     setToken(res.data.access_token);
//     alert("Login successful!");
//   } catch (err) {
//     console.error("Login error:", err.response?.data || err.message);
//     alert("Login failed! Please check your credentials.");
//   }
// };


  const handleClientLogout = () => {
    setClientToken("");
    localStorage.removeItem("client_token");
  };

  // ----------------------------
  // Admin Handlers
  // ----------------------------
const handleAdminLogin = async () => {
  try {
    const res = await adminLogin(adminEmail, adminPassword);
    setAdminToken(res.data.access_token);
    localStorage.setItem("admin_token", res.data.access_token);
    alert(res.data.message); // shows "Login successful"
  } catch (e) {
    // Show proper backend validation messages
    alert(e.response?.data?.detail || "Admin login failed");
  }
};



  const handleAdminLogout = () => {
    setAdminToken("");
    localStorage.removeItem("admin_token");
  };

  // ----------------------------
  // Render
  // ----------------------------
  return (
  <div className="app-container">
    {/* ---------- Header ---------- */}
    <header className="app-header">
      <div className="header-container">
        <h1>CurrencyX — Pro Converter</h1>
        <div className="header-buttons">
          <button onClick={() => setView('client')}>Client</button>
          <button style={{ marginLeft: 8 }} onClick={() => setView('admin')}>Admin</button>
        </div>
      </div>
    </header>

    {/* ---------- Main Content (Your Existing JSX) ---------- */}
    <div className="container">
      {/* ---------------- Client View ---------------- */}
      {view === 'client' && (
        <div style={{ padding: "20px" }}>
          {!clientToken ? (
            <div>
              <h2>Client Login / Register</h2>
              <input
                placeholder="Email"
                value={clientEmail}
                onChange={e => setClientEmail(e.target.value)}
              />
              <input
                type="password"
                placeholder="Password"
                value={clientPassword}
                onChange={e => setClientPassword(e.target.value)}
              />
              <div style={{ marginTop: 8 }}>
                <button onClick={handleClientRegister}>Register</button>
                <button onClick={handleClientLogin} style={{ marginLeft: 8 }}>Login</button>
              </div>
            </div>
          ) : (
            <div>
              <button onClick={handleClientLogout} style={{ marginBottom: 10 }}>Logout</button>
              <Converter
                token={clientToken}
                email={clientEmail}
              />
            </div>
          )}
        </div>
      )}

      {/* ---------------- Admin View ---------------- */}
      {view === 'admin' && (
        <div style={{ padding: "20px" }}>
          {!adminToken ? (
            <div>
              <h2>Admin Login</h2>
              <input
                placeholder="Email"
                value={adminEmail}
                onChange={e => setAdminEmail(e.target.value)}
              />
              <input
                type="password"
                placeholder="Password"
                value={adminPassword}
                onChange={e => setAdminPassword(e.target.value)}
              />
              <button onClick={handleAdminLogin}>Login</button>
            </div>
          ) : (
            <div>
              <button onClick={handleAdminLogout} style={{ marginBottom: 10 }}>Logout</button>
              <AdminPanel token={adminToken} />
            </div>
          )}
        </div>
      )}
    </div>

    {/* ---------- Footer ---------- */}
    <footer className="app-footer">
      <div className="footer-container">
        <p>© 2025 CurrencyX. All rights reserved.</p>
        <p>Developed by Jyothi N</p>
      </div>
    </footer>
  </div>
);

}




// import React, { useState } from 'react';
// import Converter from './components/Converter';
// import AdminPanel from './components/AdminPanel';

// // import { useState, useEffect } from "react";
// // import { register, login, convert, getConversions } from "./api";

// export default function App() {
//   const [view, setView] = useState('client');
//   const backendURL = 'http://127.0.0.1:8000'; // your backend

//   return (
//     <div className="container">
//       <div className="header">
//         <h1>CurrencyX — Pro Converter</h1>
//         <div>
//           <button onClick={() => setView('client')}>Client</button>
//           <button style={{ marginLeft: 8 }} onClick={() => setView('admin')}>
//             Admin
//           </button>
//         </div>
//       </div>

//       {/* Render based on selected view */}
//       {view === 'client' && <Converter backendURL={backendURL} />}
//       {view === 'admin' && <AdminPanel backendURL={backendURL} />}
//     </div>
//   );
// }


