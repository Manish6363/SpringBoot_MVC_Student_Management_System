package com.example.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Component
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable = false)
	private String name;
	@Column(unique = true, nullable = false)
	private String reg;
	@Column(unique = true, nullable = false)
	private String email;
	@Column(unique = true, nullable = false)
	private long phone;
	@Column(nullable = false)
	private String password;
	@Lob
	private byte[] image;
	public Student(String name, String reg, String email, long phone, String password, byte[] image) {
		super();
		this.name = name;
		this.reg = reg;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.image = image;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", reg=" + reg + ", email=" + email + ", phone=" + phone
				+ ", password=" + password + "]";
	}
	
}
