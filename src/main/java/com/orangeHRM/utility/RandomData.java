package com.orangeHRM.utility;

import java.util.Random;

import com.github.javafaker.Faker;
public class RandomData {
	Faker faker;
	Random rnd;
	public RandomData() {
		faker = new Faker();
		rnd = new Random();
	}
	public String getFirstName() {
		return faker.name().firstName();
	}
	public String getLastName() {
		return faker.name().lastName();
	}
	public int getRandomNumber(int size) {
		int randomNumber = rnd.nextInt(size);
		if(randomNumber==0) {
			return 1;
		}
		else {
			return randomNumber;
		}
	}
}
