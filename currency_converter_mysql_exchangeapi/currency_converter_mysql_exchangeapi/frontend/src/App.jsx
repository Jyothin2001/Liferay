import React, { useState } from "react";
import Converter from './components/Converter';
import AdminPanel from './components/AdminPanel';
import { clientLogin, clientRegister } from "./api";
import './App.css';

export default function App() {
  // ---------------- Initialize tokens ----------------
  const [clientToken, setClientToken] = useState(localStorage.getItem("client_token") || "");
  const [adminToken, setAdminToken] = useState(localStorage.getItem("admin_token") || "");

  // ---------------- Initialize view based on tokens ----------------
  const [view, setView] = useState(() => {
    const savedView = localStorage.getItem("last_view");
    if (savedView) return savedView;
    if (localStorage.getItem("admin_token")) return "admin";
    return "client";
  });

  // ---------------- Client States ----------------
  const [clientEmail, setClientEmail] = useState("");
  const [clientPassword, setClientPassword] = useState("");
  const [termsAccepted, setTermsAccepted] = useState(false);

  // ---------------- Persist last view ----------------
  const saveView = (newView) => {
    setView(newView);
    localStorage.setItem("last_view", newView);
  };

  // ---------------- Client Handlers ----------------
  const handleClientRegister = async () => {
    if (!termsAccepted) {
      alert("Please accept the terms and conditions.");
      return;
    }
    try {
      await clientRegister(clientEmail, clientPassword);
      alert("Account created successfully! Check your email for a welcome message.");
    } catch (e) {
      alert(e.response?.data?.detail || "Registration failed");
    }
  };

  const handleClientLogin = async () => {
    try {
      const res = await clientLogin(clientEmail, clientPassword);
      setClientToken(res.data.access_token);
      localStorage.setItem("client_token", res.data.access_token);
      saveView("client");
    } catch (e) {
      alert(e.response?.data?.detail || "Login failed");
    }
  };

  const handleClientLogout = () => {
    setClientToken("");
    localStorage.removeItem("client_token");
    saveView("client");
  };

  const handleAdminLogout = () => {
    setAdminToken("");
    localStorage.removeItem("admin_token");
    saveView("admin");
  };

  return (
    <div className="app-container">
      {/* Header */}
      <header className="app-header">
        <div className="header-container">
          <h1>CurrencyX — Pro Converter</h1>
          <div className="header-buttons">
            <button className={view==='client'?'active':''} onClick={() => saveView('client')}>Register</button>
            <button className={view==='admin'?'active':''} onClick={() => saveView('admin')}>Admin</button>
          </div>
        </div>
      </header>

      {/* Main Content */}
      <main className="main-content">
        {/* Client View */}
        {view === 'client' && (
          <div className="client-container">
            {!clientToken ? (
              <div className="login-box">
                <h2>Sign In to Your Account</h2>
                <p>No account? Create one below.</p>
                <input
                  type="email"
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

                <div className="terms">
                  <input
                    type="checkbox"
                    checked={termsAccepted}
                    onChange={e => setTermsAccepted(e.target.checked)}
                  />{" "}
                  I agree to the <a href="#terms">Terms and Conditions</a>
                </div>

                <div className="button-group">
                  <button onClick={handleClientRegister}>Create Account</button>
                  <button onClick={handleClientLogin}>Sign In</button>
                </div>

                <div className="extra-info">
                  <p>By creating an account, you can track your conversions and get personalized rates.</p>
                </div>
              </div>
            ) : (
              <Converter token={clientToken} email={clientEmail} logout={handleClientLogout} />
            )}
          </div>
        )}

        {/* Admin View */}
        {view === 'admin' && (
          <div className="admin-container">
            <AdminPanel token={adminToken} onLogout={handleAdminLogout} setToken={setAdminToken} />
          </div>
        )}
      </main>

      {/* Footer */}
      <footer className="app-footer">
        <div className="footer-container">
          <p>© 2025 CurrencyX. All rights reserved.</p>
          <p>Developed by Jyothi N</p>
        </div>
      </footer>
    </div>
  );
}



// import React, { useState } from "react";
// import Converter from './components/Converter';
// import AdminPanel from './components/AdminPanel';
// import { clientLogin, clientRegister, adminLogin } from "./api";
// import './App.css';

// export default function App() {
//   // ---------------- Initialize tokens ----------------
//   const [clientToken, setClientToken] = useState(localStorage.getItem("client_token") || "");
//   const [adminToken, setAdminToken] = useState(localStorage.getItem("admin_token") || "");

//   // ---------------- Initialize view based on tokens ----------------
//   const [view, setView] = useState(() => {
//     const savedView = localStorage.getItem("last_view");
//     if (savedView) return savedView; // remember last view if saved
//     if (localStorage.getItem("admin_token")) return "admin";
//     return "client"; // default
//   });

//   // ---------------- Client States ----------------
//   const [clientEmail, setClientEmail] = useState("");
//   const [clientPassword, setClientPassword] = useState("");
//   const [termsAccepted, setTermsAccepted] = useState(false);

//   // ---------------- Admin States ----------------
//   const [adminEmail, setAdminEmail] = useState("");
//   const [adminPassword, setAdminPassword] = useState("");

//   // ---------------- Persist last view ----------------
//   const saveView = (newView) => {
//     setView(newView);
//     localStorage.setItem("last_view", newView);
//   };

//   // ---------------- Client Handlers ----------------
//   const handleClientRegister = async () => {
//     if (!termsAccepted) {
//       alert("Please accept the terms and conditions.");
//       return;
//     }
//     try {
//       await clientRegister(clientEmail, clientPassword);
//       alert("Account created successfully! Check your email for a welcome message.");
//     } catch (e) {
//       alert(e.response?.data?.detail || "Registration failed");
//     }
//   };

//   const handleClientLogin = async () => {
//     try {
//       const res = await clientLogin(clientEmail, clientPassword);
//       setClientToken(res.data.access_token);
//       localStorage.setItem("client_token", res.data.access_token);
//       saveView("client"); // ensure client view shows after login
//     } catch (e) {
//       alert(e.response?.data?.detail || "Login failed");
//     }
//   };

//   const handleClientLogout = () => {
//     setClientToken("");
//     localStorage.removeItem("client_token");
//     saveView("client"); // stay on client login page
//   };

//   // ---------------- Admin Handlers ----------------
//   const handleAdminLogin = async () => {
//     try {
//       const res = await adminLogin(adminEmail, adminPassword);
//       setAdminToken(res.data.access_token);
//       localStorage.setItem("admin_token", res.data.access_token);
//       saveView("admin"); // ensure admin view shows after login
//       alert("Admin login successful");
//     } catch (e) {
//       alert(e.response?.data?.detail || "Admin login failed");
//     }
//   };

//   const handleAdminLogout = () => {
//     setAdminToken("");
//     localStorage.removeItem("admin_token");
//     saveView("admin"); // stay on admin login page
//   };

//   return (
//     <div className="app-container">
//       {/* Header */}
//       <header className="app-header">
//         <div className="header-container">
//           <h1>CurrencyX — Pro Converter</h1>
//           <div className="header-buttons">
//             <button className={view==='client'?'active':''} onClick={() => saveView('client')}>Client</button>
//             <button className={view==='admin'?'active':''} onClick={() => saveView('admin')}>Admin</button>
//           </div>
//         </div>
//       </header>

//       {/* Main Content */}
//       <main className="main-content">
//         {/* Client View */}
//         {view === 'client' && (
//           <div className="client-container">
//             {!clientToken ? (
//               <div className="login-box">
//                 <h2>Sign In to Your Account</h2>
//                 <p>No account? Create one below.</p>
//                 <input
//                   type="email"
//                   placeholder="Email"
//                   value={clientEmail}
//                   onChange={e => setClientEmail(e.target.value)}
//                 />
//                 <input
//                   type="password"
//                   placeholder="Password"
//                   value={clientPassword}
//                   onChange={e => setClientPassword(e.target.value)}
//                 />

//                 <div className="terms">
//                   <input
//                     type="checkbox"
//                     checked={termsAccepted}
//                     onChange={e => setTermsAccepted(e.target.checked)}
//                   />{" "}
//                   I agree to the <a href="#terms">Terms and Conditions</a>
//                 </div>

//                 <div className="button-group">
//                   <button onClick={handleClientRegister}>Create Account</button>
//                   <button onClick={handleClientLogin}>Sign In</button>
//                 </div>

//                 <div className="extra-info">
//                   <p>By creating an account, you can track your conversions and get personalized rates.</p>
//                 </div>
//               </div>
//             ) : (
//               <>
//                 {/* <button className="logout-btn" onClick={handleClientLogout}>Logout</button> */}
//                 {/* <Converter token={clientToken} email={clientEmail} /> */}
//                 <Converter token={clientToken} email={clientEmail} logout={handleClientLogout} />

//               </>
//             )}
//           </div>
//         )}

//         {/* Admin View */}
//         {view === 'admin' && (
//           <div className="admin-container">
//             {!adminToken ? (
//               <div className="login-box">
//                 <h2>Admin Sign In</h2>
//                 <input
//                   type="email"
//                   placeholder="Email"
//                   value={adminEmail}
//                   onChange={e => setAdminEmail(e.target.value)}
//                 />
//                 <input
//                   type="password"
//                   placeholder="Password"
//                   value={adminPassword}
//                   onChange={e => setAdminPassword(e.target.value)}
//                 />
//                 <button onClick={handleAdminLogin}>Sign In</button>
//               </div>
//             ) : (
//               <AdminPanel token={adminToken} onLogout={handleAdminLogout} />
//             )}
//           </div>
//         )}
//       </main>

//       {/* Footer */}
//       <footer className="app-footer">
//         <div className="footer-container">
//           <p>© 2025 CurrencyX. All rights reserved.</p>
//           <p>Developed by Jyothi N</p>
//         </div>
//       </footer>
//     </div>
//   );
// }


// import React, { useState } from "react";
// import Converter from './components/Converter';
// import AdminPanel from './components/AdminPanel';
// import { clientLogin, clientRegister, adminLogin } from "./api";
// import './App.css';

// export default function App() {
//   const [view, setView] = useState('client');

//   // ---------------- Client States ----------------
//   const [clientEmail, setClientEmail] = useState("");
//   const [clientPassword, setClientPassword] = useState("");
//   const [clientToken, setClientToken] = useState(localStorage.getItem("client_token") || "");
//   const [termsAccepted, setTermsAccepted] = useState(false);

//   // ---------------- Admin States ----------------
//   const [adminEmail, setAdminEmail] = useState("");
//   const [adminPassword, setAdminPassword] = useState("");
//   const [adminToken, setAdminToken] = useState(localStorage.getItem("admin_token") || "");

//   // ---------------- Client Handlers ----------------
//   const handleClientRegister = async () => {
//     if (!termsAccepted) {
//       alert("Please accept the terms and conditions.");
//       return;
//     }

//     try {
//       await clientRegister(clientEmail, clientPassword);
//       alert("Account created successfully!");
//     } catch (e) {
//       alert(e.response?.data?.detail || "Registration failed");
//     }
//   };

//   const handleClientLogin = async () => {
//     try {
//       const res = await clientLogin(clientEmail, clientPassword);
//       setClientToken(res.data.access_token);
//       localStorage.setItem("client_token", res.data.access_token);
//     } catch (e) {
//       alert(e.response?.data?.detail || "Login failed");
//     }
//   };

//   const handleClientLogout = () => {
//     setClientToken("");
//     localStorage.removeItem("client_token");
//   };

//   // ---------------- Admin Handlers ----------------
//   const handleAdminLogin = async () => {
//     try {
//       const res = await adminLogin(adminEmail, adminPassword);
//       setAdminToken(res.data.access_token);
//       localStorage.setItem("admin_token", res.data.access_token);
//       alert("Admin login successful");
//     } catch (e) {
//       alert(e.response?.data?.detail || "Admin login failed");
//     }
//   };

//   const handleAdminLogout = () => {
//     setAdminToken("");
//     localStorage.removeItem("admin_token");
//   };

//   return (
//     <div className="app-container">
//       {/* Header */}
//       <header className="app-header">
//         <div className="header-container">
//           <h1>CurrencyX — Pro Converter</h1>
//           <div className="header-buttons">
//             <button className={view==='client'?'active':''} onClick={() => setView('client')}>Client</button>
//             <button className={view==='admin'?'active':''} onClick={() => setView('admin')}>Admin</button>
//           </div>
//         </div>
//       </header>

//       {/* Main Content */}
//       <main className="main-content">
//         {/* Client View */}
//         {view === 'client' && (
//           <div className="client-container">
//             {!clientToken ? (
//               <div className="login-box">
//                 <h2>Sign In to Your Account</h2>
//                 <p>No account? Create one below.</p>
//                 <input
//                   type="email"
//                   placeholder="Email"
//                   value={clientEmail}
//                   onChange={e => setClientEmail(e.target.value)}
//                 />
//                 <input
//                   type="password"
//                   placeholder="Password"
//                   value={clientPassword}
//                   onChange={e => setClientPassword(e.target.value)}
//                 />

//                 <div className="terms">
//                   <input
//                     type="checkbox"
//                     checked={termsAccepted}
//                     onChange={e => setTermsAccepted(e.target.checked)}
//                   />{" "}
//                   I agree to the <a href="#terms">Terms and Conditions</a>
//                 </div>

//                 <div className="button-group">
//                   <button onClick={handleClientRegister}>Create Account</button>
//                   <button onClick={handleClientLogin}>Sign In</button>
//                 </div>

//                 <div className="extra-info">
//                   <p>By creating an account, you can track your conversions and get personalized rates.</p>
//                 </div>
//               </div>
//             ) : (
//               <>
//                 <button className="logout-btn" onClick={handleClientLogout}>Logout</button>
//                 <Converter token={clientToken} email={clientEmail} />
//               </>
//             )}
//           </div>
//         )}

//         {/* Admin View */}
//         {view === 'admin' && (
//           <div className="admin-container">
//             {!adminToken ? (
//               <div className="login-box">
//                 <h2>Admin Sign In</h2>
//                 <input
//                   type="email"
//                   placeholder="Email"
//                   value={adminEmail}
//                   onChange={e => setAdminEmail(e.target.value)}
//                 />
//                 <input
//                   type="password"
//                   placeholder="Password"
//                   value={adminPassword}
//                   onChange={e => setAdminPassword(e.target.value)}
//                 />
//                 <button onClick={handleAdminLogin}>Sign In</button>
//               </div>
//             ) : (
//               <AdminPanel token={adminToken} onLogout={handleAdminLogout} />
//             )}
//           </div>
//         )}
//       </main>

//       {/* Footer */}
//       <footer className="app-footer">
//         <div className="footer-container">
//           <p>© 2025 CurrencyX. All rights reserved.</p>
//           <p>Developed by Jyothi N</p>
//         </div>
//       </footer>
//     </div>
//   );
// }




// import React, { useState } from "react";
// import Converter from './components/Converter';
// import AdminPanel from './components/AdminPanel';
// import { clientLogin, clientRegister, adminLogin } from "./api";
// import './App.css';

// export default function App() {
//   const [view, setView] = useState('client');

//   // ---------------- Client States ----------------
//   const [clientEmail, setClientEmail] = useState("");
//   const [clientPassword, setClientPassword] = useState("");
//   const [clientToken, setClientToken] = useState(localStorage.getItem("client_token") || "");
//   const [termsAccepted, setTermsAccepted] = useState(false);

//   // ---------------- Admin States ----------------
//   const [adminEmail, setAdminEmail] = useState("");
//   const [adminPassword, setAdminPassword] = useState("");
//   const [adminToken, setAdminToken] = useState(localStorage.getItem("admin_token") || "");

//   // ---------------- Client Handlers ----------------
//   const handleClientRegister = async () => {
//     if (!termsAccepted) {
//       alert("Please accept the terms and conditions.");
//       return;
//     }

//     try {
//       await clientRegister(clientEmail, clientPassword);
//       alert("Account created successfully!");
//     } catch (e) {
//       alert(e.response?.data?.detail || "Registration failed");
//     }
//   };

//   const handleClientLogin = async () => {
//     try {
//       const res = await clientLogin(clientEmail, clientPassword);
//       setClientToken(res.data.access_token);
//       localStorage.setItem("client_token", res.data.access_token);
//     } catch (e) {
//       alert(e.response?.data?.detail || "Login failed");
//     }
//   };

//   const handleClientLogout = () => {
//     setClientToken("");
//     localStorage.removeItem("client_token");
//   };

//   // ---------------- Admin Handlers ----------------
//   const handleAdminLogin = async () => {
//     try {
//       const res = await adminLogin(adminEmail, adminPassword);
//       setAdminToken(res.data.access_token);
//       localStorage.setItem("admin_token", res.data.access_token);
//       alert("Admin login successful");
//     } catch (e) {
//       alert(e.response?.data?.detail || "Admin login failed");
//     }
//   };

//   const handleAdminLogout = () => {
//     setAdminToken("");
//     localStorage.removeItem("admin_token");
//   };

//   return (
//     <div className="app-container">
//       {/* Header */}
//       <header className="app-header">
//         <div className="header-container">
//           <h1>CurrencyX — Pro Converter</h1>
//           <div className="header-buttons">
//             <button className={view==='client'?'active':''} onClick={() => setView('client')}>Client</button>
//             <button className={view==='admin'?'active':''} onClick={() => setView('admin')}>Admin</button>
//           </div>
//         </div>
//       </header>

//       {/* Main Content */}
//       <main className="main-content">
//         {/* Client View */}
//         {view === 'client' && (
//           <div className="client-container">
//             {!clientToken ? (
//               <>
//                 <h2>Sign In to Your Account</h2>
//                 <p>No account? Create one below.</p>
//                 <input
//                   type="email"
//                   placeholder="Email"
//                   value={clientEmail}
//                   onChange={e => setClientEmail(e.target.value)}
//                 />
//                 <input
//                   type="password"
//                   placeholder="Password"
//                   value={clientPassword}
//                   onChange={e => setClientPassword(e.target.value)}
//                 />

//                 <div className="terms">
//                   <input
//                     type="checkbox"
//                     checked={termsAccepted}
//                     onChange={e => setTermsAccepted(e.target.checked)}
//                   />{" "}
//                   I agree to the <a href="#terms">Terms and Conditions</a>
//                 </div>

//                 <div className="button-group">
//                   <button onClick={handleClientRegister}>Create Account</button>
//                   <button onClick={handleClientLogin}>Sign In</button>
//                 </div>

//                 <div className="extra-info">
//                   <p>By creating an account, you can track your conversions and get personalized rates.</p>
//                 </div>
//               </>
//             ) : (
//               <>
//                 <button className="logout-btn" onClick={handleClientLogout}>Logout</button>
//                 <Converter token={clientToken} email={clientEmail} />
//               </>
//             )}
//           </div>
//         )}

//         {/* Admin View */}
//         {view === 'admin' && (
//           <div className="admin-container">
//             {!adminToken ? (
//               <>
//                 <h2>Admin Sign In</h2>
//                 <input
//                   type="email"
//                   placeholder="Email"
//                   value={adminEmail}
//                   onChange={e => setAdminEmail(e.target.value)}
//                 />
//                 <input
//                   type="password"
//                   placeholder="Password"
//                   value={adminPassword}
//                   onChange={e => setAdminPassword(e.target.value)}
//                 />
//                 <button onClick={handleAdminLogin}>Sign In</button>
//               </>
//             ) : (
//               <>
//                 <div className="admin-header">
//                   <span className="logout-link" onClick={handleAdminLogout}>Logout</span>
//                 </div>
//                 <AdminPanel token={adminToken} />
//               </>
//             )}
//           </div>
//         )}
//       </main>

//       {/* Footer */}
//       <footer className="app-footer">
//         <div className="footer-container">
//           <p>© 2025 CurrencyX. All rights reserved.</p>
//           <p>Developed by Jyothi N</p>
//         </div>
//       </footer>
//     </div>
//   );
// }



// import React, { useState } from "react";
// import Converter from './components/Converter';
// import AdminPanel from './components/AdminPanel';
// import { clientLogin , clientRegister,adminLogin } from "./api";
// import './ClientView.css'; // path must be correct
// import "./App.css";



// export default function App() {
//   const [view, setView] = useState('client'); // switch between client/admin

//   // ----------------------------
//   // Client states
//   // ----------------------------
//   const [clientEmail, setClientEmail] = useState("");
//   const [clientPassword, setClientPassword] = useState("");
//   const [clientToken, setClientToken] = useState(localStorage.getItem("client_token") || "");

//   // ----------------------------
//   // Admin states
//   // ----------------------------
//   const [adminEmail, setAdminEmail] = useState("");
//   const [adminPassword, setAdminPassword] = useState("");
//   const [adminToken, setAdminToken] = useState(localStorage.getItem("admin_token") || "");

//   // ----------------------------
//   // Client Handlers
//   // ----------------------------
//   const handleClientRegister = async () => {
//     try {
//       await clientRegister(clientEmail, clientPassword);
//       alert("Registered successfully!");
//     } catch(e) {
//       alert(e.response?.data?.detail || "Registration failed");
//     }
//   };

//   const handleClientLogin = async () => {
//     try {
//       const res = await clientLogin(clientEmail, clientPassword);
//         console.log("✅ Login response:", res.data);
//       setClientToken(res.data.access_token);
//       localStorage.setItem("client_token", res.data.access_token);
//     } catch(e) {
//         console.error("❌ Login failed:");
//       alert(e.response?.data?.detail || "Login failed");
//     }
//   };

// //   const handleClientLogin = async () => {
// //   try {
// //     const res = await login(email, password);
// //     setToken(res.data.access_token);
// //     alert("Login successful!");
// //   } catch (err) {
// //     console.error("Login error:", err.response?.data || err.message);
// //     alert("Login failed! Please check your credentials.");
// //   }
// // };


//   const handleClientLogout = () => {
//     setClientToken("");
//     localStorage.removeItem("client_token");
//   };

//   // ----------------------------
//   // Admin Handlers
//   // ----------------------------
// const handleAdminLogin = async () => {
//   try {
//     const res = await adminLogin(adminEmail, adminPassword);
//     setAdminToken(res.data.access_token);
//     localStorage.setItem("admin_token", res.data.access_token);
//     alert(res.data.message); // shows "Login successful"
//   } catch (e) {
//     // Show proper backend validation messages
//     alert(e.response?.data?.detail || "Admin login failed");
//   }
// };



//   const handleAdminLogout = () => {
//     setAdminToken("");
//     localStorage.removeItem("admin_token");
//   };

//   // ----------------------------
//   // Render
//   // ----------------------------
//   return (
//   <div className="app-container">
//     {/* ---------- Header ---------- */}
//     <header className="app-header">
//       <div className="header-container">
//         <h1>CurrencyX — Pro Converter</h1>
//         <div className="header-buttons">
//           <button onClick={() => setView('client')}>Client</button>
//           <button style={{ marginLeft: 8 }} onClick={() => setView('admin')}>Admin</button>
//         </div>
//       </div>
//     </header>

//     ---------- Main Content (Your Existing JSX) ----------
//     <div className="scroll-area">
//       {/* ---------------- Client View ---------------- */}
//       {view === 'client' && (
//         <div style={{ padding: "20px" }}>
//           {!clientToken ? (
//             <div>
//               <h2>Client Login / Register</h2>
//               <input
//                 placeholder="Email"
//                 value={clientEmail}
//                 onChange={e => setClientEmail(e.target.value)}
//               />
//               <input
//                 type="password"
//                 placeholder="Password"
//                 value={clientPassword}
//                 onChange={e => setClientPassword(e.target.value)}
//               />
//               <div style={{ marginTop: 8 }}>
//                 <button onClick={handleClientRegister}>Register</button>
//                 <button onClick={handleClientLogin} style={{ marginLeft: 8 }}>Login</button>
//               </div>
//             </div>
//           ) : (
//             <div>
//               <button onClick={handleClientLogout} style={{ marginBottom: 10 }}>Logout</button>
//               <Converter
//                 token={clientToken}
//                 email={clientEmail}
//               />
//             </div>
//           )}
//         </div>
//       )}

//       {/* ---------------- Admin View ---------------- */}
// {view === 'admin' && (
//   <div style={{ padding: "20px" }}>
//     {!adminToken ? (
//       <div>
//         <h2>Admin Login</h2>
//         <input
//           placeholder="Email"
//           value={adminEmail}
//           onChange={e => setAdminEmail(e.target.value)}
//         />
//         <input
//           type="password"
//           placeholder="Password"
//           value={adminPassword}
//           onChange={e => setAdminPassword(e.target.value)}
//         />
//         <button onClick={handleAdminLogin}>Login</button>
//       </div>
//     ) : (
//       <div className="admin-panel-wrapper">

//         {/* 🔥 Logout Top-Right (underline link) */}
//         <div className="admin-card-header">
//           <span className="logout-link" onClick={handleAdminLogout}>
//             Logout
//           </span>
//         </div>

//         <AdminPanel token={adminToken} />
//       </div>
//     )}
//   </div>
// )}

//     </div>

//     {/* ---------- Footer ---------- */}
//     <footer className="app-footer">
//       <div className="footer-container">
//         <p>© 2025 CurrencyX. All rights reserved.</p>
//         <p>Developed by Jyothi N</p>
//       </div>
//     </footer>
//   </div>
// );

// }




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


