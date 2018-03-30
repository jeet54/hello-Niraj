package com.niit.collaboration.test;

import org.junit.Assert;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaboration.dao.FriendDAO;
import com.niit.collaboration.model.Friend;

public class FriendTestCase {
	@Autowired
	private static AnnotationConfigApplicationContext context;
	@Autowired
	private static Friend friend;
	@Autowired
	private static FriendDAO friendDAO;

	@BeforeClass
	public static void initialize() {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.scan("com.niit.*");
		context.refresh();
		friend = (Friend) context.getBean("friend");

		friendDAO = (FriendDAO) context.getBean("friendDAO");

	}

	@Test
	public void createFriendTestCase() {
		friend.setId(3004);
		friend.setStatus("Online");

		boolean flag = friendDAO.save(friend);
		Assert.assertEquals("createFriendTestCase", true, flag);
	}

	@Test
	public void deleteFriendTestCase() {
		Friend friend = (Friend) friendDAO.getFriendByID(3004);
		boolean flag = friendDAO.delete(friend);
		Assert.assertEquals("delete friend test case", true, flag);
	}

	@Test
	public void updateFriendTestCase() {
		Friend friend = (Friend) friendDAO.getFriendByID(3007);
		friend.setId(3012);
		friend.setStatus("offline");

		boolean flag = friendDAO.update(friend);

		Assert.assertEquals("update friend test case", true, flag);
	}

}
