/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

import prs.service.PurposeService;
import prs.dto.PurposeDTO;
import prs.entity.Purpose;

@Controller
@RequestMapping("purpose")
public class PurposeController {
    @Autowired
	private PurposeService purposeService;
	
    /*
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("{id}")
	public ResponseEntity<PurposeDTO> getPurposeByID(@PathVariable("id") Integer id) {
		PurposeDTO purpose = purposeService.getPurposeByID(id);
		return new ResponseEntity<PurposeDTO>(purpose, HttpStatus.OK);
	}
	*/
	
    /*
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("all")
    public ResponseEntity<List<PurposeDTO>> getAllPurposes() {
		List<PurposeDTO> purposes = purposeService.getAllPurposes();
		return new ResponseEntity<List<PurposeDTO>>(purposes, HttpStatus.OK);
	}
	*/
	
    @PreAuthorize("hasRole('ROLE_PATIENT')")
	@GetMapping("doctor={id}")
	public ResponseEntity<List<PurposeDTO>> getPurposesByDoctorID(@PathVariable("id") Integer id) {
		List<PurposeDTO> purposes = purposeService.getDoctorPurposes(id);
		return new ResponseEntity<List<PurposeDTO>>(purposes, HttpStatus.OK);
	}
    
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("doctor")
	public ResponseEntity<List<PurposeDTO>> getDoctorPurposes(HttpServletRequest request){
	    Principal principal = request.getUserPrincipal();
	    List<PurposeDTO> purposes = purposeService.getDoctorPurposes(principal.getName());
	    return new ResponseEntity<List<PurposeDTO>>(purposes,HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@PostMapping("add")
	public ResponseEntity<Void> addPurpose(@RequestBody Purpose purpose, HttpServletRequest request) {
	    Principal principal = request.getUserPrincipal();
		purposeService.addPurpose(purpose, principal.getName());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}