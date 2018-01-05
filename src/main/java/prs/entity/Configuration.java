/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.entity;

import java.sql.Date;
import java.sql.Time;
import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name="configurations")
public class Configuration {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="configuration_id")
	private int configurationID;
    @Column(name="mo_work_start")
    private Time moWorkStart;
    @Column(name="mo_work_end")
    private Time moWorkEnd;
    @Column(name="tu_work_start")
    private Time tuWorkStart;
    @Column(name="tu_work_end")
    private Time tuWorkEnd;
    @Column(name="we_work_start")
    private Time weWorkStart;
    @Column(name="we_work_end")
    private Time weWorkEnd;
    @Column(name="th_work_start")
    private Time thWorkStart;
    @Column(name="th_work_end")
    private Time thWorkEnd;
    @Column(name="fr_work_start")
    private Time frWorkStart;
    @Column(name="fr_work_end")
    private Time frWorkEnd;
    @Column(name="sa_work_start")
    private Time saWorkStart;
    @Column(name="sa_work_end")
    private Time saWorkEnd;
    @Column(name="su_work_start")
    private Time suWorkStart;
    @Column(name="su_work_end")
    private Time suWorkEnd;
    @Column(name="registration_term")
    private Date registrationTerm;
    @Column(name="max_visits")
    private int maxVisits;
	@OneToOne
	@JoinColumn(name = "doctor_id")
	private Doctor doctor;
    
    public final int getConfigurationID()
    {
        return configurationID;
    }
    
    public final Time getMoWorkStart()
    {
        return moWorkStart;
    }
    
    public final Time getMoWorkEnd()
    {
        return moWorkEnd;
    }
    
    public final Time getTuWorkStart()
    {
        return tuWorkStart;
    }
    
    public final Time getTuWorkEnd()
    {
        return tuWorkEnd;
    }
    
    public final Time getWeWorkStart()
    {
        return weWorkStart;
    }
    
    public final Time getWeWorkEnd()
    {
        return weWorkEnd;
    }
    
    public final Time getThWorkStart()
    {
        return thWorkStart;
    }
    
    public final Time getThWorkEnd()
    {
        return thWorkEnd;
    }
    
    public final Time getFrWorkStart()
    {
        return frWorkStart;
    }
    
    public final Time getFrWorkEnd()
    {
        return frWorkEnd;
    }
    
    public final Time getSaWorkStart()
    {
        return saWorkStart;
    }
    
    public final Time getSaWorkEnd()
    {
        return saWorkEnd;
    }
    
    public final Time getSuWorkStart()
    {
        return suWorkStart;
    }
    
    public final Time getSuWorkEnd()
    {
        return suWorkEnd;
    }
    
    public final Date getRegistrationTerm()
    {
        return registrationTerm;
    }
    
    public final int getMaxVisits()
    {
        return maxVisits;
    }
    
    public final Doctor getDoctor()
    {
        return doctor;
    }
    
    public final void setConfigurationID(int configurationID)
    {
        this.configurationID=configurationID;
    }
    
    public final void setMoWorkStart(Time time)
    {
        this.moWorkStart=time;
    }
    
    public final void setMoWorkEnd(Time time)
    {
        this.moWorkEnd=time;
    }
    
    public final void setTuWorkStart(Time time)
    {
        this.tuWorkStart=time;
    }
    
    public final void setTuWorkEnd(Time time)
    {
        this.tuWorkEnd=time;
    }
    
    public final void setWeWorkStart(Time time)
    {
        this.weWorkStart=time;
    }
    
    public final void setWeWorkEnd(Time time)
    {
        this.weWorkEnd=time;
    }
    
    public final void setThWorkStart(Time time)
    {
        this.thWorkStart=time;
    }
    
    public final void setThWorkEnd(Time time)
    {
        this.thWorkEnd=time;
    }
    
    public final void setFrWorkStart(Time time)
    {
        this.frWorkStart=time;
    }
    
    public final void setFrWorkEnd(Time time)
    {
        this.frWorkEnd=time;
    }
    
    public final void setSaWorkStart(Time time)
    {
        this.saWorkStart=time;
    }
    
    public final void setSaWorkEnd(Time time)
    {
        this.saWorkEnd=time;
    }
    
    public final void setSuWorkStart(Time time)
    {
        this.suWorkStart=time;
    }
    
    public final void setSuWorkEnd(Time time)
    {
        this.suWorkEnd=time;
    }
    
    public final void setRegistrationTerm(Date date)
    {
        this.registrationTerm=date;
    }
    
    public final void setMaxVisits(int maxVisits)
    {
        this.maxVisits=maxVisits;
    }
    
    public final void setDoctor(Doctor doctor)
    {
        this.doctor=doctor;
    }
    
    public final void setDefaultValues()
    {
        this.moWorkStart = java.sql.Time.valueOf("10:00:00");
        this.moWorkEnd = java.sql.Time.valueOf("16:00:00");
        this.tuWorkStart = java.sql.Time.valueOf("10:00:00");
        this.tuWorkEnd = java.sql.Time.valueOf("16:00:00");
        this.weWorkStart = java.sql.Time.valueOf("10:00:00");
        this.weWorkEnd = java.sql.Time.valueOf("16:00:00");
        this.thWorkStart = java.sql.Time.valueOf("10:00:00");
        this.thWorkEnd = java.sql.Time.valueOf("16:00:00");
        this.frWorkStart = java.sql.Time.valueOf("10:00:00");
        this.frWorkEnd = java.sql.Time.valueOf("16:00:00");
        this.saWorkStart = java.sql.Time.valueOf("10:00:00");
        this.saWorkEnd = java.sql.Time.valueOf("15:00:00");
        this.suWorkStart = java.sql.Time.valueOf("00:00:00");
        this.suWorkEnd = java.sql.Time.valueOf("00:00:00");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 90);
        this.registrationTerm = new java.sql.Date(calendar.getTime().getTime());
        this.maxVisits = 10;
    }
}


