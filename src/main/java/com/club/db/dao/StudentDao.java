package com.club.db.dao;

import java.util.List;

import com.club.item.Student;

public interface StudentDao {
	int add(Student admin);
	int delete(String id);
	int update(String id,Student admin);
	List<Student> queryAll();
	Student retrieve(String id);
}
