/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prs.dao.PurposeDAO;
import prs.dto.PurposeDTO;

@Transactional
@Service
public class PurposeService {
    @Autowired 
private PurposeDAO purposeDAO;
	
	public PurposeDTO getPurposeByID(int purposeID) {
		PurposeDTO purposeDTO = new PurposeDTO(purposeDAO.getPurposeByID(purposeID));
		return purposeDTO;
	}
}
