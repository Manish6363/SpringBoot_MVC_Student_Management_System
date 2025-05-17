package com.example.controller;

import java.io.IOException;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.entity.Student;
import com.example.service.StudentService;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;

	@GetMapping("/")
	public String indexPage() {
		return "index"; // index.jsp
	}

	@GetMapping("/registerPage")
	public String registerPage(Model model) {
		model.addAttribute("student", new Student());
		return "registerPage"; // registerPage.jsp
	}

	@GetMapping("/loginPage")
	public String loginPage(Model model) {
		model.addAttribute("student", new Student());
		return "loginPage"; // loginPage.jsp
	}

	@PostMapping("/register")
	public String register(@RequestParam("name") String name, @RequestParam("reg") String reg,
			@RequestParam("email") String email, @RequestParam("phone") long phone,
			@RequestParam("password") String password, @RequestParam("image") MultipartFile imageFile) {
		try {
			byte[] imageBytes = imageFile.isEmpty() ? null : imageFile.getBytes();
			Encoder encode = Base64.getEncoder();
			String pass = encode.encodeToString(password.getBytes());
			Student student = new Student(name, reg, email, phone, pass, imageBytes);
			service.setData(student);
			return "loginPage";
		} catch (IOException e) {
			e.printStackTrace();
			return "registerPage";
		}
	}

	@PostMapping("/login")
	public ModelAndView login(@RequestParam("reg") String reg, @RequestParam("password") String password,
			HttpSession session) {
		Student stu = service.getStudent(reg, password);
		if (stu != null) {
			session.setAttribute("reg", reg);
			ModelAndView m = new ModelAndView("login_dashboard");
			m.addObject("student", stu);
			List<Student> list = service.getAllStudents();
			m.addObject("list", list);
			return m;
		} else {
			ModelAndView m = new ModelAndView("loginPage");
			m.addObject("message", "Invalid Register Number or Password...!");
			return m;
		}
	}

	@GetMapping("/fetchImage")
	public void fetchImage(@RequestParam("reg") String reg, HttpServletResponse response) {
		try {
			byte[] imageData = service.getStudentImageByReg(reg); // should return byte[] from DB or file

			if (imageData != null) {
				response.setContentType("image/jpeg"); // or "image/png" depending on format
				ServletOutputStream sos = response.getOutputStream();
				sos.write(imageData);
				sos.flush();
				sos.close();
			} else {
				response.sendError(HttpServletResponse.SC_NOT_FOUND); // fallback if no image
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GetMapping("/updatePage")
	public String logout(Model model, HttpSession session) {
		model.addAttribute("student", new Student());
		String reg = (String) session.getAttribute("reg");
		Student stu = service.getStudentByReg(reg);
		model.addAttribute("stu", stu);
		return "updatePage";
	}

	@PostMapping("/update")
	public String update(@RequestParam("name") String name, @RequestParam("reg") String reg,
			@RequestParam("email") String email, @RequestParam("phone") long phone,
			@RequestParam("password") String password, @RequestParam("image") MultipartFile imageFile, Model m) {
		Student stu = service.getStudentByReg(reg);
		m.addAttribute("student", stu);
		List<Student> list = service.getAllStudents();
		m.addAttribute("list", list);
		if (!(name.isEmpty()) || name != null) {
			stu.setName(name);
		}
		if (email.isEmpty() || email == null || email.equals(stu.getEmail())) {
			stu.setEmail(stu.getEmail());
		} else {
			Student stu1 = service.getStudentByEmail(email);
			if (stu1 == null) {
				stu.setEmail(email);
			} else {
				m.addAttribute("emailMsg", "Existing or same email...!");
			}
		}
		if (phone == 0 || phone == stu.getPhone()) {
			stu.setPhone(stu.getPhone());
		} else {
			Student stu2 = service.getStudentByPhone(phone);
			if (stu2 == null) {
				stu.setPhone(phone);
			} else {
				m.addAttribute("phoneMsg", "Existing or same phone...!");
			}
		}
		try {
			stu.setImage(imageFile.isEmpty() ? stu.getImage() : imageFile.getBytes());
			System.out.println("**********************"+password+"-->"+password.isEmpty());
			System.out.println("**********************"+stu.getPassword());
			if(password.isEmpty()) {
				stu.setPassword(stu.getPassword());
			}else  {
				Encoder encode = Base64.getEncoder();
				String pass = encode.encodeToString(password.getBytes());
				stu.setPassword(pass);
			}
			System.out.println(stu);
			service.updateData(stu, reg);
			return "login_dashboard";
		} catch (IOException e) {
			e.printStackTrace();
			return "updatePage";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session, Model m) {
		session.invalidate();
		m.addAttribute("message", "Logout Successfully...!");
		return "loginPage";
	}
}
