package com.designpatterns.singleton;

public class Demo {
	//frodo
		public static void main(String[] args) {
			EmailUtility.getInstance().sendMail();
			EmailUtilityAzure.getInstance().sendMail();
		}

}
