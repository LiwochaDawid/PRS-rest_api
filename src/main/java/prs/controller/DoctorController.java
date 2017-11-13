package prs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import prs.entity.Doctor;
import prs.service.DoctorService;

@Controller
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@GetMapping("doctor/{id}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable("id") Integer id) {
		Doctor doctor = doctorService.getDoctor(id);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}
	@GetMapping("doctors")
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> doctors = doctorService.getAllDoctors();
		return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
	}
}
