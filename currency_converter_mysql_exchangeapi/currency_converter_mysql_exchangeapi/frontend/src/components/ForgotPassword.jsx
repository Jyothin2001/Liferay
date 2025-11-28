import React, { useState } from "react";
import axios from "axios";

export default function ForgotPassword() {
  const [email, setEmail] = useState("");
  const [msg, setMsg] = useState("");
  const [error, setError] = useState("");

  const sendRequest = async () => {
    setMsg("");
    setError("");

    if (!email) {
      setError("⚠ Email is required");
      return;
    }

    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!regex.test(email)) {
      setError("⚠ Enter a valid email address");
      return;
    }

    try {
      const res = await axios.post(
        "http://192.168.0.102:8000/user/forgot-password",
        { email }
      );

      // 👇 Make sure to show ONLY string — not entire object
      setMsg(res.data?.message || "✔ Reset link sent successfully");
      setEmail("");
    } catch (e) {
      setError(e.response?.data?.detail || "❌ Something went wrong. Try again.");
    }
  };

  return (
    <div className="login-box">
      <h2>Forgot Password</h2>

      <input
        type="email"
        placeholder="Enter your registered email"
        value={email}
        onChange={(e) => setEmail(e.target.value)}
      />

      <button onClick={sendRequest}>Send Reset Link</button>

      {/* Show messages correctly */}
      {error && <p style={{ color: "red", marginTop: 10 }}>{error}</p>}
      {msg && <p style={{ color: "green", marginTop: 10 }}>{msg}</p>}
    </div>
  );
}



// import React, { useState } from "react";
// import axios from "axios";

// export default function ForgotPassword() {
//   const [email, setEmail] = useState("");
//   const [msg, setMsg] = useState("");

//   const sendRequest = async () => {
//     try {
//       const res = await axios.post("http://192.168.0.102:8000/user/forgot-password", {
//         email,
//       });

//       setMsg(res.data.message);
//     } catch (e) {
//       setMsg(e.response?.data?.detail || "Something went wrong");
//     }
//   };

//   return (
//     <div className="login-box">
//       <h2>Forgot Password</h2>

//       <input
//         type="email"
//         placeholder="Enter your registered email"
//         value={email}
//         onChange={(e) => setEmail(e.target.value)}
//       />

//       <button onClick={sendRequest}>Send Reset Link</button>

//       {msg && <p style={{ marginTop: 10 }}>{msg}</p>}
//     </div>
//   );
// }
