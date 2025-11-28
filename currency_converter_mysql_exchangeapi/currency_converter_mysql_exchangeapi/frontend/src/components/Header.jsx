// import React from "react";
// import "./Header.css";

// export default function Header({ view, setView }) {
//   return (
//     <header className="app-header">
//       <div className="header-container">
//         <h1>CurrencyX — Pro Converter</h1>

//         <div className="header-buttons">
//           <button
//             className={view === "client" ? "active" : ""}
//             onClick={() => setView("client")}
//           >
//             Register
//           </button>

//           <button
//             className={view === "admin" ? "active" : ""}
//             onClick={() => setView("admin")}
//           >
//             Admin
//           </button>
//         </div>
//       </div>
//     </header>
//   );
// }
// Layout.jsx
import React from "react";
import { NavLink } from "react-router-dom";

export default function Layout({ children, view, saveView }) {
  return (
    <>
      {/* Header */}
      <header className="app-header">
        <div className="header-container">
          <h1>CurrencyPro Converter</h1>
          <div className="header-buttons">
            <NavLink
              to="/about"
              className={({ isActive }) => isActive ? "nav-link active" : "nav-link"}
            >
              About
            </NavLink>
            <NavLink
              to="/contact"
              className={({ isActive }) => isActive ? "nav-link active" : "nav-link"}
            >
              Contact
            </NavLink>
            <button
              className={view === "client" ? "active" : ""}
              onClick={() => saveView("client")}
            >
              Register
            </button>
            <button
              className={view === "admin" ? "active" : ""}
              onClick={() => saveView("admin")}
            >
              Admin
            </button>
          </div>
        </div>
      </header>

      {/* Page content */}
      <main className="main-content">{children}</main>

      {/* Footer */}
      <footer className="app-footer">
        <div className="footer-container">
          <p>© 2025 CurrencyX. All rights reserved.</p>
          <p>Developed by Jyothi N</p>
        </div>
      </footer>
    </>
  );
}
