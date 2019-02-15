package com.club.db.dao;

import java.util.List;

import com.club.item.Administrator;

public interface AdministratorDao {
	int add(Administrator admin);
	int delete(String id);
	int update(String id,Administrator admin);
	List<Administrator> queryAll();
	Administrator retrieve(String id);
}