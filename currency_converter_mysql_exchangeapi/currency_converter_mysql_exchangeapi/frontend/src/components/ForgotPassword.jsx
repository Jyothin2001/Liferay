import React, { useState } from "react";
import axios from "axios";

export default function ForgotPassword() {
  const [email, setEmail] = useState("");
  const [msg, setMsg] = useState("");

  const sendRequest = async () => {
    try {
      const res = await axios.post("http://localhost:8000/user/forgot-password", {
        email,
      });

      setMsg(res.data.message);
    } catch (e) {
      setMsg(e.response?.data?.detail || "Something went wrong");
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

      {msg && <p style={{ marginTop: 10 }}>{msg}</p>}
    </div>
  );
}
