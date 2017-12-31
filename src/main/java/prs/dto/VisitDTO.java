/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.dto;

import java.sql.Timestamp;

import prs.entity.Doctor;
import prs.entity.Patient;
import prs.entity.Visit;
/**
 *
 * @author Janusz
 */
public class VisitDTO {
    private int visitID;
    private Timestamp date;
    private String comment;
    private PatientDTO patient;
    private DoctorDTO doctor;
    private PurposeDTO purpose;
    
    public VisitDTO(Visit visit){
        this.visitID=visit.getVisitID();
        this.date = visit.getDate();
        this.comment= visit.getComment();
        this.patient=new PatientDTO(visit.getPatient());
        this.doctor=new DoctorDTO(visit.getDoctor());
    }
    
    public final void setVisitID(int visitID){
        this.visitID=visitID;
    }
    
    public final void setDate(Timestamp date){
        this.date=date;
    }
    
    public final void setComment(String comment){
        this.comment=comment;
    }
    
    public final void setDoctor(DoctorDTO doctor)
    {
        this.doctor = doctor;
    }
    
    public final void setPatient(PatientDTO patient)
    {
        this.patient = patient;
    }
    
    public final void setPurpose(PurposeDTO purpose)
    {
        this.purpose = purpose;
    }
    
    public final int getVisitID(){
        return visitID;
    }
    
    public final Timestamp getDate()
    {
        return date;
    }
    
    public final String getComment(){
        return comment;
    }
    
    public final DoctorDTO getDoctor(){
        return doctor;
    }
    
    public final PatientDTO getPatient(){
        return patient;
    }
    
    public final PurposeDTO getPurpose(){
        return purpose;
    }
}
