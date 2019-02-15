package com.club.db.dao;

import java.util.List;

import com.club.item.Teacher;

public interface TeacherDao {
	int add(Teacher admin);
	int delete(String id);
	int update(String id,Teacher admin);
	List<Teacher> queryAll();
	Teacher retrieve(String id);
}
