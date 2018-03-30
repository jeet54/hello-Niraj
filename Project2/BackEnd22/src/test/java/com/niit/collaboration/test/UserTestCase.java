package com.niit.collaboration.test;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.UserDAO;
import com.niit.collaboration.daoimpl.UserDAOImpl;
import com.niit.collaboration.model.User;

public class UserTestCase {

	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static User user;
	@Autowired
	private static UserDAO userDAO;

	@BeforeClass
	public static void initialize() {

		try
		{
		System.out.println("  Start  ");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		
		context.scan("com.niit.*");
		
		
			
		context.refresh();
		
		
		user = (User) context.getBean(User.class);
		
		
		System.out.println(user);
		

		userDAO = (UserDAO) context.getBean(UserDAO.class);
		
		System.out.println(userDAO);
		System.out.println("No Error ");
		
		
		}
		catch(Exception e)
		{
			System.out.println(" Error in Testing " + e);
		}
	}

	
	  @Test public void createUserTestCase() { 
		  
		  try
		  {
		  
		  user.setUserEmail("babita111@niit.com");
	      user.setUserPassword("admin");
	      user.setUserName("babita");
	      user.setUserContact("9650403954");
	      user.setUserAddress("Niit Pitampura New Delhi 1111111111");
	      
	  	  user.setUserRole("ROLE_ADMIN");
	  	  user.setUserEnabled(0);
	  	  user.setUserLoginStatus("Y");
	  	  
	      User flag = userDAO.save(user);
	  
	      System.out.println(" Data Inserted to the table " );
	      Assert.assertNotEquals("createUserTestCase", null, flag);
	  
		  }
		  catch(Exception e)
		  {
			  
			  System.out.println(" Error in Isner USer "+ e);
			  
		  }
	  
	  }
	 
	  @Ignore
	  @Test
		public void validateCredentialsTestCase() { 
		  
		    
		  
			boolean flag=userDAO.validate("niraj_niraj@niit.com", "admin");
		  assertEquals("ValidateCredentialsTestCase",true,flag);
		  
		  }
	  
	  @Ignore
	  @Test 
		public void updateUserTestCase()
		{ 
		  
		  System.out.println(" ************************  ");
		  System.out.println(" user update test case  ");
		  System.out.println(" ************************  ");
			User user = (User)userDAO.getUser("niraj_niraj@niit.com");
			
			user.show(user);
			
			user.setUserName("Anu");
		    user.setUserPassword("123"); 
		    user.setUserContact("985885833"); 
		    user.setUserAddress("NIIT House , 88 Gurgaon ");
		    user.setUserRole("ROLE_ADMIN");
		    user.setUserEnabled(1);
		    
		    
		    
		 
		 boolean flag = userDAO.update(user);
		 
		 Assert.assertEquals("update user test case", true, flag);
		 
		}
	  
	  
	  @Ignore  
	@Test public void deleteUserTestCase() { 
		 System.out.println(" ************************  ");
		  System.out.println(" user delete test case  ");
		  System.out.println(" ************************  ");
		
		  
		   User user = (User)userDAO.getUser("niraj_niraj@niit.com"); 
		
		   
		boolean flag = userDAO.delete(user);
	  Assert.assertEquals("delete user test case", true, flag);
	  

		 System.out.println(" ************************  ");
		 System.out.println(" user delete test case  Done  ");
		 System.out.println(" ************************  ");
	  
	  
	}
	
	


	
	
	
	
	  

}
