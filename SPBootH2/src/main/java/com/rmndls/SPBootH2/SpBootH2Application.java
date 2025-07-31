package com.rmndls.SPBootH2;

import com.rmndls.SPBootH2.service.overallService;
import com.rmndls.SPBootH2.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SpBootH2Application {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = SpringApplication.run(SpBootH2Application.class, args);

		student s1  = new student();
		mathematics m1 = new mathematics();
		physics p1 = new physics();
		chemistry c1 = new chemistry();
		DBtoTxt dbtoTxt = new DBtoTxt();

		overallService service = context.getBean(overallService.class);
		Scanner sc = new Scanner(System.in);


		System.out.println("What do you want to do, today?");
		System.out.println("1. Add student");
		System.out.println("2. Print list of students");
		System.out.println("3. Print mathematics");
		System.out.println("4. Print physics");
		System.out.println("5. Print chemistry");
		System.out.println("6. Exit");
		int input = sc.nextInt();
		switch (input) {
			case 1:
				System.out.print("Enter Roll No: ");
				int rollnumber = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Full Name: ");
				String name = sc.nextLine();
				System.out.print("Enter city: ");
				String city = sc.nextLine();
				s1.setRollno(rollnumber);
				//Ignore the below statements, for link maintance between ids b/w tables
				m1.setMno(s1.getRollno());
				p1.setPno(s1.getRollno());
				c1.setCno(s1.getRollno());
				//
				s1.setFullname(name.toUpperCase());
				s1.setCity(city.toUpperCase());

				System.out.print("Enter marks in Mathematics: ");
				int mathMarks = sc.nextInt();
				System.out.print("Enter marks in Physics: ");
				int phyMarks = sc.nextInt();
				System.out.print("Enter marks in Chemistry: ");
				int chemMarks = sc.nextInt();

				m1.setMarks(mathMarks);
				p1.setMarks(phyMarks);
				c1.setMarks(chemMarks);

				service.addStudent(s1);
				service.addMathsMarks(m1);
				service.addPhysMarks(p1);
				service.addChemMarks(c1);

				String student = s1.toString();
				String mathMark = m1.toString();
				String chemMark = p1.toString();
				String phyMark = c1.toString();
				dbtoTxt.writeTxt(student, mathMark, chemMark, phyMark);
				dbtoTxt.writeDataSQL(s1, m1, p1, c1);
				break;
			case 2:
				List<student> students= service.getStudents();
				List<mathematics> mathMarkList = service.getMathMarks();
				List<physics> phyMarkList = service.getPhyMarks();
				List<chemistry> chemMarkList = service.getChemMarks();

				System.out.print("Student names : ");
				System.out.println(students);
				System.out.println("Mathematics - ");
				System.out.println(mathMarkList);
				System.out.println("Physics - ");
				System.out.println(phyMarkList);
				System.out.println("Chemistry - ");
				System.out.println(chemMarkList);
				break;
			case 3:
				System.out.println("Mathematics - ");
				List<mathematics> onlyMathMarkList = service.getMathMarks();
				System.out.println(onlyMathMarkList);
				break;
			case 4:
				System.out.println("Physics - ");
				List<physics> onlyPhyMarkList = service.getPhyMarks();
				System.out.println(onlyPhyMarkList);
				break;
			case 5:
				System.out.println("Chemistry - ");
				List<chemistry> onlyChemMarkList = service.getChemMarks();
				System.out.println(onlyChemMarkList);
				break;
			case 6:
				System.out.println("Thank you for viewing!");
				break;
			default:
				System.out.println("Invalid input");
				break;

		}
	}
}
