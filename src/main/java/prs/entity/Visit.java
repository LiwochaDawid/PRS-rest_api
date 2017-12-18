/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Janusz
 */
@Entity
@Table(name="visits")
public class Visit {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="visit_id")
	private int visitID;
	@OneToOne
	@JoinColumn(name = "patient_id")
	private Patient patient;
	@OneToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
    @Column(name="date")
	private Timestamp date;
    @Column(name="comment")
    private String comment;
    
    public final int getVisitID()
    {
        return visitID;
    }
    
    public final Patient getPatient()
    {
        return patient;
    }
    
    public final Doctor getDoctor()
    {
        return doctor;
    }
    
    public final Timestamp getDate()
    {
        return date;
    }
    
    public final String getComment()
    {
        return comment;
    }
    
    public final void setVisitID(int visitID)
    {
        this.visitID=visitID;
    }
    
    public final void setPatient(Patient patient)
    {
        this.patient=patient;
    }
    
    public final void setDoctor(Doctor doctor)
    {
        this.doctor=doctor;
    }
    
    public final void setDate(Timestamp date)
    {
        this.date=date;
    }
    
    public final void setComment(String comment)
    {
        this.comment=comment;
    }
}


