import React, { useState } from "react";
import { BrowserRouter as Router, Routes, Route, NavLink, useNavigate } from "react-router-dom";

import Converter from './components/Converter';
import AdminPanel from './components/AdminPanel';
import ResetPassword from './components/ResetPassword';
import About from './components/About';
import Contact from './components/Contact';
import { FaEye, FaEyeSlash } from "react-icons/fa";

import {
  clientLogin,
  clientRegister,
  clientForgotPassword
} from "./api";

import './App.css';

// ---------------- Home/Login Page ----------------
function Home({ clientEmail, setClientEmail, clientPassword, setClientPassword, handleClientRegister, handleClientLogin, showForgotModal, setShowForgotModal }) {
  const [showPassword, setShowPassword] = useState(false); // ✅ password toggle state

  return (
    <div className="client-container">
      <div className="login-box">
        <h2>Sign In to Your Account</h2>
        <p>No account? Create one below.</p>
        <input type="email" placeholder="Email" value={clientEmail} onChange={(e) => setClientEmail(e.target.value)} />

        {/* Password field with eye icon */}
        <div className="password-wrapper">
      <input
        type={showPassword ? "text" : "password"}
        placeholder="Password"
        value={clientPassword}
        onChange={(e) => setClientPassword(e.target.value)}
        className="password-input"
      />
      <span
        className="password-toggle"
        onClick={() => setShowPassword(!showPassword)}
      >
        {showPassword ? <FaEyeSlash /> : <FaEye />}
      </span>
    </div>


        <div className="terms"></div>
        <div className="button-group">
          <button onClick={handleClientRegister}>Create Account</button>
          <button onClick={handleClientLogin}>Sign In</button>
        </div>
        <p className="forgot-link" onClick={() => setShowForgotModal(true)}>Forgot Password?</p>
      </div>
    </div>
  )
}

// ---------------- Main App Component ----------------
function MainApp() {
  const navigate = useNavigate(); 
  const [clientToken, setClientToken] = useState(localStorage.getItem("client_token") || "");
  const [adminToken, setAdminToken] = useState(localStorage.getItem("admin_token") || "");

  const [clientEmail, setClientEmail] = useState("");
  const [clientPassword, setClientPassword] = useState("");

  const [showForgotModal, setShowForgotModal] = useState(false);
  const [forgotEmail, setForgotEmail] = useState("");

  // ---------------- Register ----------------
  const handleClientRegister = async () => {
    try {
      await clientRegister(clientEmail, clientPassword);
      alert("Account created! Check your email for confirmation.");
    } catch (e) {
      alert(
        typeof e.response?.data?.detail === "string"
          ? e.response.data.detail
          : JSON.stringify(e.response?.data?.detail)
      );
    }
  };

  // ---------------- Login ----------------
  const handleClientLogin = async () => {
    try {
      const res = await clientLogin(clientEmail, clientPassword);
      setClientToken(res.data.access_token);
      localStorage.setItem("client_token", res.data.access_token);
      navigate("/converter");
    } catch (e) {
      alert(
        typeof e.response?.data?.detail === "string"
          ? e.response.data.detail
          : JSON.stringify(e.response?.data?.detail)
      );
    }
  };

  // ---------------- Logout ----------------
  const handleClientLogout = () => {
    setClientToken("");
    localStorage.removeItem("client_token");
    navigate("/");
  };

  const handleAdminLogout = () => {
    setAdminToken("");
    localStorage.removeItem("admin_token");
    navigate("/");
  };

  // ---------------- Forgot Password ----------------
  const handleForgotSubmit = async () => {
    try {
      const res = await clientForgotPassword(forgotEmail);
      alert(res.data.message || "Reset link sent!");
      setShowForgotModal(false);
    } catch (e) {
      let detail = e.response?.data?.detail;

      // 🔹 If backend returns validation array → pick msg from array[0]
      if (Array.isArray(detail) && detail[0]?.msg) {
        alert(detail[0].msg);
        return;
      }

      // 🔹 If backend returns string
      if (typeof detail === "string") {
        alert(detail);
        return;
      }

      alert("Failed to send reset link");
    }
  };

  return (
    <div className="app-container">
      {/* ---------------- Header ---------------- */}
      <header className="app-header">
        <div className="header-container">
          <h1>CurrencyPro Converter</h1>
          <div className="header-buttons">
            <NavLink to="/about" className={({ isActive }) => isActive ? "nav-link active" : "nav-link"}>About</NavLink>
            <NavLink to="/contact" className={({ isActive }) => isActive ? "nav-link active" : "nav-link"}>Contact</NavLink>
            <button onClick={() => navigate("/")}>Register</button>
            <button onClick={() => navigate("/admin")}>Admin</button>
          </div>
        </div>
      </header>

      {/* ---------------- Main Content ---------------- */}
      <main className="main-content">
        <Routes>
          <Route path="/" element={<Home
            clientEmail={clientEmail}
            setClientEmail={setClientEmail}
            clientPassword={clientPassword}
            setClientPassword={setClientPassword}
            handleClientRegister={handleClientRegister}
            handleClientLogin={handleClientLogin}
            showForgotModal={showForgotModal}
            setShowForgotModal={setShowForgotModal}
          />} />
          <Route path="/converter" element={<Converter token={clientToken} email={clientEmail} logout={handleClientLogout} />} />
          <Route path="/admin" element={<AdminPanel token={adminToken} onLogout={handleAdminLogout} setToken={setAdminToken} />} />
          <Route path="/about" element={<About />} />
          <Route path="/contact" element={<Contact />} />
          <Route path="/reset-password" element={<ResetPassword />} />
        </Routes>
      </main>

      {/* ---------------- Footer ---------------- */}
      <footer className="app-footer">
        <div className="footer-container">
          <p>© 2025 CurrencyX. All rights reserved.</p>
          <p>Developed by Jyothi N</p>
        </div>
      </footer>

      {/* ---------------- Forgot Password Modal ---------------- */}
      {showForgotModal && (
        <div className="modal-overlay">
          <div className="modal-box">
            <h2>Reset Your Password</h2>
            <p>Enter your registered email to receive a reset link.</p>
            <input
              type="email"
              placeholder="Enter Email"
              value={forgotEmail}
              onChange={(e) => setForgotEmail(e.target.value)}
            />
            <div className="modal-buttons">
              <button onClick={handleForgotSubmit}>Send Reset Link</button>
              <button className="cancel" onClick={() => setShowForgotModal(false)}>Cancel</button>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

// ---------------- App Router ----------------
export default function App() {
  return (
    <Router>
      <MainApp />
    </Router>
  );
}






// import React, { useState } from "react";
// import { BrowserRouter as Router, Routes, Route, NavLink, useNavigate } from "react-router-dom";

// import Converter from './components/Converter';
// import AdminPanel from './components/AdminPanel';
// import ResetPassword from './components/ResetPassword';
// import About from './components/About';
// import Contact from './components/Contact';


// import {
//   clientLogin,
//   clientRegister,
//   clientForgotPassword
// } from "./api";

// import './App.css';

// // ---------------- Home/Login Page ----------------
// function Home({ clientEmail, setClientEmail, clientPassword, setClientPassword, termsAccepted, setTermsAccepted, handleClientRegister, handleClientLogin, showForgotModal, setShowForgotModal }) {
//   return (
//     <div className="client-container">
//       <div className="login-box">
//         <h2>Sign In to Your Account</h2>
//         <p>No account? Create one below.</p>
//         <input type="email" placeholder="Email" value={clientEmail} onChange={(e) => setClientEmail(e.target.value)} />
//         <input type="password" placeholder="Password" value={clientPassword} onChange={(e) => setClientPassword(e.target.value)} />
//         <div className="terms"></div>
//         <div className="button-group">
//           <button onClick={handleClientRegister}>Create Account</button>
//           <button onClick={handleClientLogin}>Sign In</button>
//         </div>
//         <p className="forgot-link" onClick={() => setShowForgotModal(true)}>Forgot Password?</p>
//       </div>
//     </div>
//   )
// }

// // ---------------- Main App Component ----------------
// function MainApp() {
//   const navigate = useNavigate(); 
//   const [clientToken, setClientToken] = useState(localStorage.getItem("client_token") || "");
//   const [adminToken, setAdminToken] = useState(localStorage.getItem("admin_token") || "");

//   const [clientEmail, setClientEmail] = useState("");
//   const [clientPassword, setClientPassword] = useState("");

//   const [showForgotModal, setShowForgotModal] = useState(false);
//   const [forgotEmail, setForgotEmail] = useState("");

//   // ---------------- Register ----------------
//   const handleClientRegister = async () => {
//     try {
//       await clientRegister(clientEmail, clientPassword);
//       alert("Account created! Check your email for confirmation.");
//     } catch (e) {
//       alert(
//         typeof e.response?.data?.detail === "string"
//           ? e.response.data.detail
//           : JSON.stringify(e.response?.data?.detail)
//       );
//     }
//   };

//   // ---------------- Login ----------------
//   const handleClientLogin = async () => {
//     try {
//       const res = await clientLogin(clientEmail, clientPassword);
//       setClientToken(res.data.access_token);
//       localStorage.setItem("client_token", res.data.access_token);
//       navigate("/converter");
//     } catch (e) {
//       alert(
//         typeof e.response?.data?.detail === "string"
//           ? e.response.data.detail
//           : JSON.stringify(e.response?.data?.detail)
//       );
//     }
//   };

//   // ---------------- Logout ----------------
//   const handleClientLogout = () => {
//     setClientToken("");
//     localStorage.removeItem("client_token");
//     navigate("/");
//   };

//   const handleAdminLogout = () => {
//     setAdminToken("");
//     localStorage.removeItem("admin_token");
//     navigate("/");
//   };

//   // ---------------- Forgot Password ----------------
//   // const handleForgotSubmit = async () => {
//   //   try {
//   //     const res = await clientForgotPassword(forgotEmail);
//   //     alert(
//   //       typeof res.data?.message === "string"
//   //         ? res.data.message
//   //         : JSON.stringify(res.data?.message)
//   //     );
//   //     setShowForgotModal(false);
//   //   } catch (e) {
//   //     alert(
//   //       typeof e.response?.data?.detail === "string"
//   //         ? e.response.data.detail
//   //         : JSON.stringify(e.response?.data?.detail)
//   //     );
//   //   }
//   // };
//   const handleForgotSubmit = async () => {
//   try {
//     const res = await clientForgotPassword(forgotEmail);
//     alert(res.data.message || "Reset link sent!");
//     setShowForgotModal(false);
//   } catch (e) {
//     let detail = e.response?.data?.detail;

//     // 🔹 If backend returns validation array → pick msg from array[0]
//     if (Array.isArray(detail) && detail[0]?.msg) {
//       alert(detail[0].msg);
//       return;
//     }

//     // 🔹 If backend returns string
//     if (typeof detail === "string") {
//       alert(detail);
//       return;
//     }

//     alert("Failed to send reset link");
//   }
// };


//   return (
//     <div className="app-container">
//       {/* ---------------- Header ---------------- */}
//       <header className="app-header">
//         <div className="header-container">
//           <h1>CurrencyPro Converter</h1>
//           <div className="header-buttons">
//             <NavLink to="/about" className={({ isActive }) => isActive ? "nav-link active" : "nav-link"}>About</NavLink>
//             <NavLink to="/contact" className={({ isActive }) => isActive ? "nav-link active" : "nav-link"}>Contact</NavLink>
//             <button onClick={() => navigate("/")}>Register</button>
//             <button onClick={() => navigate("/admin")}>Admin</button>
//           </div>
//         </div>
//       </header>

//       {/* ---------------- Main Content ---------------- */}
//       <main className="main-content">
//         <Routes>
//           <Route path="/" element={<Home
//             clientEmail={clientEmail}
//             setClientEmail={setClientEmail}
//             clientPassword={clientPassword}
//             setClientPassword={setClientPassword}
//             handleClientRegister={handleClientRegister}
//             handleClientLogin={handleClientLogin}
//             showForgotModal={showForgotModal}
//             setShowForgotModal={setShowForgotModal}
//           />} />
//           <Route path="/converter" element={<Converter token={clientToken} email={clientEmail} logout={handleClientLogout} />} />
//           <Route path="/admin" element={<AdminPanel token={adminToken} onLogout={handleAdminLogout} setToken={setAdminToken} />} />
//           <Route path="/about" element={<About />} />
//           <Route path="/contact" element={<Contact />} />
//           <Route path="/reset-password" element={<ResetPassword />} />
//         </Routes>
//       </main>

//       {/* ---------------- Footer ---------------- */}
//       <footer className="app-footer">
//         <div className="footer-container">
//           <p>© 2025 CurrencyX. All rights reserved.</p>
//           <p>Developed by Jyothi N</p>
//         </div>
//       </footer>

//       {/* ---------------- Forgot Password Modal ---------------- */}
//       {showForgotModal && (
//         <div className="modal-overlay">
//           <div className="modal-box">
//             <h2>Reset Your Password</h2>
//             <p>Enter your registered email to receive a reset link.</p>
//             <input
//               type="email"
//               placeholder="Enter Email"
//               value={forgotEmail}
//               onChange={(e) => setForgotEmail(e.target.value)}
//             />
//             <div className="modal-buttons">
//               <button onClick={handleForgotSubmit}>Send Reset Link</button>
//               <button className="cancel" onClick={() => setShowForgotModal(false)}>Cancel</button>
//             </div>
//           </div>
//         </div>
//       )}
//     </div>
//   );
// }

// // ---------------- App Router ----------------
// export default function App() {
//   return (
//     <Router>
//       <MainApp />
//     </Router>
//   );
// }




// import React, { useState } from "react";
// import { BrowserRouter as Router, Routes, Route, NavLink, useNavigate } from "react-router-dom";

// import Converter from './components/Converter';
// import AdminPanel from './components/AdminPanel';
// import ResetPassword from './components/ResetPassword';
// import About from './components/About';
// import Contact from './components/Contact';

// import {
//   clientLogin,
//   clientRegister,
//   clientForgotPassword
// } from "./api";

// import './App.css';

// // ---------------- Home/Login Page ----------------
// function Home({ clientEmail, setClientEmail, clientPassword, setClientPassword, termsAccepted, setTermsAccepted, handleClientRegister, handleClientLogin, showForgotModal, setShowForgotModal }) {
//   return (
//     <div className="client-container">
//       <div className="login-box">
//         <h2>Sign In to Your Account</h2>
//         <p>No account? Create one below.</p>
//         <input type="email" placeholder="Email" value={clientEmail} onChange={(e) => setClientEmail(e.target.value)} />
//         <input type="password" placeholder="Password" value={clientPassword} onChange={(e) => setClientPassword(e.target.value)} />
//         <div className="terms">
//           {/* <input type="checkbox" checked={termsAccepted} onChange={(e) => setTermsAccepted(e.target.checked)} /> I agree to the <a href="#terms">Terms & Conditions are required only for creating a new account.
// </a> */}
//         </div>
//         <div className="button-group">
//           <button onClick={handleClientRegister}>Create Account</button>
//           <button onClick={handleClientLogin}>Sign In</button>
//         </div>
//         <p className="forgot-link" onClick={() => setShowForgotModal(true)}>Forgot Password?</p>
//       </div>
//     </div>
//   )
// }

// // ---------------- Main App Component ----------------
// function MainApp() {
//   const navigate = useNavigate(); // For navigation
//   const [clientToken, setClientToken] = useState(localStorage.getItem("client_token") || "");
//   const [adminToken, setAdminToken] = useState(localStorage.getItem("admin_token") || "");

//   // ---------------- Client Login/Register ----------------
//   const [clientEmail, setClientEmail] = useState("");
//   const [clientPassword, setClientPassword] = useState("");
//   // const [termsAccepted, setTermsAccepted] = useState(false);

//   // ---------------- Forgot Password Modal ----------------
//   const [showForgotModal, setShowForgotModal] = useState(false);
//   const [forgotEmail, setForgotEmail] = useState("");

//   // ---------------- Register ----------------
//   const handleClientRegister = async () => {
//     // if (!termsAccepted) {
//     //   alert("Please accept Terms & Conditions.");
//     //   return;
//     // }
//     try {
//       await clientRegister(clientEmail, clientPassword);
//       alert("Account created! Check your email for confirmation.");
//     } catch (e) {
//       alert(e.response?.data?.detail || "Registration failed");
//     }
//   };

//   // ---------------- Login ----------------
//   const handleClientLogin = async () => {
//     try {
//       const res = await clientLogin(clientEmail, clientPassword);
//       setClientToken(res.data.access_token);
//       localStorage.setItem("client_token", res.data.access_token);
//       navigate("/converter"); // go to converter page after login
//     } catch (e) {
//       alert(e.response?.data?.detail || "Login failed");
//     }
//   };

//   // ---------------- Logout ----------------
//   const handleClientLogout = () => {
//     setClientToken("");
//     localStorage.removeItem("client_token");
//     navigate("/"); // back to home
//   };

//   const handleAdminLogout = () => {
//     setAdminToken("");
//     localStorage.removeItem("admin_token");
//     navigate("/"); // back to home
//   };

//   // ---------------- Forgot Password ----------------
//   const handleForgotSubmit = async () => {
//     try {
//       const res = await clientForgotPassword(forgotEmail);
//       alert(res.data.message || "Reset link sent!");
//       setShowForgotModal(false);
//     } catch (e) {
//       alert(e.response?.data?.detail || "Failed to send reset link");
//     }
//   };

//   return (
//     <div className="app-container">
//       {/* ---------------- Header ---------------- */}
//       <header className="app-header">
//         <div className="header-container">
//           <h1>CurrencyPro Converter</h1>
//           <div className="header-buttons">
//             <NavLink to="/about" className={({isActive}) => isActive ? "nav-link active" : "nav-link"}>About</NavLink>
//             <NavLink to="/contact" className={({isActive}) => isActive ? "nav-link active" : "nav-link"}>Contact</NavLink>
//             <button onClick={() => navigate("/")}>Register</button>
//             <button onClick={() => navigate("/admin")}>Admin</button>
//           </div>
//         </div>
//       </header>

//       {/* ---------------- Main Content ---------------- */}
//       <main className="main-content">
//         <Routes>
//           <Route path="/" element={<Home
//               clientEmail={clientEmail}
//               setClientEmail={setClientEmail}
//               clientPassword={clientPassword}
//               setClientPassword={setClientPassword}
//               // termsAccepted={termsAccepted}
//               // setTermsAccepted={setTermsAccepted}
//               handleClientRegister={handleClientRegister}
//               handleClientLogin={handleClientLogin}
//               showForgotModal={showForgotModal}
//               setShowForgotModal={setShowForgotModal}
//           />} />
//           <Route path="/converter" element={<Converter token={clientToken} email={clientEmail} logout={handleClientLogout} />} />
//           <Route path="/admin" element={<AdminPanel token={adminToken} onLogout={handleAdminLogout} setToken={setAdminToken} />} />
//           <Route path="/about" element={<About />} />
//           <Route path="/contact" element={<Contact />} />
//           <Route path="/reset-password" element={<ResetPassword />} />
//         </Routes>
//       </main>

//       {/* ---------------- Footer ---------------- */}
//       <footer className="app-footer">
//         <div className="footer-container">
//           <p>© 2025 CurrencyX. All rights reserved.</p>
//           <p>Developed by Jyothi N</p>
//         </div>
//       </footer>

//       {/* ---------------- Forgot Password Modal ---------------- */}
//       {showForgotModal && (
//         <div className="modal-overlay">
//           <div className="modal-box">
//             <h2>Reset Your Password</h2>
//             <p>Enter your registered email to receive a reset link.</p>
//             <input
//               type="email"
//               placeholder="Enter Email"
//               value={forgotEmail}
//               onChange={(e) => setForgotEmail(e.target.value)}
//             />
//             <div className="modal-buttons">
//               <button onClick={handleForgotSubmit}>Send Reset Link</button>
//               <button className="cancel" onClick={() => setShowForgotModal(false)}>Cancel</button>
//             </div>
//           </div>
//         </div>
//       )}
//     </div>
//   );
// }

// // ---------------- App Router ----------------
// export default function App() {
//   return (
//     <Router>
//       <MainApp />
//     </Router>
//   );
// }

