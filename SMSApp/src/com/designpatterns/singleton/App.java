package com.designpatterns.singleton;

public class App {

	public static void main(String[] args) {
		
		EmailUtility.getInstance().sendMail(); //100X
	}
}
