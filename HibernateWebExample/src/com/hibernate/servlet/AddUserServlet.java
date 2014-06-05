package com.hibernate.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernate.entity.Users;

/**
 * Servlet implementation class AddUserServlet
 */

public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
