/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import prs.dto.VisitDTO;
import prs.dao.VisitDAO;
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
    
    
    public List<VisitDTO> getAllVisits() {
		List<VisitDTO> visitsDTO = new ArrayList<>();
		List<Visit> visits = visitDAO.getAllVisits();
		for (int i=0; i<visits.size(); i++) {
			visitsDTO.add(new VisitDTO(visits.get(i)));
		}
		return visitsDTO;
	}
    
    
    public List<VisitDTO> getThisDoctorVisits(String username){
        List<VisitDTO> visitDTO = new ArrayList<>();
        List<Visit> visits = visitDAO.getThisDoctorVisits(username);
        for (int i=0; i<visits.size(); i++) {
			visitDTO.add(new VisitDTO(visits.get(i)));
		}
        return visitDTO;
    }
}
