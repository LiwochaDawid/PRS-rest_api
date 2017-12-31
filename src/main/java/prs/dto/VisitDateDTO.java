/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.dto;

import java.sql.Time;
import java.sql.Timestamp;

public class VisitDateDTO {
    private Timestamp date;
    private Time duration;
    
    public VisitDateDTO(){
    }
    
    public final Timestamp getDate()
    {
        return date;
    }
    
    public final void setDate(Timestamp date){
        this.date=date;
    }
    
    public final Time getDuration()
    {
        return duration;
    }
    
    public final void setDuration(Time duration){
        this.duration = duration;
    }
}
