package com.niit.collaboration.daoimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;

@Transactional
@Repository("friendDAO")
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Friend> list() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		List<Friend> friends = session.createQuery("from Friend").list();
		tx.commit();
		session.flush();
		session.close();
		return friends;
	}

	public boolean save(Friend friend) {

		try {
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(friend);
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

	public boolean update(Friend friend) {
		try {
			System.out.println("FriendDao Update called***");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			// System.out.println("friend=" + friend.getFriend().getName() + "&
			// friend =" + friend.getFriend().getName());

			session.update(friend);
			session.getTransaction().commit();
			session.flush();
			session.close();
			System.out.println("FriendDao Update finishd***");
			return true;
		}

		catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Friend friend) {

		try {
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.clear();
			session.delete(friend);
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

	public Friend getFriendByID(int id) {

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		// Friend friend = (Friend) session.createQuery("from Friend where
		// id=" + id).uniqueResult();

		Friend friend = (Friend) session.get(Friend.class, id);
		tx.commit();
		session.flush();
		session.close();
		return friend;

	}

	public Friend getFriendByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Friend friend = (Friend) session.createQuery("from Friend where name='" + name + "'").uniqueResult();
		tx.commit();
		session.flush();
		session.close();
		return friend;

	}

}
