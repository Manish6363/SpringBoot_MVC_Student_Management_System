package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.Student;

import jakarta.transaction.Transactional;

public interface StudentRepo extends JpaRepository<Student, Integer> {
	@Query("select s from Student s where reg=?1 and password=?2")
	public Student findByReg(String reg, String password);

	public Student findByReg(String reg);

	public Student findByEmail(String email);

	public Student findByPhone(long phone);
	
	@Modifying
	@Transactional
	@Query("UPDATE Student s SET " +
	       "s.name = :#{#stu.name}, " +
	       "s.email = :#{#stu.email}, " +
	       "s.phone = :#{#stu.phone}, " +
	       "s.password = :#{#stu.password}, " +
	       "s.image = :#{#stu.image} " +
	       "WHERE s.reg = :reg")
	public int updateStudentByReg(@Param("stu") Student stu, @Param("reg") String reg);

}
