package com.club.db.dao;

import java.util.List;

import com.club.item.Comment;

public interface CommentDao {
	int add(Comment admin);
	int delete(String id);
	int update(String id,Comment admin);
	List<Comment> queryAll();
	Comment retrieve(String id);
}
