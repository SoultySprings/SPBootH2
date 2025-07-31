package com.rmndls.SPBootH2;

import com.rmndls.SPBootH2.service.overallService;
import com.rmndls.SPBootH2.model.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpBootH2Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpBootH2Application.class, args);

		student s1  = new student();
		mathematics m1 = new mathematics();
		physics p1 = new physics();
		chemistry c1 = new chemistry();


		s1.setRollno(26);
		s1.setFullname("Anand Rao");
		s1.setCity("Pune");
		m1.setMno(26);
		m1.setMarks(87);
		p1.setPno(26);
		p1.setMarks(90);
		c1.setCno(26);
		c1.setMarks(90);


		overallService service = context.getBean(overallService.class);


		service.addStudent(s1);
		service.mathsMarks(m1);
		service.physMarks(p1);
		service.chemMarks(c1);



		List<student> students= service.getStudents();
		List<mathematics> mathMarks= service.getMathMarks();
		List<physics> phyMarks= service.getPhyMarks();
		List<chemistry> chemMarks= service.getChemMarks();

		System.out.println(students);
		System.out.println(mathMarks);
		System.out.println(phyMarks);
		System.out.println(chemMarks);
	}

}
