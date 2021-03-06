package com.testcases;

import java.util.List;

import org.junit.runner.Description;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	
	public static void main(String[] args) {
		
		JUnitCore unit = new JUnitCore();
		unit.addListener(new CustomeListener());
		Result result = unit.run(
				Test10_Csv.class,
				Test07_Error.class,
				TestJunit.class,
				Test08_BeforeAfter.class,
				Test09_DataBase.class);
		
//		Result result = JUnitCore.runClasses(TestJunit.class);
//		Description obj = Description.createSuiteDescription(TestJunit.class);
		System.out.println("\n================From Result===============");
		//if(result.wasSuccessful()){
			System.out.println("Run Count : " + result.getRunCount());
			System.out.println("Run Time : " + result.getRunTime());
			
	//	}else{
			System.out.println("Failure Count : " + result.getFailureCount());
			System.out.println("Ignore Count : " + result.getIgnoreCount());
		//}
		List<Failure> fail = result.getFailures();
		for(Failure f : fail){
			Description d = f.getDescription();
			System.out.println("Class Name : " + d.getClassName());
			System.out.println("Display Name : " + d.getDisplayName());
			System.out.println("Method Name : " + d.getMethodName());
			System.out.println("Exception Message : " + f.getMessage());
			System.out.println("Stack Trace : " + f.getTrace());
			System.out.println("Test Header : " + f.getTestHeader());
			System.out.println("===================+++++++++++++++++================");	
		}

	}

}
