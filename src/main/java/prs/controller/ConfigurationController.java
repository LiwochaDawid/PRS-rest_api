/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.controller;

import java.security.Principal;
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

import prs.dto.ConfigurationDTO;
import prs.entity.Configuration;
import prs.service.ConfigurationService;

@Controller
@RequestMapping("configuration")
public class ConfigurationController {
    @Autowired
	private ConfigurationService configurationService;
	
    @PreAuthorize("hasRole('ROLE_PATIENT')")
	@GetMapping("doctor={id}")
	public ResponseEntity<ConfigurationDTO> getConfigurationByDoctorID(@PathVariable("id") Integer id) {
		ConfigurationDTO configuration = configurationService.getDoctorConfiguration(id);
		return new ResponseEntity<ConfigurationDTO>(configuration, HttpStatus.OK);
	}
    
    @PreAuthorize("hasRole('ROLE_DOCTOR')")
	@GetMapping("doctor")
	public ResponseEntity<ConfigurationDTO> getDoctorPurposes(HttpServletRequest request){
	    Principal principal = request.getUserPrincipal();
	    ConfigurationDTO configuration = configurationService.getDoctorConfiguration(principal.getName());
	    return new ResponseEntity<ConfigurationDTO>(configuration,HttpStatus.OK);
	}

	@PreAuthorize("hasRole('ROLE_DOCTOR')")
	@PostMapping("update")
	public ResponseEntity<Void> updateDoctor(@RequestBody Configuration configuration, HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		ConfigurationDTO oldConfiguration = configurationService.getDoctorConfiguration(principal.getName());
		configuration.setConfigurationID(oldConfiguration.getConfigurationID());
		configurationService.updateConfiguration(configuration);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}