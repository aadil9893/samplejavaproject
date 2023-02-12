package com.coachingclass.AadilClasses.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coachingclass.AadilClasses.Service.TeacherService;
import com.coachingclass.AadilClasses.model.Teacher;
import com.coachingclass.AadilClasses.repository.TeacherRepo;

@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:4200")
@RestController
@RequestMapping("/coachingClass")
public class TeacherController {
	
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private TeacherRepo teacherRepo;
	
	@PostMapping("/Teacherdata")
	public Teacher registerTeacher(@RequestBody Teacher teacher) {
		return teacherService.registerTeacher(teacher);
	}
	@GetMapping(path="/Teacherdata")
	public List<Teacher>getTeacher(){
		return teacherService.getTeacher();
	}
	
	@GetMapping("/Teacher/{id}")
	public ResponseEntity<Teacher> getTeacherById(@PathVariable Integer id){
		Teacher getTeach = teacherRepo.findById(id);
		return ResponseEntity.ok().body(getTeach);
	}
	
	@PutMapping("/Teacher/{id}")
	public ResponseEntity<Teacher> updateTeacherById(@PathVariable Integer id, @RequestBody Teacher teacher){
		Teacher getTeach = teacherRepo.findById(id);
		getTeach.setName(teacher.getName());
		getTeach.setCode(teacher.getCode());
		getTeach.setEmail(teacher.getEmail());
		getTeach.setPassword(teacher.getPassword());
		
		Teacher updateTeach = teacherRepo.save(getTeach);
		return ResponseEntity.ok().body(updateTeach);
	}
	
	
	@DeleteMapping("/Teacher/{id}")
	public String deleteTeacherById(@PathVariable Integer id){
		Teacher getTeach = teacherRepo.findById(id);
		teacherRepo.delete(getTeach);
		return "Record successfully deleted";
	}
}
