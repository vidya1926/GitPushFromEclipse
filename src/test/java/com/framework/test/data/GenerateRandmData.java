package com.framework.test.data;

import com.github.javafaker.Faker;


public class GenerateRandmData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Faker fake = new Faker();
		String firstName = fake.name().firstName();
		System.out.println("FirstName ----"+firstName);
		String emailAddress = fake.internet().emailAddress();
		System.out.println("Email Address ----"+emailAddress);
		String cellNumber = fake.phoneNumber().cellPhone().toString();
		System.out.println("Cell Number ----"+cellNumber);
	}

}
