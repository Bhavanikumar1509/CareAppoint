import React, { useState } from "react";
import { API_BASE_URL } from '../api';
import profile from '../assets/profile.jpg';

import './AdminDashboard.css';

const AdminDashboard = () => {
  const [patients, setPatients] = useState([]);
  const [doctors, setDoctors] = useState([]);
  const [appointments ,setAppointments]= useState([]);

  const [view, setView] = useState(null);
 
  const handleViewPatients = () => {
    
    fetch(API_BASE_URL +'/admin/patients')
      .then(response => response.json())
      .then(data => {
        setPatients(data)
        setView("patients")
      })
      .catch(error => console.error(error));
  };

  const handleViewDoctors = () => {
    
    fetch(API_BASE_URL +'/admin/doctors')
      .then(response => response.json())
      .then(data => {
        setDoctors(data)
        setView("doctors")
      })
      .catch(error => console.error(error));
  };

  const handleViewAppointments = () => {
    
    fetch(API_BASE_URL +'/admin/appointments')
      .then(response => response.json())
      .then(data => {
        console.log(data)
        setAppointments(data)
        setView("appointments")
      })
      .catch(error => console.error(error));
  };




  return (
    <div class ="">
      <h1>Admin Dashboard</h1>
      <button onClick={handleViewPatients}>View All Patients</button>
      <button onClick={handleViewDoctors}>View All Doctors</button>
      <button onClick={handleViewAppointments}>View All Appointments</button>
      {patients.length > 0 && view === 'patients' &&  (
        <div>
          <h2>All Patients</h2>
          <div className="doctors-container">
            {patients.map(patient =>{
             return (
              <div className="profile" key={patient.patient_id}>
                <img src={profile} alt='patient Profile'/>
                <div>{patient.name}</div>
                <div>{patient.email}</div>
                <div>{patient.contact}</div> 
            </div>)
          })}
          </div>
        </div>
      )}


{appointments.length > 0 && view === 'appointments' &&  (
        <div>
          <h2>All Appointments</h2>
          <table>
            <tr>
              <th>Doctor Name</th>
              <th>Specialization</th>
              <th>Patient Name</th>
              <th>Start Time</th>
              <th>End Time</th>
              <th>Status</th>
              <th>Fee</th>
            </tr>
            {appointments.map(appointment =>{
             return (
              <tr className="profile" key={appointment.appointment_id}>
                <td>{appointment.doctor_name}</td>
                <td>{appointment.doctor_specialization}</td>
                <td>{appointment.patient_name || "-"}</td>
                <td>{appointment.startTime}</td>
                <td>{appointment.endTime}</td>
                <td>{appointment.fee}</td>
                <td>{appointment.status}</td>
            </tr>)
          })}
          </table>
        </div>
      )}

      {doctors.length > 0 && view === 'doctors' && (
        <div>
          <h2>All Doctors</h2>
          <div className="doctors-container">
            {doctors.map(doctor => {
              return (
              <div className="profile" key={doctor.doctor_id}>
                <img src={profile} alt='Doctor Profile'/>
                <div>{doctor.name} (<span>{doctor.specialization}</span>) </div>
                <div>{doctor.email}</div>
                <div>{doctor.contact}</div>
              </div>)
            })}
          </div>
        </div>
      )}
    </div>
  );
};

export default AdminDashboard;
