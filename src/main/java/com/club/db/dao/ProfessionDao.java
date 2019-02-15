package com.club.db.dao;

import java.util.List;

import com.club.item.Profession;

public interface ProfessionDao {
	int add(Profession admin);
	int delete(String id);
	int update(String id,Profession admin);
	List<Profession> queryAll();
	Profession retrieve(String id);
}	
