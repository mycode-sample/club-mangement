package com.club.db.dao;

import java.util.List;

import com.club.item.Department;

public interface DepartmentDao {
	int add(Department admin);
	int delete(String id);
	int update(String id,Department admin);
	List<Department> queryAll();
	Department retrieve(String id);
}
