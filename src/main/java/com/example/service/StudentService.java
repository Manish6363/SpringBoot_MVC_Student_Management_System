package com.example.service;

import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentCrud;
import com.example.entity.Student;

@Service
public class StudentService {

	@Autowired
	private StudentCrud crud;

	public void setData(Student student) {
		crud.saveStudent(student);
	}

	public List<Student> getAllStudents() {
		return crud.findAllStudents();
	}

	public Student getStudent(String reg, String password) {
		Encoder encode = Base64.getEncoder();
		String pass = encode.encodeToString(password.getBytes());
		Student stu = crud.findStudentByReg(reg, pass);
		return stu;
	}

	public byte[] getStudentImageByReg(String reg) {
		byte[] b = crud.findStudentByReg(reg).getImage();
		return b;
	}

	public Student getStudentByReg(String reg) {
		return crud.findStudentByReg(reg);
	}

	public Student getStudentByEmail(String email) {
		return crud.findStudentByEmail(email);
	}

	public Student getStudentByPhone(long phone) {
		return crud.findStudentByPhone(phone);
	}

	public void updateData(Student stu, String reg) {
		crud.updateStudent(stu, reg);
		
	}
}
