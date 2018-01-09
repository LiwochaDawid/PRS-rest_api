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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import prs.service.VisitService;
import prs.dto.VisitDTO;
import prs.dto.VisitDateDTO;
import prs.entity.Visit;

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
    
    /*
    @PreAuthorize("hasRole('ROLE_PATIENT')")
    @GetMapping("allDates")
    public ResponseEntity<List<VisitDateDTO>> getAllVisitDates() {
		List<VisitDateDTO> visits = visitService.getAllVisitDates();
		return new ResponseEntity<List<VisitDateDTO>>(visits, HttpStatus.OK);
	}
	*/
	    
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("thisDoctor")
	public ResponseEntity<List<VisitDTO>> getThisDoctorVisits(HttpServletRequest request){
	    Principal principal = request.getUserPrincipal();
	    List<VisitDTO> visits = visitService.getThisDoctorVisits(principal.getName());
	    return new ResponseEntity<List<VisitDTO>>(visits,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	@GetMapping("thisPatient")
	public ResponseEntity<List<VisitDTO>> getThisPatientVisits(HttpServletRequest request){
	    Principal principal = request.getUserPrincipal();
	    List<VisitDTO> visits = visitService.getThisPatientVisits(principal.getName());
	    return new ResponseEntity<List<VisitDTO>>(visits,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("futureDoctor")
	public ResponseEntity<List<VisitDTO>> getThisDoctorFutureVisits(HttpServletRequest request){
		Principal principal = request.getUserPrincipal();
		List<VisitDTO> visits = visitService.getThisDoctorFutureVisits(principal.getName());
		return new ResponseEntity<List<VisitDTO>>(visits,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	@GetMapping("futurePatient")
	public ResponseEntity<List<VisitDTO>> getThisPatientFutureVisits(HttpServletRequest request){
		Principal principal = request.getUserPrincipal();
		List<VisitDTO> visits = visitService.getThisPatientFutureVisits(principal.getName());
		return new ResponseEntity<List<VisitDTO>>(visits,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("pastDoctor")
	public ResponseEntity<List<VisitDTO>> getThisDoctorPastVisits(HttpServletRequest request){
		Principal principal = request.getUserPrincipal();
		List<VisitDTO> visits = visitService.getThisDoctorPastVisits(principal.getName());
		return new ResponseEntity<List<VisitDTO>>(visits,HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	@GetMapping("pastPatient")
	public ResponseEntity<List<VisitDTO>> getThisPatientPastVisits(HttpServletRequest request){
		Principal principal = request.getUserPrincipal();
		List<VisitDTO> visits = visitService.getThisPatientPastVisits(principal.getName());
		return new ResponseEntity<List<VisitDTO>>(visits,HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_PATIENT', 'ROLE_DOCTOR')")
	@GetMapping("allUpcomingVisits")
	public ResponseEntity<List<VisitDateDTO>> getAllFutureVisits(){
		List<VisitDateDTO> visits = visitService.getAllFutureVisits();
		return new ResponseEntity<List<VisitDateDTO>>(visits,HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("thisDoctorDate={date}")
	public ResponseEntity<List<VisitDTO>> getDoctorVisitsByDate(@PathVariable("date") String date, HttpServletRequest request) throws ParseException {
    	Principal principal = request.getUserPrincipal();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		java.util.Date parsedDate = format.parse(date);
		java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
    	List<VisitDTO> visits = visitService.getThisDoctorDateVisits(principal.getName(), sqlDate);
    	return new ResponseEntity<List<VisitDTO>>(visits, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("thisDoctorBetweenDateStart={dateStart}&dateEnd={dateEnd}")
	public ResponseEntity<List<VisitDTO>> getDoctorVisitsByDateBetween(@PathVariable("dateStart") String dateStart, @PathVariable("dateEnd") String dateEnd, HttpServletRequest request) throws ParseException {
    	Principal principal = request.getUserPrincipal();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		java.util.Date parsedDate = format.parse(dateStart);
		java.sql.Date sqlDateStart = new java.sql.Date(parsedDate.getTime());
		format = new SimpleDateFormat("ddMMyyyy");
		parsedDate = format.parse(dateEnd);
		java.sql.Date sqlDateEnd = new java.sql.Date(parsedDate.getTime());
    	List<VisitDTO> visits = visitService.getThisDoctorDateVisitsBetween(principal.getName(), sqlDateStart, sqlDateEnd);
    	return new ResponseEntity<List<VisitDTO>>(visits, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("patientID={id}")
	public ResponseEntity<List<VisitDTO>> getPatientVisitsByID(@PathVariable("id") int id) {
    	List<VisitDTO> visits = visitService.getPatientVisitsByID(id);
    	return new ResponseEntity<List<VisitDTO>>(visits, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("betweenPatientID={id}&dateStart={dateStart}&dateEnd={dateEnd}")
	public ResponseEntity<List<VisitDTO>> getPatientVisitsByIDBetween(@PathVariable("id") int id, @PathVariable("dateStart") String dateStart, @PathVariable("dateEnd") String dateEnd) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		java.util.Date parsedDate = format.parse(dateStart);
		java.sql.Date sqlDateStart = new java.sql.Date(parsedDate.getTime());
		format = new SimpleDateFormat("ddMMyyyy");
		parsedDate = format.parse(dateEnd);
		java.sql.Date sqlDateEnd = new java.sql.Date(parsedDate.getTime());
		List<VisitDTO> visits = visitService.getPatientVisitsByID(id, sqlDateStart, sqlDateEnd);
    	return new ResponseEntity<List<VisitDTO>>(visits, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_PATIENT')")
	@GetMapping("thisPatientDateStart={dateStart}&dateEnd={dateEnd}")
	public ResponseEntity<List<VisitDTO>> getThisPatientBetween(@PathVariable("dateStart") String dateStart, @PathVariable("dateEnd") String dateEnd, HttpServletRequest request) throws ParseException {
    	Principal principal = request.getUserPrincipal();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		java.util.Date parsedDate = format.parse(dateStart);
		java.sql.Date sqlDateStart = new java.sql.Date(parsedDate.getTime());
		format = new SimpleDateFormat("ddMMyyyy");
		parsedDate = format.parse(dateEnd);
		java.sql.Date sqlDateEnd = new java.sql.Date(parsedDate.getTime());
		List<VisitDTO> visits = visitService.getThisPatientDateVisitsBetween(principal.getName(), sqlDateStart, sqlDateEnd);
    	return new ResponseEntity<List<VisitDTO>>(visits, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_PATIENT')")
	@GetMapping("futureDoctorID={id}")
	public ResponseEntity<List<VisitDateDTO>> getDoctorFutureVisitsByID(@PathVariable("id") int id) {
    	List<VisitDateDTO> visits = visitService.getDoctorFutureVisitsByID(id);
    	return new ResponseEntity<List<VisitDateDTO>>(visits, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_PATIENT')")
	@GetMapping("doctorID={id}&date={date}")
	public ResponseEntity<List<VisitDateDTO>> getDoctorVisitsFromDay(@PathVariable("id") int id, @PathVariable("date") String date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		java.util.Date parsedDate = format.parse(date);
		java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
		List<VisitDateDTO> visits = visitService.getDoctorVisitsFromDay(id, sqlDate);
    	return new ResponseEntity<List<VisitDateDTO>>(visits, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("numberOfVisitsDate={date}")
	public ResponseEntity<Long> getDoctorNumberOfVisits(@PathVariable("date") String date, HttpServletRequest request) throws ParseException {
    	Principal principal = request.getUserPrincipal();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		java.util.Date parsedDate = format.parse(date);
		java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
		Long visits = visitService.getDoctorNumberOfVisits(principal.getName(), sqlDate);
    	return new ResponseEntity<Long>(visits, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("numberOfVisitsMonth={date}")
	public ResponseEntity<List<Long>> getDoctorNumberOfVisitsMonth(@PathVariable("date") String date, HttpServletRequest request) throws ParseException {
    	Principal principal = request.getUserPrincipal();
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		java.util.Date parsedDate = format.parse(date);
		java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
		List<Long> visits = visitService.getDoctorNumberOfMonthVisits(principal.getName(), sqlDate);
    	return new ResponseEntity<List<Long>>(visits, HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_PATIENT')")
	@GetMapping("numberOfVisitsByPatient={date}&doctorID={id}")
	public ResponseEntity<List<Long>> getDoctorNumberOfMonthVisitsByPatient(@PathVariable("date") String date, @PathVariable("id") int id) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("ddMMyyyy");
		java.util.Date parsedDate = format.parse(date);
		java.sql.Date sqlDate = new java.sql.Date(parsedDate.getTime());
		List<Long> visits = visitService.getDoctorNumberOfMonthVisitsByPatient(id, sqlDate);
    	return new ResponseEntity<List<Long>>(visits, HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	@PostMapping("addAsPatient")
	public ResponseEntity<Void> addVisitAsPatient(@RequestBody Visit visit, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		visitService.addVisitAsPatient(visit, principal.getName());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@PostMapping("addAsDoctor")
	public ResponseEntity<Void> addVisitAsDoctor(@RequestBody Visit visit, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		visitService.addVisitAsDoctor(visit, principal.getName());
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@PreAuthorize("hasRole('ROLE_PATIENT')")
	@PostMapping("deleteAsPatientVisitID={id}")
	public ResponseEntity<Void> deleteVisitAsPatient(@PathVariable("id") int id, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		
		if (visitService.deleteVisitAsPatient(id, principal.getName())) {
			return new ResponseEntity<Void>(HttpStatus.OK);			
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
		}
	}
	
	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@PostMapping("deleteAsDoctorVisitID={id}")
	public ResponseEntity<Void> deleteVisitAsDoctor(@PathVariable("id") int id, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		
		if (visitService.deleteVisitAsDoctor(id, principal.getName())) {
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Void>(HttpStatus.FORBIDDEN);
		}
	}
}