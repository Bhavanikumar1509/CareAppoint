export const API_BASE_URL = 'http://localhost:8080';

export const registerPatient = (patient) =>
  fetch(`${API_BASE_URL}/patient/register`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(patient),
  });

export const loginPatient = (patient) =>
  fetch(`${API_BASE_URL}/patient/login`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(patient),
  });

  export const registerDoctor = (doctor) =>
  fetch(`${API_BASE_URL}/doctor/register`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(doctor),
  });

  export const loginDoctor = (doctor) =>
  fetch(`${API_BASE_URL}/doctor/login`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(doctor),
  });

  export const loginAdmin = (admin) =>
  fetch(`${API_BASE_URL}/admin/login`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
    },
    body: JSON.stringify(admin),
  });