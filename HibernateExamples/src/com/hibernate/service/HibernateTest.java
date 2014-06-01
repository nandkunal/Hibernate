package com.hibernate.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.hibernate.entity.Users;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Users user=new Users();
		user.setFirstName("Test");
		user.setLastName("User123");
		user.setEmailId("nandkunal@gmail.com");
		user.setPassword("password");
		//Create Session Factory
		Configuration configuration=new Configuration().configure();
		SessionFactory sessionFactory=configuration.buildSessionFactory();
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		 session.getTransaction().commit();
		session.close();
		
		System.out.println("Object saved in DB");
		user=null;
		 session=sessionFactory.openSession();
		session.beginTransaction();
		user=(Users)session.get(Users.class, 1);
		
		System.out.println("Users"+user);
		session.close();
	
		

	}

}
