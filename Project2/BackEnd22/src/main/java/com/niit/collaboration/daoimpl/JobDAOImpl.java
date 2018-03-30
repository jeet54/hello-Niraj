package com.niit.collaboration.daoimpl;



import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.JobDAO;
import com.niit.collaboration.model.Job;


@Transactional
@Repository("jobDAO")
public class JobDAOImpl implements JobDAO {

	@Autowired
	private SessionFactory sessionFactory;

	

	@SuppressWarnings("unchecked")
	public List<Job> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Job> jobs = session.createQuery("from Job").list();
		tx.commit();
		session.flush();
		session.close();
		return jobs;
	}

	public boolean save(Job job) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(job);
			tx.commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean update(Job job) {
		try {
			System.out.println("JobDao Update called***");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			//System.out.println("job=" + job.getJob().getName() + "& job =" + job.getJob().getName());


			session.update(job);
			session.getTransaction().commit();
			session.flush();
			session.close();
			System.out.println("JobDao Update finishd***");
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Job job) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.clear();
			session.delete(job);
			session.getTransaction().commit();
			session.flush();
			session.close();
			return true;
		}

		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

	}

	public Job getJobByID(int id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// Job job = (Job) session.createQuery("from Job where
		// id=" + id).uniqueResult();

		Job job = (Job) session.get(Job.class, id);
		tx.commit();
		session.flush();
		session.close();
		return job;

	}

	public Job getJobByTitle(String title) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Job job = (Job) session.createQuery("from Job where name='" + title + "'").uniqueResult();
		tx.commit();
		session.flush();
		session.close();
		return job;

	}

	
}
