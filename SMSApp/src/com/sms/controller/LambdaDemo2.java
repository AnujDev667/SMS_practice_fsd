package com.sms.controller;

public class LambdaDemo2 {
	public static void main(String[] args) {
		new MyClass().personDetails(()->{
			return "india";
		});
	}
}
interface Person{
	String country();
}
class MyClass{
	void personDetails(Person p) {
		System.out.println("This person belong to " + p.country());
	}
}
