/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import prs.dao.ConfigurationDAO;
import prs.dto.ConfigurationDTO;
import prs.entity.Configuration;

@Transactional
@Service
public class ConfigurationService {
    @Autowired 
    private ConfigurationDAO configurationDAO;
    
    public ConfigurationDTO getDoctorConfiguration(int id){
        ConfigurationDTO configurationDTO = new ConfigurationDTO(configurationDAO.getDoctorConfiguration(id));
        return configurationDTO;
    }
    
    public ConfigurationDTO getDoctorConfiguration(String username){
        ConfigurationDTO configurationDTO = new ConfigurationDTO(configurationDAO.getDoctorConfiguration(username));
        return configurationDTO;
    }
	
	public void updateConfiguration(Configuration configuration) {
		configurationDAO.updateConfiguration(configuration);
	}
}