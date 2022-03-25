package com.java.khushpreet;

import java.util.Scanner;

import com.java.khushpreet.models.Person;
import com.java.khushpreet.utils.AppUtils;

public class Main {

	public static void main(String[] args) {
         Person p = new Person();
		Scanner myObj = new Scanner(System.in);

		System.out.println("Enter name");

		// String input
		String name = myObj.nextLine();

		// Output input by user
		System.out.println("Name: " + name);

		
		//The response we are getting is in string so we need to parse it the JSON Object 
		//in order to access those properties
		String ageResponse = AppUtils.getAgeReponse(name);
		p = AppUtils.parseAgeResponse(ageResponse,p);
		
//		System.out.println(ageResponse);
		String genderResponse = AppUtils.getGenderReponse(name);
		p = AppUtils.parseGenderResponse(genderResponse,p);
//		System.out.println(genderResponse);
		
		
		System.out.println("The Age of " + name + " is " + p.getAge());

		System.out.println("The Gender of " + name + " is " + p.getGender());
		
	}
}
