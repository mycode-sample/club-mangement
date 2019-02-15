package com.club.db.dao;

import java.util.List;

import com.club.item.Club;

public interface ClubDao {
	int add(Club admin);
	int delete(String id);
	int update(String id,Club admin);
	List<Club> queryAll();
	Club retrieve(String id);
}
