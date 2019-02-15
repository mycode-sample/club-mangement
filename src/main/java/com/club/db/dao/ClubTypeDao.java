package com.club.db.dao;

import java.util.List;

import com.club.item.ClubType;

public interface ClubTypeDao {
	int add(ClubType admin);
	int delete(String id);
	int update(String id,ClubType admin);
	List<ClubType> queryAll();
	ClubType retrieve(String id);
}
