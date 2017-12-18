/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.entity;

import java.sql.Time;

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
@Table(name="purposes")
public class Purpose {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="purpose_id")
	private int purposeID;
	@JoinColumn(name = "name")
	private String name;
	@JoinColumn(name = "description")
	private String description;
    @Column(name="duration")
	private Time duration;
    @Column(name="price")
    private int price;
    @Column(name="doctor_id")
    private int doctorID;

    public final int getPurposeID()
    {
        return purposeID;
    }

    public final void setPurposeID(int purposeID)
    {
    	this.purposeID = purposeID;
    }

    public final String getName()
    {
        return name;
    }

    public final void setName(String name)
    {
    	this.name = name;
    }

    public final String getDescription()
    {
        return description;
    }

    public final void setDescription(String description)
    {
    	this.description = description;
    }

    public final Time getDuration()
    {
        return duration;
    }

    public final void setDuration(Time duration)
    {
    	this.duration = duration;
    }

    public final int getPrice()
    {
        return price;
    }

    public final void setPrice(int price)
    {
    	this.price = price;
    }

    public final int getDoctorID()
    {
        return doctorID;
    }

    public final void setDoctorID(int doctorID)
    {
    	this.doctorID = doctorID;
    }
}


