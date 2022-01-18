package com.test;



public class TestClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent a = new Child();
		System.out.println(a.test());
		
		

	}

}
//hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh
class Parent{
	int test() throws NullPointerException
	{
		System.out.println("B");
		return 0;
	}
}

class Child extends Parent{
	int test() throws RuntimeException
	{
		try {
			System.out.println("A");
			return 6;
			
		}
		finally{
			return 7;
			
		}
		//
	}
}
