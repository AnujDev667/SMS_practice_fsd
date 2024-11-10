package com.sms.controller;

import java.util.List;
import java.util.Scanner;
import com.sms.dto.StudentDto;
import com.enums.RoleType;
import com.sms.model.Student;
import com.sms.service.StudentService;

public class StudentController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StudentService studentService = new StudentService(sc);
		while(true) {
			System.out.println("======Student Module ==========");
			System.out.println("1. Add Student");
			System.out.println("2. Fetch Student Info");
			System.out.println("3. Filter Student records by city");
			System.out.println("4. Search student by Username and name");
			System.out.println("5. Display all Roles");
			System.out.println("0. To Exit");
			System.out.println("================================");
			int input = sc.nextInt();
			if(input == 0) {
				System.out.println("Exiting -- Thanks");
				break;
			}
			switch (input) {
            case 1:
                Student student = studentService.takeInput();
                // We have to validate fields and then insert
                try {
                    studentService.insert(student);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
                break; 
			case 2: 
				List<StudentDto> list =  studentService.getAllStudentsInfo();
				list.stream().forEach(e-> System.out.println(e));
				break;
			case 3:
				list = studentService.getAllStudentsInfo();
				System.out.println("Enter city to filter");
				String city = sc.next();
				List<StudentDto> filteredList = studentService.filterByCity(list, city);
				System.out.println("All students belonging to city:"+city);
				System.out.println("###############################################################");
				filteredList.stream().forEach(e-> System.out.println(e));
				System.out.println("###############################################################");
				break;
			case 4:
				list = studentService.getAllStudentsInfo();
				System.out.println("Enter the name/username to filter");
				String searchStr = sc.next();
				filteredList = studentService.searchByNameOrUsername(list,searchStr);
				System.out.println("###############################################################");
				filteredList.stream().forEach(e-> System.out.println(e));
				System.out.println("###############################################################");
				break;
			case 5:
				System.out.println("=========ALL Roles========");
				for(RoleType role : RoleType.values()) {
					System.out.println(role);
				}
				System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
				break;
				
			default: 
				System.out.println("Invald Input, try again");
				break; 
			}
		}
		sc.close();
	}
}

