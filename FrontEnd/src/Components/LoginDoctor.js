
import { useState} from 'react';
import { loginDoctor} from '../api';
import { useNavigate ,Link} from 'react-router-dom';
import './patient.css';
export default function LoginDoctor() {
    
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const [isError, setIsError] = useState(false);
    const navigate = useNavigate();
    const handleSubmit = async (event) => {
        event.preventDefault();
        const doctor = { email, password };
        console.log(doctor);
        const response = await loginDoctor(doctor);
        if(response.status !== 200){
          alert("Logged in Failed");
          setIsError(true);
          setTimeout(()=>{
            setIsError(false);
          }, 3000)
        }
        const data = await response.json();
        localStorage.setItem("my-app-id", data.doctor_id);
        console.log(data.doctor_id)
        alert("Logged in SucessFully");
        navigate('/doctor')
      };
  
   
    return (
        <div className='register-patient'>
            <h2>Doctor Login</h2>
            
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
        <p>Don't Have Account ? <Link to='/doctor/register' > Create Account</Link></p>
        </form>
    </div>
    );
}
