package com.sms.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.sms.dto.StudentDto;
import com.sms.model.Address;
import com.sms.model.Student;
import com.sms.model.User;
import com.sms.repository.StudentRepository;
import com.sms.utility.DbConnection;
public class StudentService {

	private Scanner sc;
	private StudentRepository studentRepository = new StudentRepository(); 

	public StudentService(Scanner sc) {
		 this.sc = sc; 
	}

	public Student takeInput() {
		System.out.println("Enter name");
		sc.nextLine();
		String name = sc.nextLine();
		System.out.println("Enter contact");
		String contact = sc.nextLine();
		System.out.println("---Enter User Info------");
		System.out.println("Enter Username:");
		String username = sc.nextLine();
		System.out.println("Enter Password:");
		String password = sc.nextLine();
		System.out.println("---Enter Address Info------");
		System.out.println("Enter City: ");
		String city = sc.nextLine();
		System.out.println("Enter State: ");
		String state = sc.nextLine();

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setRole("STUDENT");

		Address address = new Address(city,state);

		Student student = new Student(); 
		student.setName(name);
		student.setContact(contact);
		student.setUser(user);
		student.setAddress(address);

		return student;
	}

	public void insert(Student student) throws SQLException {
        Connection conn = null;
        try {
            conn = DbConnection.dbConnect();
            // Insert address first
            studentRepository.insertAddress(student.getAddress(), conn);

            // Create a unique student ID
            int studentId = (int) (Math.random() * 100000000);
            student.setId(studentId);

            // Insert student record
            studentRepository.insertStudent(student, conn);
            System.out.println("Student along with User and Address details added to DB");
        } finally {
            DbConnection.dbClose();
        }
	}
	public List<StudentDto> getAllStudentsInfo(){
		List<StudentDto> list = studentRepository.getAllStudentsInfo();
		List<String> listRural = Arrays.asList(new String[] {"sinuiseri","sydney"});
		List<String> listMetro = Arrays.asList(new String[] {"lahore","karachi"});
		list.stream().forEach(obj->{
			if(listRural.contains(obj.getCity()))
				obj.setCityStatus("RURAL");
			else
				if(listMetro.contains(obj.getCity()))
					obj.setCityStatus("METRO");
				else
				obj.setCityStatus("UNKNOWN");
		});
		return list;
	}
	public List<StudentDto> filterByCity(List<StudentDto> list,String city){
		List<StudentDto> filteredList = list.stream()
				.filter(s->s.getCity().equalsIgnoreCase(city))
				.toList();
		return filteredList;
	}
	public List<StudentDto> searchByNameOrUsername(List<StudentDto> list, String searchStr){
		return list.stream()
				.filter(s->{if(s.getUsername().equals(searchStr))
					return true;
				else {
					String[] arry = s.getName().split(" ");  // [fryday] [samuel carlos]
					List<String> listTemp = Arrays.asList(arry);
					return listTemp.contains(searchStr);
				}
				
				})
				.toList();
	}

}