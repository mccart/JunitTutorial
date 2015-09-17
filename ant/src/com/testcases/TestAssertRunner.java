package com.testcases;
import org.junit.runner.JUnitCore;

public class TestAssertRunner {
	
	// http://junit-team.github.io/junit/javadoc/latest/
	
	public static void main(String[] args) {
		JUnitCore.runClasses(TestAssertJunit.class);
	}
	
//	You might want to take a look at the following bundle repositories:
//
//		http://www.springsource.com/repository/app/
//		http://download.eclipse.org/tools/orbit/downloads/
//		http://www.osgi.org/Repository/HomePage
}
