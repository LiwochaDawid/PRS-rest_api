/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prs.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import prs.entity.Configuration;
import prs.entity.Doctor;

@Repository
public class ConfigurationDAO {
    @PersistenceContext	
    private EntityManager entityManager;
    
    @SuppressWarnings("unchecked")
	public Configuration getConfigurationByID(int id){
        String hql = "FROM Configuration as configurations WHERE configurations.configurationID = ?";
        List<Configuration> configurations = entityManager.createQuery(hql)
				.setParameter(1, id).getResultList();
		return configurations.get(0);
    }
    
    @SuppressWarnings("unchecked")
	public Configuration getDoctorConfiguration(int id){
        String hql = "FROM Configuration as configurations WHERE configurations.doctor.doctorID = ?";
        List<Configuration> configurations = entityManager.createQuery(hql)
				.setParameter(1, id).getResultList();
		return configurations.get(0);
    }
    
    @SuppressWarnings("unchecked")
	public Configuration getDoctorConfiguration(String name){
        String hql = "FROM Configuration as configurations WHERE configurations.doctor.account.username = ?";
        List<Configuration> configurations = entityManager.createQuery(hql)
				.setParameter(1, name).getResultList();
		return configurations.get(0);
    }
	
	public void addConfiguration(Configuration configuration) {
		entityManager.persist(configuration);
	}
	
	public void updateConfiguration(Configuration newConfiguration) {
		Configuration configuration = getConfigurationByID(newConfiguration.getConfigurationID());
		configuration.setMoWorkStart(newConfiguration.getMoWorkStart());
		configuration.setMoWorkEnd(newConfiguration.getMoWorkEnd());
		configuration.setTuWorkStart(newConfiguration.getTuWorkStart());
		configuration.setTuWorkEnd(newConfiguration.getTuWorkEnd());
		configuration.setWeWorkStart(newConfiguration.getWeWorkStart());
		configuration.setWeWorkEnd(newConfiguration.getWeWorkEnd());
		configuration.setThWorkStart(newConfiguration.getThWorkStart());
		configuration.setThWorkEnd(newConfiguration.getThWorkEnd());
		configuration.setFrWorkStart(newConfiguration.getFrWorkStart());
		configuration.setFrWorkEnd(newConfiguration.getFrWorkEnd());
		configuration.setSaWorkStart(newConfiguration.getSaWorkStart());
		configuration.setSaWorkEnd(newConfiguration.getSaWorkEnd());
		configuration.setSuWorkStart(newConfiguration.getSuWorkStart());
		configuration.setSuWorkEnd(newConfiguration.getSuWorkEnd());
		configuration.setRegistrationTerm(newConfiguration.getRegistrationTerm());
		configuration.setMaxVisits(newConfiguration.getMaxVisits());
		entityManager.flush();
	}
}