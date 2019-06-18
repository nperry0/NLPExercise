package ingest;

import java.io.File;
import java.io.FileWriter;
import java.sql.*;
import java.util.*;

public class Database {
	
	public static void createDatabase() {
		
		Connection conn = null;
	    Statement stmt = null;
	    	
	    try {
	    	Class.forName("org.sqlite.JDBC");
	    	conn = DriverManager.getConnection("jdbc:sqlite:CodingChallenge.db");
	    	System.out.println("Opened database successfully");

	    	stmt = conn.createStatement();
	    	String sql = "CREATE TABLE DIRECTORY " +
	    			"(A 		TEXT      	NOT NULL," +
	    			" B			TEXT		NOT NULL," +
	    			" C			TEXT		NOT NULL," +
	    			" D			INT			NOT NULL," +
	    			" E			BLOB		NOT NULL," +
	    			" F			TEXT		NOT NULL," +
	    			" G 		REAL		NOT NULL," +
	    			" H 		INT 		NOT NULL," +
	    			" I			INT 		NOT NULL," +
	    			" J   		TEXT		NOT NULL)";
	    	stmt.executeUpdate(sql);
	    	stmt.close();
	    	conn.close();
	      	} catch ( Exception e ) {
	      		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      		System.exit(0);
	      }
	      System.out.println("Table created successfully");
	}
	
	
	public static void insertRecord(List<String> record) {
		Connection conn = null;
		PreparedStatement stmt = null;
	      
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:CodingChallenge.db");

			conn.setAutoCommit(false);
			System.out.println("Opened database successfully");
					
			stmt = conn.prepareStatement("INSERT INTO DIRECTORY (A,B,C,D,E,F,G,H,I,J)"
					+ " VALUES (?,?,?,?,?,?,?,?,?,?)");
			
			stmt.setString(1,  record.get(0));
			stmt.setString(2,  record.get(1));
			stmt.setString(3,  record.get(2));
			stmt.setInt(4,  1);
			stmt.setString(5,  record.get(0));
			stmt.setString(6,  record.get(0));
			stmt.setFloat(7,  (float)1.05);
			stmt.setInt(8,  1);
			stmt.setInt(9,  0);
			stmt.setString(10,  record.get(0));


//			for (int i=1;i<=record.size();i++) {
//				switch(i) {
//				case 0: case 1: case 2: case 5: case 9:
//					stmt.setString(i, record.get(i));
//					System.out.println("Debug A inserts " + record.get(i));
//					break;
//				case 3:
//					int gender = 0;
//					if (record.get(3).equals("Male")) {
//						gender = 1;
//					}
//					stmt.setInt(3, gender);
//					break;
//				case 7: case 8:
//					int bool = 0;
//					if (record.get(i).equals("TRUE")) {
//						bool = 1;
//					}
//					stmt.setInt(i, bool);
//					System.out.println("Debug B");
//					break;
//				case 4:
//					System.out.println("Debug C");
//
//					String filename = record.get(4).substring(record.get(4).length() - 6);
//					File file = new File(System.getProperty("user.dir") + 
//							"/images/" + filename + ".txt");
//					if (file.createNewFile())
//					{
//					    System.out.println("File is created.");
//					    
//					    FileWriter writer = new FileWriter(file);
//					    writer.write(record.get(4));
//					    writer.close();
//					    stmt.setString(4, filename);
//					} else {
//					    System.out.println("File already exists.");
//					}
//					break;
//				case 6:
//					System.out.println("Debug D");
//					
//					String number = record.get(6).substring(1);
//					float f = Float.parseFloat(number);
//					stmt.setFloat(6, f);
//					break;
//
//				}
		//	}
			
			stmt.executeUpdate();

			stmt.close();
			conn.commit();
			conn.close();
	      	} catch ( Exception e ) {
	      		System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      		System.exit(0);
	      	}
		
	}
	
	public static void selectTopFive() {
		{

			   Connection conn = null;
			   Statement stmt = null;
			   try {
			      Class.forName("org.sqlite.JDBC");
			      conn = DriverManager.getConnection("jdbc:sqlite:CodingChallenge.db");
			      conn.setAutoCommit(false);
			      System.out.println("Opened database successfully");

			      stmt = conn.createStatement();
			      ResultSet rs = stmt.executeQuery( "SELECT * FROM DIRECTORY LIMIT 5;" );
			      
			      while ( rs.next() ) {
			    	 String a = rs.getString("A");
			    	 String b = rs.getString("B");
			    	 String c = rs.getString("C");
			         int d = rs.getInt("D");
			         Blob e = rs.getBlob("E");
			         String f = rs.getString("F");
			         float g = rs.getFloat("G");
			         int h = rs.getInt("H");
			         int i = rs.getInt("I");
			         String j = rs.getString("J");

			         
			         System.out.println( "A = " + a );
			         System.out.println( "B = " + b );
			         System.out.println( "C = " + c );
			         System.out.println( "D = " + d );
			         System.out.println( "E = " + e );
			         System.out.println( "F = " + f );
			         System.out.println( "G = " + g );
			         System.out.println( "H = " + h );
			         System.out.println( "I = " + i );
			         System.out.println( "J = " + j );
			         System.out.println();
			      }
			      rs.close();
			      stmt.close();
			      conn.close();
			   } catch ( Exception e ) {
			      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
			      System.exit(0);
			   }
			   System.out.println("Operation done successfully");
			  }
	}

	public static void main(String[] args) {
		//createDatabase();
		List<String> record = new ArrayList<String>(
				Arrays.asList(
						"Douglas",
						"Stone",
						"dstone0@wix.com",
						"Male","hulhfuirhquih43qiljkdlsahforewhf8hwqrlewqjfewoif;hewiflhewjflejwhf",
						"switch",
						"$0.02",
						"TRUE",
						"FALSE",
						"Cangzhou"
						));
		insertRecord(record);
		//selectTopFive();
	}

}
