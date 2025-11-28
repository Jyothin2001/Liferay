import React from 'react';

export default function About() {
  return (
    <div className="about-page" style={{ padding: '20px', maxWidth: '800px', margin: 'auto' }}>
      <h2>About CurrencyPro Converter</h2>
      <p>
        CurrencyPro Converter is a web application designed to help users convert currencies
        quickly and accurately. You can convert amounts between multiple currencies, view historical
        exchange rates, and generate QR codes for sharing conversion results.
      </p>

      <h3>How Rates Are Sourced</h3>
      <p>
        The exchange rates displayed in this app are sourced from reliable financial APIs that
        provide live market data. Rates are updated frequently to ensure accuracy. Note that
        actual rates may vary slightly depending on banks or forex services.
      </p>

      <h3>Features</h3>
      <ul>
        <li>Instant currency conversion</li>
        <li>Historical rates chart</li>
        <li>QR code for conversion result sharing</li>
        <li>Conversion history tracking</li>
      </ul>
    </div>
  );
}
