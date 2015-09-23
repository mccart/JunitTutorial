package com.testcases;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class Test03_ResultRunner {
	
	// http://junit-team.github.io/junit/javadoc/latest/
	
	public static void main(String[] args) {
		
		Result result = JUnitCore.runClasses(Test03_ResultJunit.class);
		
		System.out.println("------------------ From Result ----------------");
	
//		if( result.wasSuccessful() ) {
			System.out.println("Run Count: " + result.getRunCount());
			System.out.println("Run Time: " + result.getRunTime() + " ms");
//		} else {
			System.out.println("Failure Count: " + result.getFailureCount());
			System.out.println("Ignore Count: " + result.getIgnoreCount());
//		}
	}
	
//	You might want to take a look at the following bundle repositories:
//
//		http://www.springsource.com/repository/app/
//		http://download.eclipse.org/tools/orbit/downloads/
//		http://www.osgi.org/Repository/HomePage
}
