package com.springcore.lesson1.IOC;

import java.util.Date;
import java.util.Random;

public class Hello {

	int randomNumber = new Random().nextInt(1000);
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Hello "+ new Date() + "randomNuber="+ randomNumber;
	}
}
