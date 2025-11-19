import React, { useState } from "react";
import axios from "axios";

export default function ResetPassword() {
  const token = new URLSearchParams(window.location.search).get("token");
  const [password, setPassword] = useState("");
  const [msg, setMsg] = useState("");

  const resetPassword = async () => {
     console.log("Reset token:", token, "New password:", password);
    try {
      const res = await axios.post("http://localhost:8000/user/reset-password", {
        token,
        new_password: password,
      });

      setMsg(res.data.message);
    } catch (e) {
      setMsg(e.response?.data?.detail || "Reset failed");
    }
  };

  return (
    <div className="login-box">
      <h2>Reset Password</h2>

      <input
        type="password"
        placeholder="Enter new password"
        value={password}
        onChange={(e) => setPassword(e.target.value)}
      />

      <button onClick={resetPassword}>Update Password</button>

      {msg && <p style={{ marginTop: 10 }}>{msg}</p>}
    </div>
  );
}
