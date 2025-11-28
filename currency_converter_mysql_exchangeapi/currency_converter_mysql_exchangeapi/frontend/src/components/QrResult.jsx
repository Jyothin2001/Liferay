// components/QrResult.js
import React from "react";
import { QRCodeCanvas } from "qrcode.react";
import "./QrResult.css";

export default function QrResult({ value }) {
  if (!value) return null; // no result, no QR

  return (
    <div className="qr-container">
      <h3>📱 QR Code Result</h3>
      <QRCodeCanvas
        value={value}
        size={180}
        level="H"
        style={{ borderRadius: "10px" }}
      />

      <p className="qr-text">{value}</p>
    </div>
  );
}
