import React, { useState } from 'react';
import { clientLogin, clientRegister } from '../api'; // client API functions
import Converter from './Converter';

export default function ClientPanel() {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [token, setToken] = useState(localStorage.getItem('client_token') || '');
  const [isRegistering, setIsRegistering] = useState(false);

  // Client login
  const login = async () => {
    try {
      const res = await clientLogin(email, password);
      setToken(res.data.access_token);
      localStorage.setItem('client_token', res.data.access_token);
      alert('Logged in successfully');
    } catch (e) {
      alert(e.response?.data?.detail || e.message);
    }
  };

  // Client registration
  const register = async () => {
    try {
      await clientRegister(email, password);
      alert('Registration successful! Please log in.');
      setIsRegistering(false);
    } catch (e) {
      alert(e.response?.data?.detail || e.message);
    }
  };

  // Logout
  const logout = () => {
    setToken('');
    localStorage.removeItem('client_token');
  };

  return (
    <div className="card" style={{ padding: 16, marginTop: 12 }}>
      {!token ? (
        <div>
          <h3>{isRegistering ? 'Register' : 'Client Login'}</h3>
          <label>Email</label>
          <input value={email} onChange={e => setEmail(e.target.value)} />
          <label>Password</label>
          <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
          <div style={{ marginTop: 8, display: 'flex', gap: 8 }}>
            {isRegistering ? (
              <button onClick={register}>Register</button>
            ) : (
              <button onClick={login}>Login</button>
            )}
            <button onClick={() => setIsRegistering(!isRegistering)}>
              {isRegistering ? 'Go to Login' : 'Go to Register'}
            </button>
          </div>
        </div>
      ) : (
        <div>
          <div style={{ display: 'flex', justifyContent: 'space-between', marginBottom: 12 }}>
            <h3>Welcome, {email}</h3>
            <button onClick={logout}>Logout</button>
          </div>
          <Converter token={token} email={email} />
        </div>
      )}
    </div>
  );
}
