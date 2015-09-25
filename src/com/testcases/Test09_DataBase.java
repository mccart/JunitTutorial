package com.testcases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.AfterClass;
//import junit.framework.Assert;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.mapper.CodeProperties;
import com.mapper.CodePropertiesLookup;



public class Test09_DataBase extends Assert {
	
	private static Connection con = null;
	private static PreparedStatement stm = null;
	private static ResultSet rs = null;
	
	private static String isoCode[] = null;
	private static String numCode[] = null;
	private static String expected[][] = null;
	
	
	private static void getData(ResultSet rs) throws SQLException {
		
		rs.last();					// move to last row
		int rowid = rs.getRow();	// get row count
		rs.first();					// move to first row
		
		isoCode = new String[rowid - 1];
		numCode = new String[rowid - 1];
		expected = new String[rowid - 1][4];
		
		int i = 0;
		while(rs.next()){
			isoCode[i] = rs.getString("isocode");
			numCode[i] = rs.getString("numcode");
			expected[i][0] = rs.getString("isocode");
			expected[i][1] = rs.getString("numcode");
			expected[i][2] = "" + rs.getInt("fdigit");
			expected[i][3] = rs.getString("name");
			i++;
		}
		
		/*for( int j=0; j < isoCode.length; j++ ) {
			System.out.println("code " + isoCode[j]);
		}*/
		
	}
	
	@BeforeClass
	public static void setup() {
		String sql = "select * from codeData";
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //step - 1
			con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=AppDatabase", "sa", "admin1234#");
			stm = con.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stm.executeQuery();
			getData(rs);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		// See notes elsewhere for:
		// 1) download and install SQL Express 2014
		// 2) SQL database creation and table data insert
		// 3) SQL Server Configuration Manager to open/set 1433 port
//		System.out.println("\nConnection Done\n");
	}
	
	@Ignore
	@Test
	public void testCase() {
		System.out.println("");
	}
	
	@Test
	public void testIsoCode(){
		for(int i = 0; i < isoCode.length; i++){
			CodeProperties p = CodePropertiesLookup.getCodeProperties(isoCode[i]);
			assertEquals(expected[i][0], p.getSymbol());
			assertEquals(expected[i][1], p.getCurrencyCode());
			assertEquals(Integer.parseInt((expected[i][2])), p.getFractionDigits());
			assertEquals(expected[i][3], p.getCurrencyName());
		}
	}
	
	@Test
	public void testNumCode(){
		for(int i = 0; i < numCode.length; i++){
			CodeProperties p = CodePropertiesLookup.getCodeProperties(numCode[i]);
//			assertEquals(expected[i][0], p.getSymbol());
			assertEquals(expected[i][0], "a" + p.getSymbol());
			assertEquals(expected[i][1], p.getCurrencyCode());
			assertEquals(Integer.parseInt((expected[i][2])), p.getFractionDigits());
			assertEquals(expected[i][3], p.getCurrencyName());
		}
		
	}
	
	@AfterClass
	public static void cleanUp() {
		try {
			if(con != null){
				con.close();
				con = null;
			}
			if(stm != null){
				stm.close();
				stm = null;
			}
			if(rs != null){
				rs.close();
				rs = null;
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
