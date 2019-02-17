package com.club.db.dao;

import java.util.List;

import com.club.item.Club;

public interface ClubDao {
	int add(Club club);
	int delete(String id);
	int update(String id,Club club);
	List<Club> queryAll();
	Club retrieve(String id);
}
