package com.niit.collaboration.dao;

import java.util.List;

import com.niit.collaboration.model.Friend;

public interface FriendDAO {
	public List<Friend> list();

	public boolean save(Friend friend);

	public boolean update(Friend friend);

	public boolean delete(Friend friend);

	public Friend getFriendByID(int id);

	public Friend getFriendByName(String name);

}
