/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.dto;

import java.sql.Date;
import prs.entity.Doctor;
import prs.entity.Patient;
import prs.entity.Visit;
/**
 *
 * @author Janusz
 */
public class VisitDTO {
    private int visitID;
    private Date date;
    private String comment;
    private PatientDTO patient;
    private DoctorDTO doctor;
    
    public VisitDTO(Visit visit){
        this.visitID=visit.getVisitID();
        this.date = visit.getDate();
        this.comment= visit.getComment();
        this.doctor=new DoctorDTO(visit.getDoctor());
    }
    
    public final void setVisitID(int visitID){
        this.visitID=visitID;
    }
    
    public final void setDate(Date date){
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
    
    public final int getVisitID(){
        return visitID;
    }
    
    public final Date getDate()
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
}
