import React from 'react';
import { Link } from 'react-router-dom';
import './HomePage.css';

function HomePage() {
  return (
    <div className="homepage">
      <h2 className="app-name">CareAppoint</h2>
      <div className="button-container">
        <Link to="/admin/login" className="login-button admin">Admin</Link>
        <Link to="/patient/login" className="login-button patient">Patient</Link>
        <Link to="/doctor/login" className="login-button doctor">Doctor</Link>
      </div>
      <div className="student">

        <p>Bhavani Kumar Kalavakunta</p>
        <p>Cohort- 314</p>
    </div>
    </div>
    
  );
}

export default HomePage;
