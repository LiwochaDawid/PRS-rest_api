/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.controller;

import java.security.Principal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import prs.service.VisitService;


import prs.dto.VisitDTO;
import prs.entity.Visit;
import prs.service.VisitService;
/**
 *
 * @author Janusz
 */

@Controller
@RequestMapping("visit")
public class VisitController {
    @Autowired
	private VisitService visitService;
    
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
    @GetMapping("all")
    public ResponseEntity<List<VisitDTO>> getAllVisits() {
		List<VisitDTO> visits = visitService.getAllVisits();
		return new ResponseEntity<List<VisitDTO>>(visits, HttpStatus.OK);
	}
	    
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("this")
	public ResponseEntity<List<VisitDTO>> getThisDoctorVisits(HttpServletRequest request){
	    Principal principal = request.getUserPrincipal();
	    List<VisitDTO> visits = visitService.getThisDoctorVisits(principal.getName());
	    return new ResponseEntity<List<VisitDTO>>(visits,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("future")
	public ResponseEntity<List<VisitDTO>> getThisDoctorFutureVisits(HttpServletRequest request){
		Principal principal = request.getUserPrincipal();
		List<VisitDTO> visits = visitService.getThisDoctorFutureVisits(principal.getName());
		return new ResponseEntity<List<VisitDTO>>(visits,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("past")
	public ResponseEntity<List<VisitDTO>> getThisDoctorPastVisits(HttpServletRequest request){
		Principal principal = request.getUserPrincipal();
		List<VisitDTO> visits = visitService.getThisDoctorPastVisits(principal.getName());
		return new ResponseEntity<List<VisitDTO>>(visits,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("today")
	public ResponseEntity<List<VisitDTO>> getThisDoctorTodayVisits(HttpServletRequest request){
		Principal principal = request.getUserPrincipal();
		List<VisitDTO> visits = visitService.getThisDoctorTodayVisits(principal.getName());
		return new ResponseEntity<List<VisitDTO>>(visits,HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("date/{date}")
	public ResponseEntity<List<VisitDTO>> getDoctorVisitsByDate(@PathVariable("date") String date, HttpServletRequest request) throws ParseException {
    	Principal principal = request.getUserPrincipal();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		java.util.Date parsedDate = format.parse(date);
		java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
    	List<VisitDTO> visits = visitService.getThisDoctorDateVisits(principal.getName(), sqlDate);
    	return new ResponseEntity<List<VisitDTO>>(visits, HttpStatus.OK);
	}
}
