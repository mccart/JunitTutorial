package com.testcases;
import org.junit.Test;
//import org.junit.runner.JUnitCore;

public class Test01_CoreJunit {

	@Test
	public void testCaseOne() {
		// only public void will be executed
		System.out.println("Test Case One");
//		fail("Not yet implemented");
	}
	@Test
	public void testCaseTwo() {
		// only public void will be executed
		System.out.println("Test Case Two");
//		fail("Not yet implemented");
	}
	@Test
	public void testCaseThree() {
		// only public void will be executed
		System.out.println("Test Case Three");
//		fail("Not yet implemented");
	}

//	moved to runner...
//	public static void main(String[] args) {
//		JUnitCore.runClasses(Test01_CoreJunit.class);
//	}
	
}
