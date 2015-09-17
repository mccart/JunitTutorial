package com.testcases;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.csvreader.CsvReader;
import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;


//	http://javacsv.sourceforge.net/
	
	
public class TestCsv extends Assert {
	
	private static CsvReader reader = null;
	private static CsvReader count = null;
	
	private static String isoCode[] = null;
	private static String numCode[] = null;
	private static String expected[][] = null;
	
	private  static String getPath() {
		URL loc = TestCsv.class.getClassLoader().getResource("./");
		String path = loc.getPath();
		System.out.println(path);
//		/C:/Users/Family/Projects/Junit/bin/
		path = path.replaceAll("bin", "src");
		path = path + "com" + System.getProperty("file.separator") + "resources" + System.getProperty("file.separator") + "data.csv";
//		System.out.println(path);
//		/C:/Users/Family/Projects/Junit/src/com\resources\data.csv
		return path;
	}
	
	private static int getRow(CsvReader r) {
		int i = 0;
		try {
			while(r.readRecord()) {
				i++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	private static void setData( CsvReader r ) {
		int row = getRow(r);
		isoCode = new String[row];
		numCode = new String[row];
		expected = new String[row][4];
		
		int i = 0;
		try {
			while( reader.readRecord() ) {
//				System.out.println(reader.get(0));
				isoCode[i] = reader.get(0);
				numCode[i] = reader.get(1);
				expected[i][0] = reader.get(0);
				expected[i][1] = reader.get(1);
				expected[i][2] = reader.get(2);
				expected[i][3] = reader.get(3);
				i++;
			}
		} catch( IOException e ) {
			e.printStackTrace();
		}
//		System.out.println("row : " + row + " i : " + i);
//		System.out.println("isoCode length : " + isoCode.length);
//		System.out.println("expected length : " + expected.length);
		
		/*for( int k = 0; k < expected.length; k++ ) {
			System.out.println(isoCode[k]);
			System.out.println(numCode[k]);
			System.out.println(expected[k][0] + expected[k][1] + expected[k][2] + expected[k][3]);
		}*/
	}
	
	@BeforeClass
	public static void setUp() {
		try {
			
//			reader = new CsvReader("C:\\Users\\Family\\Projects\\Junit\\src\\com\\resources\\data.csv");
//			count = new CsvReader("C:\\Users\\Family\\Projects\\Junit\\src\\com\\resources\\data.csv");
			
			reader = new CsvReader(getPath());
			count = new CsvReader(getPath());
			
			reader.setSkipEmptyRecords(true);
			reader.setComment('#');
			reader.setUseComments(true);
			// reader and count needs to be consistent
			count.setSkipEmptyRecords(true);  
			count.setComment('#');
			count.setUseComments(true);
			
/*			while(reader.readRecord()) {
				// blank lines are skipped
				System.out.println("isoCode : " + reader.get(0));
			}
*/			
			setData(count);
			
		} catch (IOException e) {
			e.printStackTrace();		} 
	}
	
	@Test
	public void testCase() {
		
	}
	
	@Test
	public void testIsoCode(){
		for(int i = 0; i < isoCode.length; i++){
			CodeProperties p = CodePropertiesLookup.getCodeProperties(isoCode[i]);
			assertEquals(expected[i][0], p.getSymbol());
			assertEquals(expected[i][1], p.getCurrencyCode());
			assertEquals(Integer.parseInt((expected[i][2])), p.getFractionDigits());
//			assertEquals(expected[i][3], p.getCurrencyName());
			assertEquals(expected[i][3], "a" + p.getCurrencyName());
		}
	}
	
	@Test
	public void testNumCode(){
		
		for(int i = 0; i < numCode.length; i++){
			CodeProperties p = CodePropertiesLookup.getCodeProperties(numCode[i]);
			assertEquals(expected[i][0], p.getSymbol());
//			assertEquals(expected[i][0], "a" + p.getSymbol());
			assertEquals(expected[i][1], p.getCurrencyCode());
			assertEquals(Integer.parseInt((expected[i][2])), p.getFractionDigits());
			assertEquals(expected[i][3], p.getCurrencyName());
		}
		
	}
	
	@AfterClass
	public static void cleanUp() {
		if(reader != null){
			reader.close();
			reader = null;
		}
	}
	

}
