package com.club.db.dao;

import java.util.List;

import com.club.item.Activity;

public interface ActivityDao {
	int add(Activity admin);
	int delete(String id);
	int update(String id,Activity admin);
	List<Activity> queryAll();
	Activity retrieve(String id);
}
