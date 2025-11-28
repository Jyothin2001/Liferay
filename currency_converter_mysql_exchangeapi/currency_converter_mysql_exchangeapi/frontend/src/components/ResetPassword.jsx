import React, { useState } from "react";
import axios from "axios";

export default function ResetPassword() {
  const token = new URLSearchParams(window.location.search).get("token");
  const [newPassword, setNewPassword] = useState("");
  const [msg, setMsg] = useState("");

  const PASSWORD_PATTERN =
    /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;

  const resetPassword = async () => {
    if (!newPassword) {
      setMsg("Password is required");
      return;
    }
    if (newPassword.includes(" ")) {
      setMsg("Password cannot contain spaces");
      return;
    }
    if (!PASSWORD_PATTERN.test(newPassword)) {
      setMsg(
        "Password must be 8+ chars, include uppercase, lowercase, number & special char"
      );
      return;
    }

    try {
      const res = await axios.post(
        "http://192.168.0.102:8000/user/reset-password",
        { token, new_password: newPassword }
      );

      alert(res.data.message || "Password reset successfully!");
      window.location.href = "/?resetSuccess=1";
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
        value={newPassword}
        onChange={(e) => {
          setNewPassword(e.target.value);
          setMsg(""); // ✅ Clear error message on typing
        }}
        style={{ width: "250px", padding: "10px", marginTop: "10px" }}
      />
      <button onClick={resetPassword}>Update Password</button>
      {msg && <p style={{ marginTop: 10, color: "red" }}>{msg}</p>}
    </div>
  );
}



// import React, { useState } from "react";
// import axios from "axios";

// export default function ResetPassword() {
//   const token = new URLSearchParams(window.location.search).get("token");
//   const [password, setPassword] = useState("");
//   const [msg, setMsg] = useState("");

//   const resetPassword = async () => {
//      console.log("Reset token:", token, "New password:", password);
//     try {
//       const res = await axios.post("http://192.168.0.102:8000/user/reset-password", {
//         token,
//         new_password: password,
//       });

//       setMsg(res.data.message);
//     } catch (e) {
//       setMsg(e.response?.data?.detail || "Reset failed");
//     }
//   };

//   return (
//     <div className="login-box">
//       <h2>Reset Password</h2>

//       {/* <input
//         type="password"
//         placeholder="Enter new password"
//         value={password}
//         onChange={(e) => setPassword(e.target.value)}
//       /> */}
//       <input
//   type="password"
//   placeholder="Enter new password"
//   value={password}
//   onChange={(e) => setPassword(e.target.value)}
//   style={{ width: "250px", padding: "10px", marginTop: "10px" }}
// />


//       <button onClick={resetPassword}>Update Password</button>

//       {msg && <p style={{ marginTop: 10 }}>{msg}</p>}
//     </div>
//   );
// }
