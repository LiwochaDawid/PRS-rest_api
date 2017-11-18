package prs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import prs.entity.Doctor;
import prs.service.DoctorService;
import prs.wrapper.DoctorWrapper;


@Controller
@RequestMapping("doctor")
public class DoctorController {
	@Autowired
	private DoctorService doctorService;
	@GetMapping("{id}")
	public ResponseEntity<Doctor> getDoctor(@PathVariable("id") Integer id) {
		Doctor doctor = doctorService.getDoctor(id);
		return new ResponseEntity<Doctor>(doctor, HttpStatus.OK);
	}
	@GetMapping("all")
	public ResponseEntity<List<Doctor>> getAllDoctors() {
		List<Doctor> doctors = doctorService.getAllDoctors();
		return new ResponseEntity<List<Doctor>>(doctors, HttpStatus.OK);
	}
	@PostMapping("sign_up")
	public ResponseEntity<Void> addDoctor(@RequestBody DoctorWrapper doctorWrapper, UriComponentsBuilder builder) {
		boolean isSuccess = doctorService.addDoctor(doctorWrapper);
        if (!isSuccess) {
        	return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        else {
        	return new ResponseEntity<Void>(HttpStatus.CREATED);
        }
	}
}
