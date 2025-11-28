// import React, { useState } from 'react';

// export default function Contact() {
//   const [name, setName] = useState('');
//   const [email, setEmail] = useState('');
//   const [message, setMessage] = useState('');
//   const [submitted, setSubmitted] = useState(false);

//   const handleSubmit = (e) => {
//     e.preventDefault();
//     // Here you could send form data to your backend or email API
//     console.log({ name, email, message });
//     setSubmitted(true);
//     setName('');
//     setEmail('');
//     setMessage('');
//   };

//   return (
//     <div className="contact-page" style={{ padding: '20px', maxWidth: '600px', margin: 'auto' }}>
//       <h2>Contact Us</h2>
//       <p>If you have any feedback, questions, or issues, please fill out the form below.</p>

//       {submitted && <div style={{ color: 'green', marginBottom: '15px' }}>Message sent successfully!</div>}

//       <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '12px' }}>
//         <input
//           type="text"
//           placeholder="Your Name"
//           value={name}
//           required
//           onChange={(e) => setName(e.target.value)}
//           style={{ padding: '10px', borderRadius: '6px', border: '1px solid #ccc' }}
//         />

//         <input
//           type="email"
//           placeholder="Your Email"
//           value={email}
//           required
//           onChange={(e) => setEmail(e.target.value)}
//           style={{ padding: '10px', borderRadius: '6px', border: '1px solid #ccc' }}
//         />

//         <textarea
//           placeholder="Your Message"
//           value={message}
//           required
//           onChange={(e) => setMessage(e.target.value)}
//           style={{ padding: '10px', borderRadius: '6px', border: '1px solid #ccc', minHeight: '120px' }}
//         />

//         <button type="submit" style={{ padding: '10px', borderRadius: '6px', background: '#4f46e5', color: '#fff', border: 'none', cursor: 'pointer' }}>
//           Send Message
//         </button>
//       </form>
//     </div>
//   );
// }
// import React, { useState } from 'react';

// export default function Contact() {
//   const [name, setName] = useState('');
//   const [email, setEmail] = useState('');
//   const [message, setMessage] = useState('');
//   const [submitted, setSubmitted] = useState(false);

//   const handleSubmit = async (e) => {
//     e.preventDefault();

//     const response = await fetch("https://formspree.io/f/mwpjpbek", {
//       method: "POST",
//       headers: { "Content-Type": "application/json" },
//       body: JSON.stringify({ name, email, message }),
//     });

//     if (response.ok) {
//       setSubmitted(true);
//       setName("");
//       setEmail("");
//       setMessage("");
//     } else {
//       alert("Something went wrong. Try again.");
//     }
//   };

//   return (
//     <div className="contact-page" style={{ padding: '20px', maxWidth: '600px', margin: 'auto' }}>
//       <h2>Contact Us</h2>
//       <p>If you have any feedback, questions, or issues, please fill out the form below.</p>

//       {submitted && <div style={{ color: 'green', marginBottom: '15px' }}>Message sent successfully!</div>}

//       <form onSubmit={handleSubmit} style={{ display: 'flex', flexDirection: 'column', gap: '12px' }}>
//         <input
//           type="text"
//           placeholder="Your Name"
//           value={name}
//           required
//           onChange={(e) => setName(e.target.value)}
//           style={{ padding: '10px', borderRadius: '6px', border: '1px solid #ccc' }}
//         />

//         <input
//           type="email"
//           placeholder="Your Email"
//           value={email}
//           required
//           onChange={(e) => setEmail(e.target.value)}
//           style={{ padding: '10px', borderRadius: '6px', border: '1px solid #ccc' }}
//         />

//         <textarea
//           placeholder="Your Message"
//           value={message}
//           required
//           onChange={(e) => setMessage(e.target.value)}
//           style={{ padding: '10px', borderRadius: '6px', border: '1px solid #ccc', minHeight: '120px' }}
//         />

//         <button type="submit" style={{ padding: '10px', borderRadius: '6px', background: '#4f46e5', color: '#fff', border: 'none', cursor: 'pointer' }}>
//           Send Message
//         </button>
//       </form>
//     </div>
//   );
// }

// import React, { useState } from 'react';

// export default function Contact() {
//   const [name, setName] = useState('');
//   const [email, setEmail] = useState('');
//   const [message, setMessage] = useState('');
//   const [submitted, setSubmitted] = useState(false);

//   const handleSubmit = async (e) => {
//     e.preventDefault();

//     const response = await fetch("https://formspree.io/f/mwpjpbek", {
//       method: "POST",
//       headers: { "Content-Type": "application/json" },
//       body: JSON.stringify({ name, email, message }),
//     });

//     if (response.ok) {
//       setSubmitted(true);
//       setName("");
//       setEmail("");
//       setMessage("");
//       setTimeout(() => setSubmitted(false), 3000);
//     } else {
//       alert("Something went wrong. Try again.");
//     }
//   };

//   return (
//     <div style={containerStyle}>
//       <h2 style={titleStyle}>Contact Us</h2>
//       <p style={subtitleStyle}>Feel free to send feedback or questions.</p>

//       {submitted && <div style={successMsg}>✔ Message sent successfully!</div>}

//       <form onSubmit={handleSubmit} style={formStyle}>

//         <input
//           type="text"
//           placeholder="Full Name"
//           value={name}
//           required
//           onChange={(e) => setName(e.target.value)}
//           style={fieldStyle}
//         />

//         <input
//           type="email"
//           placeholder="Email Address"
//           value={email}
//           required
//           onChange={(e) => setEmail(e.target.value)}
//           style={fieldStyle}
//         />

//         <textarea
//           placeholder="Write your message..."
//           value={message}
//           required
//           onChange={(e) => setMessage(e.target.value)}
//           style={{ ...fieldStyle, height: '140px', resize: 'vertical' }}
//         />

//         <button type="submit" style={buttonStyle}>Send Message</button>
//       </form>
//     </div>
//   );
// }

// // ---- Styling ----

// const containerStyle = {
//   padding: '20px',
//   maxWidth: '450px',
//   margin: 'auto',
//   fontFamily: 'Arial, sans-serif'
// };

// const titleStyle = {
//   textAlign: 'center',
//   fontSize: '26px',
//   marginBottom: '5px'
// };

// const subtitleStyle = {
//   textAlign: 'center',
//   fontSize: '14px',
//   color: '#555',
//   marginBottom: '20px'
// };

// const formStyle = {
//   display: 'flex',
//   flexDirection: 'column',
//   gap: '14px'
// };

// const fieldStyle = {
//   width: '100%',
//   padding: '12px',
//   borderRadius: '6px',
//   border: '1.5px solid #ccc',
//   fontSize: '16px',
//   outline: 'none',
//   transition: '0.3s',
// };

// const buttonStyle = {
//   padding: '14px',
//   borderRadius: '6px',
//   background: '#4f46e5',
//   color: 'white',
//   fontSize: '17px',
//   border: 'none',
//   cursor: 'pointer',
//   transition: '0.3s'
// };

// const successMsg = {
//   background: '#d4f8d4',
//   padding: '10px',
//   textAlign: 'center',
//   color: '#0b6b1c',
//   fontWeight: 'bold',
//   borderRadius: '6px',
//   marginBottom: '15px'
// };


import React, { useState } from 'react';

export default function Contact() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [message, setMessage] = useState('');
  const [submitted, setSubmitted] = useState(false);
  const [error, setError] = useState("");

  // ---------------- VALIDATION FUNCTION ----------------
  const validateForm = () => {
    if (name.trim().length < 3) {
      setError("Name must be at least 3 characters.");
      return false;
    }

    const emailPattern = /^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Za-z]{2,}$/;

    if (!emailPattern.test(email)) {
      setError("Enter a valid email address.");
      return false;
    }

    if (message.trim().length < 10) {
      setError("Message must be minimum 10 characters.");
      return false;
    }

    return true;
  };

  // ---------------- SEND FORM ----------------
  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!validateForm()) return;

    const response = await fetch("https://formspree.io/f/mwpjpbek", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify({ name, email, message }),
    });

    if (response.ok) {
      setSubmitted(true);
      setError("");
      setName("");
      setEmail("");
      setMessage("");

      setTimeout(() => setSubmitted(false), 3000);
    } else {
      setError("❌ Something went wrong. Try again.");
    }
  };

  return (
    <div style={containerStyle}>
      <h2 style={titleStyle}>Contact Us</h2>
      <p style={subtitleStyle}>Feel free to send feedback or questions.</p>

      {error && <div style={errorMsg}>{error}</div>}
      {submitted && <div style={successMsg}>✔ Message sent successfully!</div>}

      <form onSubmit={handleSubmit} style={formStyle}>
        
        <input
          type="text"
          placeholder="Full Name"
          value={name}
          required
          onChange={(e) => setName(e.target.value)}
          style={fieldStyle}
        />

        <input
          type="email"
          placeholder="Email Address"
          value={email}
          required
          onChange={(e) => setEmail(e.target.value)}
          style={fieldStyle}
        />

        <textarea
          placeholder="Write your message..."
          value={message}
          required
          onChange={(e) => setMessage(e.target.value)}
          style={{ ...fieldStyle, height: '140px', resize: 'vertical' }}
        />

        <button type="submit" style={buttonStyle}>Send Message</button>
      </form>
    </div>
  );
}


// ---- STYLES ----

const containerStyle = {
  padding: '20px',
  maxWidth: '450px',
  margin: 'auto',
  fontFamily: 'Arial, sans-serif'
};

const titleStyle = {
  textAlign: 'center',
  fontSize: '26px',
  marginBottom: '5px'
};

const subtitleStyle = {
  textAlign: 'center',
  fontSize: '14px',
  color: '#555',
  marginBottom: '20px'
};

const formStyle = {
  display: 'flex',
  flexDirection: 'column',
  gap: '14px'
};

const fieldStyle = {
  width: '100%',
  padding: '12px',
  borderRadius: '6px',
  border: '1.5px solid #ccc',
  fontSize: '16px',
  outline: 'none',
  transition: '0.3s'
};

const buttonStyle = {
  padding: '14px',
  borderRadius: '6px',
  background: '#4f46e5',
  color: 'white',
  fontSize: '17px',
  border: 'none',
  cursor: 'pointer',
  transition: '0.3s'
};

const successMsg = {
  background: '#d4f8d4',
  padding: '10px',
  textAlign: 'center',
  color: '#0b6b1c',
  fontWeight: 'bold',
  borderRadius: '6px',
  marginBottom: '15px'
};

const errorMsg = {
  background: '#ffd6d6',
  padding: '10px',
  textAlign: 'center',
  color: '#b10000',
  fontWeight: 'bold',
  borderRadius: '6px',
  marginBottom: '15px'
};


/* ---------------- TEST CASES ----------------

✔ VALID INPUT TEST
Input:
Name: "John Doe"
Email: "john@gmail.com"
Message: "This is feedback message."
Expected:
- Form submits successfully
- Success message shown

❌ EMPTY FORM TEST
Expected:
- Validation error: "Name must be at least 3 characters."

❌ INVALID EMAIL TEST
Input: abc@gmail, user@, @gmail.com
Expected:
- Error: "Enter a valid email address."

❌ SHORT MESSAGE TEST
Input: "Hi"
Expected:
- Error: "Message must be minimum 10 characters."

✔ AUTO CLEAR SUCCESS MESSAGE
Expected:
- Success message disappears after 3 seconds.

✔ RESET FORM AFTER SUBMISSION
Expected:
- Input fields cleared after successful submit.

------------------------------------------------- */

