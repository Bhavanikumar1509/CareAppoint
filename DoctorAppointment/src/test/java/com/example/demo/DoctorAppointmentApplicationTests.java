package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.demo.Controllers.AdminController;
import com.example.demo.DAO.AdminRepository;
import com.example.demo.DAO.PatientRepository;
import com.example.demo.Entites.Doctor;
import com.example.demo.Entites.Patient;
import com.example.demo.Services.AdminService;
import com.example.demo.dto.DoctorResponse;
import com.example.demo.dto.PatientResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@SpringBootTest
class DoctorAppointmentApplicationTests {
	 @Mock
	    private AdminService adminService;

	    @InjectMocks
	    private AdminController adminController;

	    private List<PatientResponse> patients;
	    private List<DoctorResponse> doctors;

	@Test
	void contextLoads() {
		
	}
	
	    
	    private MockMvc mockMvc;
		ObjectMapper objectMapper=new ObjectMapper();
		ObjectWriter objectWriter=objectMapper.writer();
		@Mock
		private AdminRepository adminRepository;
		private PatientRepository patientRepository;
		
		
		Patient patient_1=new Patient(1, "hello", "world", "how", "918522469");
		Patient patient_2=new Patient(2, "hell", "worl", "ho", "91852246");
		
		@SuppressWarnings("deprecation")
		@Before
		 public void setUp() {
			MockitoAnnotations.initMocks(this);
			this.mockMvc=MockMvcBuilders.standaloneSetup(adminController).build();
		}
	    

	    @BeforeEach
	    public void setup() {
	        patients = new ArrayList<>();
	        Patient patient1 = new Patient(1, "patient1@example.com", "password1", "John Doe", "1234567890");
	        Patient patient2 = new Patient(2, "patient2@example.com", "password2", "Jane Doe", "0987654321");
	        patients.addAll((Collection<? extends PatientResponse>) patient1);
	        patients.addAll((Collection<? extends PatientResponse>) patient2);

	        doctors = new ArrayList<>();
	        Doctor doctor1 = new Doctor(1, "doctor1@example.com", "password1", "Dr. John Smith", "1234567890", "Cardiology");
	        Doctor doctor2 = new Doctor(2, "doctor2@example.com", "password2", "Dr. Jane Smith", "0987654321", "Pediatrics");
	        doctors.addAll((Collection<? extends DoctorResponse>) doctor1);
	        doctors.addAll((Collection<? extends DoctorResponse>) doctor2);
	    }

	    @Test
	    public void testViewAllPatients() {
	        when(adminService.viewAllPatients()).thenReturn(patients);

	        ResponseEntity<List<PatientResponse>> responseEntity = (ResponseEntity<List<PatientResponse>>) adminController.viewAllPatients();

	        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

	        List<PatientResponse> patientResponses = responseEntity.getBody();

	        assertEquals(2, patientResponses.size());

	        PatientResponse patientResponse1 = patientResponses.get(0);
	        assertEquals("patient1@example.com", patientResponse1.getEmail());
	        assertEquals("John Doe", patientResponse1.getName());
	        assertEquals("1234567890", patientResponse1.getContact());

	        PatientResponse patientResponse2 = patientResponses.get(1);
	        assertEquals("patient2@example.com", patientResponse2.getEmail());
	        assertEquals("Jane Doe", patientResponse2.getName());
	        assertEquals("0987654321", patientResponse2.getContact());
	    }

	    
	    
	    
	    
	    
	    
	    @Test
		public void getAllPatients_sucess() throws Exception{
			List<Patient> patients=new ArrayList<>();
			patients.add(patient_1);
			patients.add(patient_2);
			Mockito.when(patientRepository.findAll()).thenReturn(patients);
			mockMvc.perform(MockMvcRequestBuilders
					.get("/admin/patients")
					.contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk());
		}
	    
	    
	    
	    @Test
	    public void testViewAllDoctors() {
	        when(adminService.viewAllDoctors()).thenReturn(doctors);

	        List<DoctorResponse> responseEntity = adminController.viewAllDoctors(null);

	       assertEquals(HttpStatus.OK, ((ResponseEntity<List<DoctorResponse>>) responseEntity).getStatusCode());

	       List<DoctorResponse> doctorResponses = ((HttpEntity<List<DoctorResponse>>) responseEntity).getBody();

	       assertEquals(2, doctorResponses.size());

	       DoctorResponse doctorResponse1 = doctorResponses.get(0);
	        assertEquals("doctor1@example.com", doctorResponse1.getEmail());
	        assertEquals("Dr. John Smith", doctorResponse1.getName());
	        assertEquals("1234567890", doctorResponse1.getContact());
	       
	        System.out.println("one test case passed");

	        DoctorResponse doctorResponse2 = doctorResponses.get(1);
	        assertEquals("doctor2@example.com", doctorResponse2.getEmail());
	        assertEquals("Dr. Jane Smith", doctorResponse2.getName());
	        assertEquals("0987654321", doctorResponse2.getContact());
	       
	    }
	    
}
