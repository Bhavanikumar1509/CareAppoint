import { useState } from 'react';
import { API_BASE_URL } from '../api';
import './patient.css';

function DoctorDashboard() {
      const [startTime, setStartTime] = useState(new Date());
      const [endTime, setEndTime] = useState(new Date());
      const [fee, setFee] = useState(0);

    
      const handleStartTimeChange = date => setStartTime(date);
    
      const handleEndTimeChange = date => setEndTime(date);
    
      const handleFeeChange = event => setFee(event.target.value);
    
      const handleAddAppointment = event => {
        event.preventDefault();
        // Submit new appointment to backend API
        fetch(API_BASE_URL + '/doctor/addAppointment', {
          method: 'POST',
          headers: { 'Content-Type': 'application/json' },
          body: JSON.stringify({
            doctor_id : Number(localStorage.getItem("my-app-id")),
            startTime: startTime.toISOString(),
            endTime: endTime.toISOString(),
            fee: fee,
          }),
        })
          .then(response => {
              if(response.status !== 200)
              response.json()
            })
          .then(data => {
              console.log(data)
              alert("Added");
          })
          .catch(error => console.error(error));
      };
    
      return (
        <div className="register-patient">
          <h2>Add New Appointment</h2>
          <form onSubmit={handleAddAppointment}>
            <label htmlFor="start-time-picker">Start Time:</label>
            <input type="datetime-local" id="start-time-picker" value={startTime.toISOString().substr(0, 16)} onChange={event => handleStartTimeChange(new Date(event.target.value))} />
            <label htmlFor="end-time-picker">End Time:</label>
            <input type="datetime-local" id="end-time-picker" value={endTime.toISOString().substr(0, 16)} onChange={event => handleEndTimeChange(new Date(event.target.value))} />
            <label htmlFor="fee-input">Fee:</label>
            <input type="number" id="fee-input" value={fee} onChange={handleFeeChange} />
            <button type="submit">Add Appointment</button>
          </form>
        </div>
      );
}

export default DoctorDashboard;