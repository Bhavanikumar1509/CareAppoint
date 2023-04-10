
import React, { useState, useEffect } from "react";
import { API_BASE_URL } from '../api';
import './appoint.css';


function BookAppointment() {
  const [specializations, setSpecializations] = useState([]);
  const [appointments, setAppointments] = useState([]);
  const [selectedSpecialization, setSelectedSpecialization] = useState("");

  useEffect(() => {
    // Fetch the list of specializations from the Spring Boot API
    fetch(API_BASE_URL+'/admin/specializations')
      .then(response => response.json())
      .then(data => setSpecializations(data))
      .catch(error => console.error(error));
  }, []);

  useEffect(() => {
    let url = "/patient/appointments/available";
    // Fetch the list of available appointments for the selected specialization from the Spring Boot API
    if (selectedSpecialization) 
      url += `?specialization=${selectedSpecialization}`;
    fetch(API_BASE_URL + url)
        .then(response => response.json())
        .then(data => setAppointments(data))
        .catch(error => console.error(error));
  }, [selectedSpecialization]);

  const handleSpecializationChange = event => {
    setSelectedSpecialization(event.target.value);
  };

  const handleBookAppointment = (id) => {
    // Send a POST request to the Spring Boot API to book the selected appointment
    fetch(API_BASE_URL+`/patient/appointments/available/book`,
     {  method: "POST",
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          patient_id : Number(localStorage.getItem("my-app-id")),
          appointment_id : Number(id),
        }),
     })
      .then((response) => {
        // Clear the selected appointment and fetch the updated list of appointments
        if(response.status !== 200){
          alert("Appointment booking failed.");
          return
        }
        fetch(API_BASE_URL + "/patient/appointments/available")
          .then(response => response.json())
          .then(data => setAppointments(data))
          .catch(error => console.error(error));
      })
      .catch(error => console.error(error));
  };

  return (
    <div>
      <label htmlFor="specialization">Select a specialization:</label>
      <select id="specialization" value={selectedSpecialization} onChange={handleSpecializationChange}>
        <option value="">--Select--</option>
        {specializations.map(specialization => (
          <option key={specialization} value={specialization}>{specialization}</option>
        ))}
      </select>
      <table>
        <tr>
          <th>Doctor Name</th>
          <th>Doctor Email</th>
          <th>Doctor Contact</th>
          <th>Doctor Specialization</th>
          <th>Start Time</th>
          <th>End Time</th>
          <th>Fee</th>
          <th>Status</th>
          <th>Confirm Book</th>
        </tr>
      {appointments && (
            appointments.map((appointment)=>{
              console.log(appointment)
              return <tr>
                <td>{appointment.doctor_name}</td>
                <td>{appointment.doctor_email}</td>
                <td>{appointment.doctor_contact}</td>
                <td>{appointment.specialization}</td>
                <td>{appointment.startTime}</td>
                <td>{appointment.endTime}</td>
                <td>{appointment.fee}</td>
                <td>{appointment.status}</td>
                <td>{
                  <button 
                    disabled={appointment.status === "BOOKED"} 
                    onClick={()=>handleBookAppointment(appointment.appointment_id)}>Book</button>
                }</td>
              </tr>
              
            })
            
        )}
        </table>
      {!appointments && <h1>No appointments available...</h1>}
      
    </div>
  );
}

export default BookAppointment;
