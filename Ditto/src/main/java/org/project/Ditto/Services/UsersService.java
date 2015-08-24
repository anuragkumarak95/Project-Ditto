package org.project.Ditto.Services;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.project.Ditto.Models.Dto_Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UsersService {
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public Dto_Users createUser(String name,String u_name,String u_pass) {
		
		Dto_Users user = new Dto_Users();
		user.setName(name);
		user.setU_name(u_name);
		user.setU_pass(u_pass);
		this.sessionFactory.getCurrentSession().save(user);
		return user;
	}
	
	@Transactional
	public boolean searchUser(String u_name,String u_pass) {
		Dto_Users user = (Dto_Users)this.sessionFactory.getCurrentSession().createCriteria(Dto_Users.class)
				.add(Restrictions.eq("u_name", u_name)).add(Restrictions.eq("u_pass",u_pass)).uniqueResult();
		
		if(user != null) {
			System.err.println(user.getName()+" :: "+user.getU_name());
			return true;
		}
		else {
			return false;
		}
		
	}
	
	@Transactional
	public Dto_Users getUser(String u_name,String u_pass) {
		List<Dto_Users> userlist = (List<Dto_Users>) this.sessionFactory.getCurrentSession().createCriteria(Dto_Users.class).list();
		
		for(Dto_Users user : userlist) {
			if(user.getU_name().equals(u_name)&&user.getU_pass().equals(u_pass)) {
				System.err.println("got the user");
				return user;
			}
		}
		return null;
		
	}
	
	@Transactional
	public Dto_Users getUserById(String u_id) {
		System.out.println(u_id);
		return (Dto_Users)this.sessionFactory.getCurrentSession().get(Dto_Users.class, u_id);
	}
	
}
