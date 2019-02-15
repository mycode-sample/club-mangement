package com.club.db.dao;

import java.util.List;

import com.club.item.Reply;

public interface ReplyDao {
	int add(Reply admin);
	int delete(String id);
	int update(String id,Reply admin);
	List<Reply> queryAll();
	Reply retrieve(String id);
}
