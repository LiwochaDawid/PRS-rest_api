/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prs.dto.PurposeDTO;
import prs.dto.VisitDTO;
import prs.dto.VisitDateDTO;
import prs.dao.VisitDAO;
import prs.entity.Purpose;
import prs.entity.Visit;

/**
 *
 * @author Janusz
 */

@Transactional
@Service
public class VisitService {
    @Autowired 
    private VisitDAO visitDAO;
    
    /*
    public List<VisitDTO> getAllVisits() {
		List<VisitDTO> visitsDTO = new ArrayList<>();
		List<Visit> visits = visitDAO.getAllVisits();
		for (int i=0; i<visits.size(); i++) {
			visitsDTO.add(new VisitDTO(visits.get(i)));
		}
		return visitsDTO;
	}
	*/

    public List<VisitDTO> getThisDoctorVisits(String username){
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getThisVisits(username);
        for (int i=0; i<visits.size(); i++) {
			visitDTO.add(new VisitDTO(visits.get(i)));
		}
        return visitDTO;
    }
    
    /*
    public List<VisitDateDTO> getThisPatientVisits(String username){
        List<VisitDateDTO> visitDateDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getThisVisits(username);
        for (int i=0; i<visits.size(); i++) {
        	VisitDTO visit = new VisitDTO();
        	visit.setDate(visits.get(i).getDate());
        	visit.setPurpose(new PurposeDTO());
        	.setDuration(visits.get(i).getPurpose().getDuration());
			visitDateDTO.add(visitDate);
		}
        return visitDateDTO;
    }
    */
    
    public List<VisitDTO> getThisDoctorFutureVisits(String username){
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getThisDoctorFutureVisits(username);
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
}
