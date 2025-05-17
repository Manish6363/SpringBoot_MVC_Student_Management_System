package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.entity.Student;
import com.example.repository.StudentRepo;
import com.example.service.StudentService;

@Repository
public class StudentCrud {
	@Autowired
	private StudentRepo repo;

	public void saveStudent(Student stu) {
		repo.save(stu);
	}

	public void updateStudent(Student stu, String reg) {
		repo.updateStudentByReg(stu, reg);
	}

	public Student findStudentByReg(String reg, String password) {
		return repo.findByReg(reg, password);
	}

	public List<Student> findAllStudents() {
		return repo.findAll();
	}

	public Student findStudentByReg(String reg) {
		Student stu = repo.findByReg(reg);
		return stu;
	}

	public Student findStudentByEmail(String email) {
		Student stu = repo.findByEmail(email);
		return stu;
	}

	public Student findStudentByPhone(long phone) {
		Student stu = repo.findByPhone(phone);
		return stu;
	}
}
