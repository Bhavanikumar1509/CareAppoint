
import { useState} from 'react';
import { loginPatient } from '../api';
import { useNavigate, Link } from 'react-router-dom';
import './patient.css';

export default function LoginPatient() {
    
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const [isError, setIsError] = useState(false);
    const navigate = useNavigate();
    const handleSubmit = (event) => {
        event.preventDefault();
        const patient = { email, password };
        console.log(patient);
        loginPatient(patient)
        .then((response) => {
            if(response.status === 401){
              alert("Logged in Failed");
                setIsError(true);
                setTimeout(()=>{
                  setIsError(false);
                }, 3000)  
                return
            }
            return response.json()
          }).then((data)=>{
            localStorage.setItem("my-app-id", data.patient_id)
            alert("Logged in SucessFully");
            navigate('/patient')
          })
          .catch((error) => {
              setIsError(true);
              setTimeout(()=>{
                setIsError(false);
              }, 3000)
            console.error(error)
            ;
            
          });
      };
  
   
    return (
        <div className='register-patient'>
            <h2>Patient Login</h2>
            
            <form onSubmit={handleSubmit}>
            <label>E-Mail :
                <input
                type='email'
                value={email}
                onChange={(e) => setEmail(e.target.value)}
                />
            </label><br/>
            <label>Password :
                <input
                type='password'
                value={password}
                onChange={(e) => setPassword(e.target.value)}
                />
            </label>
            
        <button type='submit'>Login</button>
        {isError ? "Login Failed" : null }
       <p>Don't Have Account ? <Link to='/patient/register' > Create Account</Link></p> 
        </form>
    </div>
    );
}
