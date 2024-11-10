package com.sms.controller;

public class LambdaDemo {
	public static void main(String[] args) {
		Inter i = new Inter() {

			@Override
			public void m1() {
				System.out.println("m1 from anonymous inner class");
				
			}
			
		};
		i.m1();
	}


}
interface Inter{
	void m1();
}
