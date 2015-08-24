package org.project.Ditto.Services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.project.Ditto.Models.Deeds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
public class DeedService {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Deeds getDeedByID(int d_id) {
		return (Deeds)this.sessionFactory.getCurrentSession().get(Deeds.class, d_id);
	} 
	
	@Transactional
	public Deeds createDeed(String d_deed,int d_user_id) {
		Deeds deed = new Deeds();
		deed.setD_deed(d_deed);
		deed.setD_user_id(d_user_id);
		this.sessionFactory.getCurrentSession().save(deed);
		
		return deed;
	}
	
	@Transactional
	public void linkDeed(int d_id,int d_user_id) {
		Deeds deed = getDeedByID(d_id);
		deed.setD_user_id(d_user_id);
		this.sessionFactory.getCurrentSession().update(deed);
	}
	
	@Transactional
	public void incDitto(Deeds deed) {
		deed.setD_ditto_count(deed.getD_ditto_count()+1);
		this.sessionFactory.getCurrentSession().update(deed);
	}
	
	@Transactional
	public void decDitto(Deeds deed) {
		deed.setD_ditto_count(deed.getD_ditto_count()-1);
		this.sessionFactory.getCurrentSession().update(deed);
	}
		
	@Transactional
	public void deleteDeed(Deeds deed) {
		this.sessionFactory.getCurrentSession().delete(deed);
	}
	
	@Transactional
	public void editDeed(int d_id,String d_deed) {
		Deeds deed = (Deeds) this.sessionFactory.getCurrentSession().get(Deeds.class, d_id);
		System.err.println(deed.getD_deed());
		deed.setD_deed(d_deed);
		this.sessionFactory.getCurrentSession().update(deed);
	}
	
	@Transactional
	public List<Deeds> getAllDeeds(){
		
		return this.sessionFactory.getCurrentSession().createCriteria(Deeds.class).list();
	}

	@Transactional
	public Deeds createDeed(String d_deed) {
		Deeds deed = new Deeds();
		deed.setD_deed(d_deed);
		this.sessionFactory.getCurrentSession().save(deed);
		
		return deed;
	}
}
