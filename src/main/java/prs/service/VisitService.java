/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prs.dto.VisitDTO;
import prs.dto.VisitDateDTO;
import prs.dao.DoctorDAO;
import prs.dao.PatientDAO;
import prs.dao.VisitDAO;
import prs.entity.Visit;

@Transactional
@Service
public class VisitService {
    @Autowired
    private VisitDAO visitDAO;
    @Autowired
    private DoctorDAO doctorDAO;
    @Autowired
    private PatientDAO patientDAO;
    
    public List<VisitDTO> getAllVisits() {
		List<VisitDTO> visitsDTO = new ArrayList<>();
		List<Visit> visits = visitDAO.getAllVisits();
		for (int i=0; i<visits.size(); i++) {
			visitsDTO.add(new VisitDTO(visits.get(i)));
		}
		return visitsDTO;
	}
    
    public List<VisitDateDTO> getAllVisitDates() {
        List<VisitDateDTO> visitDateDTO = new ArrayList<>();
		List<Visit> visits = visitDAO.getAllVisits();
		for (int i=0; i<visits.size(); i++) {
        	visitDateDTO.add(new VisitDateDTO(visits.get(i).getDate(), visits.get(i).getPurpose().getDuration()));
		}
		return visitDateDTO;
	}

    public List<VisitDTO> getThisDoctorVisits(String username){
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getThisDoctorVisits(username);
        for (int i=0; i<visits.size(); i++) {
			visitDTO.add(new VisitDTO(visits.get(i)));
		}
        return visitDTO;
    }
    
    public List<VisitDTO> getThisPatientVisits(String username){
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getThisPatientVisits(username);
        for (int i=0; i<visits.size(); i++) {
			visitDTO.add(new VisitDTO(visits.get(i)));
		}
        return visitDTO;
    }
    
    public List<VisitDTO> getThisDoctorFutureVisits(String username){
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getThisDoctorFutureVisits(username);
        for (int i=0; i<visits.size(); i++) {
			visitDTO.add(new VisitDTO(visits.get(i)));
		}
        return visitDTO;
    }
    
    public List<VisitDTO> getThisPatientFutureVisits(String username){
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getThisPatientFutureVisits(username);
        for (int i=0; i<visits.size(); i++) {
			visitDTO.add(new VisitDTO(visits.get(i)));
		}
        return visitDTO;
    }
    
    public List<VisitDTO> getThisDoctorPastVisits(String username){
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getThisDoctorPastVisits(username);
        for (int i=0; i<visits.size(); i++) {
			visitDTO.add(new VisitDTO(visits.get(i)));
		}
        return visitDTO;
    }
    
    public List<VisitDTO> getThisPatientPastVisits(String username){
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getThisPatientPastVisits(username);
        for (int i=0; i<visits.size(); i++) {
			visitDTO.add(new VisitDTO(visits.get(i)));
		}
        return visitDTO;
    }
    
    public List<VisitDateDTO> getAllFutureVisits(){
        List<VisitDateDTO> visitDateDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getAllFutureVisits();
        for (int i=0; i<visits.size(); i++) {
        	visitDateDTO.add(new VisitDateDTO(visits.get(i).getDate(), visits.get(i).getPurpose().getDuration()));
		}
        return visitDateDTO;
    }
    
    public List<VisitDTO> getThisDoctorTodayVisits(String name){
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getThisDoctorTodayVisits(name);
        for (int i=0; i<visits.size(); i++) {
			visitDTO.add(new VisitDTO(visits.get(i)));
		}
        return visitDTO;
    }

    public List<VisitDTO> getThisDoctorDateVisits(String name, Date date) {
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getThisDoctorDateVisits(name, date);
        for (int i=0; i<visits.size(); i++) {
            visitDTO.add(new VisitDTO(visits.get(i)));
        }
        return visitDTO;
    }

    public List<VisitDTO> getThisDoctorDateVisitsBetween(String name, Date dateStart, Date dateEnd) {
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getThisDoctorDateVisitsBetween(name, dateStart, dateEnd);
        for (int i=0; i<visits.size(); i++) {
            visitDTO.add(new VisitDTO(visits.get(i)));
        }
        return visitDTO;
    }

    public List<VisitDTO> getPatientVisitsByID(int id) {
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getPatientVisitsByID(id);
        for (int i=0; i<visits.size(); i++) {
            visitDTO.add(new VisitDTO(visits.get(i)));
        }
        return visitDTO;
    }

    public List<VisitDTO> getPatientVisitsByID(int id, Date dateStart, Date dateEnd) {
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getPatientVisitsByID(id, dateStart, dateEnd);
        for (int i=0; i<visits.size(); i++) {
            visitDTO.add(new VisitDTO(visits.get(i)));
        }
        return visitDTO;
    }

    public List<VisitDTO> getThisPatientDateVisitsBetween(String name, Date dateStart, Date dateEnd) {
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getThisPatientDateVisitsBetween(name, dateStart, dateEnd);
        for (int i=0; i<visits.size(); i++) {
            visitDTO.add(new VisitDTO(visits.get(i)));
        }
        return visitDTO;
    }
    
    public List<VisitDateDTO> getDoctorFutureVisitsByID(int id){
        List<VisitDateDTO> visitDateDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getDoctorFutureVisitsByID(id);
        for (int i=0; i<visits.size(); i++) {
        	visitDateDTO.add(new VisitDateDTO(visits.get(i).getDate(), visits.get(i).getPurpose().getDuration()));
		}
        return visitDateDTO;
    }

    public Long getDoctorNumberOfVisits(String name, Date date) {
        return visitDAO.getDoctorNumberOfVisits(name, date);
    }

    public List<Long> getDoctorNumberOfMonthVisits(String name, Date date) {
    	Calendar callendar = new GregorianCalendar();
    	callendar.setTime(date);
    	callendar.set(Calendar.DAY_OF_MONTH, 1);
    	int daysInMonth = callendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    	
    	List<Long> numberOfVisits = new ArrayList<Long>();
    	
    	for (int i = 1; i <= daysInMonth; i++) {
    		numberOfVisits.add(visitDAO.getDoctorNumberOfVisits(name, new java.sql.Date(callendar.getTimeInMillis())));
        	callendar.add(Calendar.DATE, 1);
    	}
        return numberOfVisits;
    }
	
	public void addVisitAsPatient(Visit visit, String name) {
		visit.getPatient().setPatientID(patientDAO.getPatientByUsername(name).getPatientID());
		addVisit(visit);
	}
	
	public void addVisitAsDoctor(Visit visit, String name) {
		visit.getDoctor().setDoctorID(doctorDAO.getDoctorByUsername(name).getDoctorID());
		addVisit(visit);
	}
	
	public void addVisit(Visit visit) {
		//Conflict handling missing
		visitDAO.addVisit(visit);
	}
}