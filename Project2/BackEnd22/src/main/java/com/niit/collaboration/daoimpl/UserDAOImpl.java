package com.niit.collaboration.daoimpl;

import java.beans.Expression;
import java.util.List;

import javax.management.Query;
import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.model.User;

@Transactional
@ComponentScan("com.niit.collaboration.daoimpl")
@Component
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	
	// save user
	public User save(User user) {
		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			user.setUserRole("User Role");
			user.setUserEnabled(0);
			session.save(user);
			tx.commit();
			
			session.flush();
			session.close();

		}

		catch (Exception e) {
			System.out.println("exception occured******");
			e.printStackTrace();

		}
		return user;

	}
	
	
	// validate the User
		public boolean validate(String userEmail, String userpassword) {
		
			System.out.println(" Validate User_Eemail and password  begin ");
			boolean flag =false;
					
			
			try
			{
				String hql = " from User where userEmail = '"+userEmail+"' and userpassword = '"+userpassword+"'";
			
			
			Session session = sessionFactory.openSession();
			
			User user = (User)  session.createQuery(hql).uniqueResult();
			
			
			  
			session.close();
			
			
			if (user == null)
			{
				System.out.println(" INValid user  ");
				flag =false;
			}
			else
			{
			
				System.out.println(" Valid user  ");
				flag =true;
			}
			
			}
			catch(Exception e)
			{
				System.out.println(" Error in User Validation "+ e);
				
				flag =false;
			}
			
			return flag;
		}
		


	// GetUserById
	public List<User> getAllUser() {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			List <User> user = (List) session.get("from  " , User.class);
			tx.commit();
			session.flush();
			session.close();
			return user;

		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	// GetUserByName
	public User getUser(String userEmail) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			String hql = "from User where userEmail ='" + userEmail + "'";

			User user = (User) session.createQuery(hql).uniqueResult();
			user.show(user);
			
			
			tx.commit();
			session.flush();
			session.close();
			return user;

			
		}

		catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}



	// upadating the user
	public boolean update(User user) {
		try {
			
			System.out.println(" user update process begin ");
			
			
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.update(user);
			tx.commit();
			session.flush();
			session.close();
			System.out.println(" user update process Done ");
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(User user) {

try {
			
			System.out.println(" user delete process begin ");
			
			
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.delete(user);
			tx.commit();
			session.flush();
			session.close();
			System.out.println(" user delete process Done ");
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	

}
