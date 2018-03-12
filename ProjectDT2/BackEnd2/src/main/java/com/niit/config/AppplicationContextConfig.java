package com.niit.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;



import com.niit.model.UserDetails;



@Configuration
@ComponentScan("com.niit")
@EnableTransactionManagement
public class AppplicationContextConfig {
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		
		
	    DriverManagerDataSource dataSource=null;
	    try
	    {
	         dataSource= new DriverManagerDataSource();
	         dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	         dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/XE");
	         dataSource.setUsername("hr");
	         dataSource.setPassword("hr");
	 
	           System.out.println("  Connection     Successfully   done ");
	    
	    }
	    catch(Exception e)
	    {
	    	System.out.println(" Connectin Error " + e);
	    }
	    return dataSource;
	}
	
	
	
	
	
	private Properties getHibernateProperties() {
	    Properties properties = new Properties();
	    properties.put("hibernate.show_sql", "true");
	    properties.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
	   properties.put("hibernate.hbm2ddl.auto", "create");
	    return properties;
	}
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	 
	 LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(dataSource);
	 sessionBuilder.addProperties(getHibernateProperties());
	 
	 sessionBuilder.addAnnotatedClasses(UserDetails.class);
	 
	 
	 System.out.println(" Table is created ");
	 
	 
	 
	 /*
	  	sessionBuilder.addAnnotatedClasses(Supplier.class);
	 	sessionBuilder.addAnnotatedClasses(Category.class);
	 	sessionBuilder.addAnnotatedClasses(UserDetails.class);
     	sessionBuilder.addAnnotatedClasses(Product.class);
     	sessionBuilder.addAnnotatedClasses(BillingAddress.class);
     	sessionBuilder.addAnnotatedClasses(ShippingAddress.class);
     	sessionBuilder.addAnnotatedClasses(Cart.class);
     	sessionBuilder.addAnnotatedClasses(CardDetail.class);
     	sessionBuilder.addAnnotatedClasses(CartItem.class);
     	sessionBuilder.addAnnotatedClasses(UserOrder.class);
     */
	 
	 
     return sessionBuilder.buildSessionFactory();
	}
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	            sessionFactory);
	return transactionManager;
	}
}
