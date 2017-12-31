package prs.dto;

import java.sql.Date;
import java.sql.Time;

import prs.entity.Configuration;


public class ConfigurationDTO {
	private int configurationID;
    private Time moWorkStart;
    private Time moWorkEnd;
    private Time tuWorkStart;
    private Time tuWorkEnd;
    private Time weWorkStart;
    private Time weWorkEnd;
    private Time thWorkStart;
    private Time thWorkEnd;
    private Time frWorkStart;
    private Time frWorkEnd;
    private Time saWorkStart;
    private Time saWorkEnd;
    private Time suWorkStart;
    private Time suWorkEnd;
    private Date registrationTerm;
    private int maxVisits;
    
    public ConfigurationDTO (Configuration configuration){
        this.configurationID = configuration.getConfigurationID();
        this.moWorkStart = configuration.getMoWorkStart();
        this.moWorkEnd = configuration.getMoWorkEnd();
        this.tuWorkStart = configuration.getTuWorkStart();
        this.tuWorkEnd = configuration.getTuWorkEnd();
        this.weWorkStart = configuration.getWeWorkStart();
        this.weWorkEnd = configuration.getWeWorkEnd();
        this.thWorkStart = configuration.getThWorkStart();
        this.thWorkEnd = configuration.getThWorkEnd();
        this.frWorkStart = configuration.getFrWorkStart();
        this.frWorkEnd = configuration.getFrWorkEnd();
        this.saWorkStart = configuration.getSaWorkStart();
        this.saWorkEnd = configuration.getSaWorkEnd();
        this.suWorkStart = configuration.getSuWorkStart();
        this.suWorkEnd = configuration.getSuWorkEnd();
        this.registrationTerm = configuration.getRegistrationTerm();
        this.maxVisits = configuration.getMaxVisits();
    }
    
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
}


