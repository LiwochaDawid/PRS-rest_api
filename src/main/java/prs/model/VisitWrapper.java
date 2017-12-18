/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.model;

import prs.entity.Doctor;
import prs.entity.Patient;
import prs.entity.Visit;

/**
 *
 * @author Janusz
 */
public class VisitWrapper {
 
    private Patient patient;
    private Doctor doctor;
    private Visit visit;
    
    public final Patient getPatient() {
		return patient;
	}
    
    public final void setPatient(Patient patient) {
		this.patient = patient;
	}
        
    public final Doctor getDoctor() {
		return doctor;
	}
    
    public final void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}
    
    public final Visit getVisit()
    {
        return visit;
    }
    
    public final void setVisit(Visit visit)
    {
        this.visit = visit;
    }
}
