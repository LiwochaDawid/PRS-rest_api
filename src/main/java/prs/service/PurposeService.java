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

import prs.dao.DoctorDAO;
import prs.dao.PurposeDAO;
import prs.dto.PurposeDTO;
import prs.dto.VisitDTO;
import prs.entity.Patient;
import prs.entity.Purpose;
import prs.entity.Visit;

@Transactional
@Service
public class PurposeService {
    @Autowired 
    private PurposeDAO purposeDAO;
    @Autowired 
    private DoctorDAO doctorDAO;
	
    /*
	public PurposeDTO getPurposeByID(int purposeID) {
		PurposeDTO purposeDTO = new PurposeDTO(purposeDAO.getPurposeByID(purposeID));
		return purposeDTO;
	}
	*/
    
    /*
    public List<PurposeDTO> getAllPurposes() {
		List<PurposeDTO> purposesDTO = new ArrayList<>();
		List<Purpose> purposes = purposeDAO.getAllPurposes();
		for (int i=0; i<purposes.size(); i++) {
			purposesDTO.add(new PurposeDTO(purposes.get(i)));
		}
		return purposesDTO;
	}
	*/
    
    public List<PurposeDTO> getDoctorPurposes(int id){
        List<PurposeDTO> purposesDTO = new ArrayList<>();
        List<Purpose> purposes = purposeDAO.getDoctorPurposes(id);
        for (int i=0; i<purposes.size(); i++) {
        	purposesDTO.add(new PurposeDTO(purposes.get(i)));
		}
        return purposesDTO;
    }
    
    public List<PurposeDTO> getDoctorPurposes(String username){
        List<PurposeDTO> purposesDTO = new ArrayList<>();
        List<Purpose> purposes = purposeDAO.getDoctorPurposes(username);
        for (int i=0; i<purposes.size(); i++) {
        	purposesDTO.add(new PurposeDTO(purposes.get(i)));
		}
        return purposesDTO;
    }
	
	public void addPurpose(Purpose purpose, String doctorName) {
		purpose.setDoctor(doctorDAO.getDoctorByUsername(doctorName));
		purposeDAO.addPurpose(purpose);
	}
}
