package com.testcases;

import org.junit.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;

public class TestRunListenerError{
	
	@Test()
	public void testInvalidCode() {	// IllegalArgumentException
		CodeProperties p = CodePropertiesLookup.getCodeProperties("ABC");
	}
	
	@Test
	public void testInvalidNumCode() {	// ok
		CodeProperties p = CodePropertiesLookup.getCodeProperties("124");
	}

	@Test
	public void testNullCode() {	// IllegalArgumentException
		CodeProperties p = CodePropertiesLookup.getCodeProperties("");
	}
	
}
