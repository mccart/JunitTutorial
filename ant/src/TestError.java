package com.testcases;

import org.junit.Ignore;
import org.junit.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;

//@Ignore
public class TestError {
	
	@Test(expected=NullPointerException.class)	// fail
//	@Test()
	public void testInvalidCode() {	// IllegalArgumentException
//		try {
			CodeProperties p = CodePropertiesLookup.getCodeProperties("ABC");
//			Assert.fail("Expected Was IllegalArgumentException");
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		}
		
		
	}
	
	@Ignore
	@Test
	public void testInvalidNumCode() {
		CodeProperties p = CodePropertiesLookup.getCodeProperties("124");
		
	}

	@Ignore
	@Test
	public void testNullCode() {	// IllegalArgumentException
		CodeProperties p = CodePropertiesLookup.getCodeProperties("");
		
	}
	
	@Test(expected=IllegalArgumentException.class)	// pass
//	@Test
	public void testAlfaNumerciCode() {	// IllegalArgumentException
//		try {
			CodeProperties p = CodePropertiesLookup.getCodeProperties("A1S2D3");
//			Assert.fail("Expected Was IllegalArgumentException");
//		} catch (IllegalArgumentException e) {
//			e.printStackTrace();
//		}
		
		
	}
	
	
//	@Test
//	public void failTest(){
//		Assert.fail("Failed By User");
//	}
	
	@Test(timeout=100)
	public void timeTest() {	// TestTimedOutException
		try {
			Thread.sleep(150);
		} catch (InterruptedException e) {
		}
		
	}
}
