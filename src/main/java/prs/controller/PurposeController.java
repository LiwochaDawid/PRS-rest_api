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
import org.springframework.web.bind.annotation.RequestMapping;

import prs.service.PurposeService;
import prs.dto.PurposeDTO;

@Controller
@RequestMapping("purpose")
public class PurposeController {
    @Autowired
	private PurposeService purposeService;
	
	@PreAuthorize("hasAnyRole('ROLE_PATIENT', 'ROLE_DOCTOR')")
	@GetMapping("{id}")
	public ResponseEntity<PurposeDTO> getPurpose(@PathVariable("id") Integer id) {
		PurposeDTO purpose = purposeService.getPurposeByID(id);
		return new ResponseEntity<PurposeDTO>(purpose, HttpStatus.OK);
	}
}
