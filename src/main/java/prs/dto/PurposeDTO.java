/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.dto;

import java.sql.Time;

import prs.entity.Doctor;
import prs.entity.Purpose;
/**
 *
 * @author Janusz
 */
public class PurposeDTO {
    private int purposeID;
    private String name;
    private String description;
    private Time duration;
    private int price;
    
    public PurposeDTO(){
    }
    
    public PurposeDTO(Purpose purpose){
        this.purposeID = purpose.getPurposeID();
        this.name = purpose.getName();
        this.description = purpose.getDescription();
        this.duration = purpose.getDuration();
        this.price = purpose.getPrice();
    }
    
    public final int getPurposeID(){
        return purposeID;
    }
    
    public final void setPurposeID(int purposeID){
        this.purposeID = purposeID;
    }
    
    public final String getName(){
        return name;
    }
    
    public final void setName(String name){
        this.name = name;
    }
    
    public final String getDescription(){
        return description;
    }
    
    public final void setDescription(String description){
        this.description = description;
    }
    
    public final Time getDuration(){
        return duration;
    }
    
    public final void setDuration(Time duration){
        this.duration = duration;
    }
    
    public final int getPrice(){
        return price;
    }
    
    public final void setPrice(int price){
        this.price = price;
    }
}
