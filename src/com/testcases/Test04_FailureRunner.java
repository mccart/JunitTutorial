package com.testcases;

import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class Test04_FailureRunner {

	// http://junit-team.github.io/junit/javadoc/latest/

	public static void main(String[] args) {

		Result result = JUnitCore.runClasses(Test04_FailureJunit.class);

		System.out.println("------------------ From Result ----------------");

		// if( result.wasSuccessful() ) {
			System.out.println("Run Count: " + result.getRunCount());
			System.out.println("Run Time: " + result.getRunTime() + " ms");
		// } else {
			System.out.println("Failure Count: " + result.getFailureCount());
			System.out.println("Ignore Count: " + result.getIgnoreCount());
		// }
		
		
		List<Failure> fail = result.getFailures();
		
		for (Failure f : fail) {
			System.out.println();
			System.out.println("Exception Message : " + f.getMessage());
			System.out.println("Stack Trace : " + f.getTrace());
			System.out.println("Test Header : " + f.getTestHeader());
			System.out.println("===================+++++++++++++++++================");
		}
	}

	// You might want to take a look at the following bundle repositories:
	//
	// http://www.springsource.com/repository/app/
	// http://download.eclipse.org/tools/orbit/downloads/
	// http://www.osgi.org/Repository/HomePage
}
