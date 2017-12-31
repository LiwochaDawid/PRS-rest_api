package prs.controller;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import prs.dto.DoctorDTO;
import prs.dto.PatientDTO;
import prs.entity.Doctor;
import prs.service.DoctorService;


@Controller
@RequestMapping("doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	
	@PreAuthorize("hasAnyRole('ROLE_PATIENT', 'ROLE_DOCTOR')")
	@GetMapping("{id}")
	public ResponseEntity<DoctorDTO> getDoctor(@PathVariable("id") Integer id) {
		DoctorDTO doctor = doctorService.getDoctorByID(id);
		return new ResponseEntity<DoctorDTO>(doctor, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("this")
    public ResponseEntity<DoctorDTO> getCurrentDoctor(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
		DoctorDTO doctor = doctorService.getDoctorByUsername(principal.getName());
		return new ResponseEntity<DoctorDTO>(doctor, HttpStatus.OK);
    }
	
	@PreAuthorize("hasAnyRole('ROLE_PATIENT', 'ROLE_DOCTOR')")
	@GetMapping("all")
	public ResponseEntity<List<DoctorDTO>> getAllDoctors() {
		List<DoctorDTO> doctors = doctorService.getAllDoctors();
		return new ResponseEntity<List<DoctorDTO>>(doctors, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@PostMapping("update")
	public ResponseEntity<Void> updateDoctor(@RequestBody Doctor doctor, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		DoctorDTO oldDoctor = doctorService.getDoctorByUsername(principal.getName());
		doctor.setDoctorID(oldDoctor.getDoctorID());
		doctorService.updateDoctor(doctor);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
