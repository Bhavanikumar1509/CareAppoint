
import { useState} from 'react';
import { loginAdmin} from '../api';
import { useNavigate } from 'react-router-dom';
import './patient.css';

export default function LoginAdmin() {
    
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const [isError, setIsError] = useState(false);
    const navigate = useNavigate();
    const handleSubmit = (event) => {
        event.preventDefault();
        const admin = { email, password };
        console.log(admin);
        loginAdmin(admin)
        .then((response) => {
            if(response.status === 401){
              alert("Logged in Failed");
                setIsError(true);
                setTimeout(()=>{
                  setIsError(false);
                }, 3000)  
                return
            }
            console.log(response);
            navigate('/doctor')
          })
          .catch((error) => {
              setIsError(true);
              setTimeout(()=>{
                setIsError(false);
              }, 3000)
            console.error(error);
            
          });
      };
  
   
    return (
        <div className='register-patient'>
            <h2>Admin Login</h2>
            
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
        </form>
    </div>
    );
}
