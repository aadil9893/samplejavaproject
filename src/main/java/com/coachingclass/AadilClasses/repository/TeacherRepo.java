package com.coachingclass.AadilClasses.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coachingclass.AadilClasses.model.Teacher;

public interface TeacherRepo extends JpaRepository<Teacher, Long> {
	public List<Teacher> findAll();
	
	public Teacher findById(Integer id);
}
