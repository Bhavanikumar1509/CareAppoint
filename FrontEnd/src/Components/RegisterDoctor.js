import { useState} from 'react';
import { registerDoctor } from '../api';
import { useNavigate } from 'react-router-dom';
import './patient.css';


export default function RegisterDoctor() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [contact, setContact]=useState('');
  const [specialization, setSpecialization]=useState('');

  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();

    const doctor = { name, email, password, contact, specialization};
    console.log(doctor);
    registerDoctor(doctor)
      .then((response) => {
        console.log(response);
        navigate('/doctor/login')
      })
      .catch((error) => {
        console.error(error);
        
      });
  };

  return (
    <div className='register-patient'>
          
    <h2>Register Doctor</h2>
        <form onSubmit={handleSubmit}>
            <label>Name : 
                <input
                    type='text'
                    name='name'
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                    minLength={6} maxLength={10} required/>
            </label><br/>
            <label>E-Mail :
                <input
                type='email'
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                required/>
            </label><br/>
            <label>Password :
                <input
                type='password'
                value={password}
                onChange={(e) => setPassword(e.target.value)}
               minLength={6} maxLength={10} required/>
            </label><br/>
            <label>Contact :
                <input
                type='text'
                value={contact}
                onChange={(e) => setContact(e.target.value)}
                required/>
            </label><br/>
            <label>Specialization :
                <input
                type='text'
                value={specialization}
                onChange={(e) => setSpecialization(e.target.value)}
                required/>
            </label>
            <button type='submit'>Register</button>
        </form>
    </div>
  );
}
