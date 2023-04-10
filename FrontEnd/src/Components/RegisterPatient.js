import { useState} from 'react';
import { registerPatient } from '../api';
import { useNavigate } from 'react-router-dom';
import './patient.css';


export default function RegisterPatient() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [contact, setContact]=useState('');

  const navigate = useNavigate();

  const handleSubmit = (event) => {
    event.preventDefault();

    const patient = { name, email, password,contact };
    console.log(patient);
    registerPatient(patient)
      .then((response) => {
        console.log(response)
        alert("Registered SucessFully");
        navigate('/patient/login')
      })
      .catch((error) => {
        console.error(error);
        
      });
  };

  return (
    <div className='register-patient'>
          
    <h2>Register Patient</h2>
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
               pattern='/^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/' required/>
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
            </label>
            <button type='submit'>Register</button>
        </form>
    </div>
  );
}
