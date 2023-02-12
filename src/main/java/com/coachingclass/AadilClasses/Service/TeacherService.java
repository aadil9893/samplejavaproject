package com.coachingclass.AadilClasses.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.coachingclass.AadilClasses.model.Teacher;
import com.coachingclass.AadilClasses.repository.TeacherRepo;


@Service
public class TeacherService {
	
	
	@Autowired
	private TeacherRepo teacherRepo;
	public Teacher registerTeacher(@RequestBody Teacher teacher) {
		return teacherRepo.save(teacher);
	}
	
	public List<Teacher>getTeacher(){
		return (List<Teacher>) teacherRepo.findAll();
	}
}
