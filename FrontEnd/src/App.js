
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import LoginPatient from './Components/LoginPatient';
import RegisterPatient from './Components/RegisterPatient';
import RegisterDoctor from './Components/RegisterDoctor';
import PatientDashboard from './Components/PatientDashboard';
import LoginDoctor from './Components/LoginDoctor';
import DoctorDashboard from './Components/DoctorDashboard';
import AdminDashboard from './Components/AdminDashboard';
import LoginAdmin from './Components/LoginAdmin';
import './App.css';
import HomePage from './Components/HomePage';

function App() {
  return (
    <BrowserRouter>
      <Routes>
          <Route exact path='/' Component={HomePage}/>
          <Route exact path='/patient' Component={PatientDashboard}/>
          <Route exact path='/doctor' Component={DoctorDashboard}/>
          <Route exact path='/admin' Component={AdminDashboard}/>
          <Route path='/patient/login' Component={LoginPatient} />
          <Route path='/patient/register' Component={RegisterPatient}/>
          <Route path='/doctor/register' Component={RegisterDoctor}/>
          <Route path='/doctor/login' Component={LoginDoctor}/>
          <Route path='/admin/login' Component={LoginAdmin}/>
      </Routes>
    </BrowserRouter>    
  );
}

export default App;
