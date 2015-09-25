package com.testcases;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	Test07_Error.class, 
	Test08_BeforeAfter.class, 
	Test09_DataBase.class,	
	Test10_Csv.class, 
	TestJunit.class 
	})

public class TestMySuite {

}
