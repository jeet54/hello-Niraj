package com.niit;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.niit.config.*;
public class MyMain {

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
        System.out.println(" NIIT    1234 dfff 222   7777  wwww");
        
                
        AppplicationContextConfig obj = new AppplicationContextConfig();
        SessionFactory sessionFactory=obj.getSessionFactory( obj.getDataSource());
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        tx.commit();
        session.close();
        
        
        
        //obj.getTransactionManager(obj.getSessionFactory( obj.getDataSource()));


		
	}

}
