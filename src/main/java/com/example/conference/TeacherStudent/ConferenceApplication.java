package com.example.conference.TeacherStudent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ConferenceApplication {

	public static void main(String[] args) {
		String url = "jdbc:h2:/data/sample;IFEXISTS=TRUE";

		System.out.println("***************************************************************************");
		System.out.println("                                                                ");
		System.out.println("***************************************************************************");
		System.out.println("                                                                ");
		System.out.println("                                                                ");
		System.out.println("                                                                ");
		System.out.println("                                                                  ");
		System.out.println(url);
		SpringApplication.run(ConferenceApplication.class, args);
	}

}
