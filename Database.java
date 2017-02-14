import java.sql.*;
import java.util.*;

public class Database {
	
	static Connection connection;
	static Statement statement;
	static String cota = "'";

	public Database() {

		try{
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
    		statement = connection.createStatement();
    		statement.executeUpdate("CREATE DATABASE ContractManagement");
    		createTable();
		}
		catch(Exception e){
			
		}
		
		
		
	}
	
	
	
	public static int getNumberOfSuppliersDetails()throws Exception{
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
		Statement statement = connection.createStatement();
		ResultSet ans = statement.executeQuery("select * from SUPPLIERDETAILS");
		int counter = 0;
		while(ans.next()){
			counter++;
		}
		return counter;
	}
	
	
	public static int getNumberOfSuppliersManager()throws Exception{
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
		Statement statement = connection.createStatement();
		ResultSet ans = statement.executeQuery("select * from SUPPLIERMANAGER");
		int counter = 0;
		while(ans.next()){
			counter++;
		}
		return counter;
	}
	
	
	
	
	
	
	
	public static int getNumberOfClientsDetails()throws Exception{
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
		Statement statement = connection.createStatement();
		ResultSet ans = statement.executeQuery("select * from CLIENTDETAILS");
		int counter = 0;
		while(ans.next()){
			counter++;
		}
		return counter;
		
	}
	
	
	
	public static int getNumberOfClientsManager()throws Exception{
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
		Statement statement = connection.createStatement();
		ResultSet ans = statement.executeQuery("select * from CLIENTMANAGER");
		int counter = 0;
		while(ans.next()){
			counter++;
		}
		return counter;
		
	}
	
	
	
	
	
	
	
	public static void insertTableClientDetails(
			
			String id,String description,
			String contractValue,String awardDate,
			String expireDate,String tenderProcess,
			String contractOption,String contractCategory,
			String typesOfSupplier
			
			
	){
		try{
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
			Statement statement = connection.createStatement();
			

			String sql = 
					"INSERT INTO CLIENTDETAILS ("
					+ "referenceId, "
					+ "description, "
					+ "contractValue, "
					+ "awardDate, "
					+ "expireDate, "
					+ "tenderProcess, "
					+ "contractOption, "
					+ "contractCategory, "
					+ "typesOfSupplier)"+"VALUES("+
					
					
			cota+id+cota+","+
			cota+description+cota+","+
			cota+contractValue+cota+","+
			cota+awardDate+cota+","+
			cota+expireDate+cota+","+
			cota+tenderProcess+cota+","+
			cota+contractOption+cota+","+
			cota+contractCategory+cota+","+
			cota+typesOfSupplier+cota+")";
			
						
			statement.execute(sql);
			
			
			
			
		}
		catch(Exception e){
			System.out.println("error");
			
		}
	}
	
	
	
	
	
	
public static void insertTableSupplierDetails(
			
			String id,String description,
			String contractValue,String awardDate,
			String expireDate,String tenderProcess,
			String contractOption,String contractCategory,
			String typesOfSupplier
			
			
	){
		try{
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
			Statement statement = connection.createStatement();
			

			String sql = 
					"INSERT INTO SUPPLIERDETAILS ("
					+ "referenceId, "
					+ "description, "
					+ "contractValue, "
					+ "awardDate, "
					+ "expireDate, "
					+ "tenderProcess, "
					+ "contractOption, "
					+ "contractCategory, "
					+ "typesOfSupplier)"+"VALUES("+
					
					
			cota+id+cota+","+
			cota+description+cota+","+
			cota+contractValue+cota+","+
			cota+awardDate+cota+","+
			cota+expireDate+cota+","+
			cota+tenderProcess+cota+","+
			cota+contractOption+cota+","+
			cota+contractCategory+cota+","+
			cota+typesOfSupplier+cota+")";
			
						
			statement.execute(sql);
			
			
			
			
		}
		catch(Exception e){
			System.out.println("error");
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
public static void insertTableSupplierManager(
			
			String id,String name,
			String position,String business,
			String phoneNo,String mobileNo,
			String email
			
			
	){
		try{
			
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
			Statement statement = connection.createStatement();
			

			String sql = 
					"INSERT INTO SUPPLIERMANAGER ("
					+ "referenceId, "
					+ "name, "
					+ "position, "
					+ "businessUnit, "
					+ "phoneNo, "
					+ "mobileNo, "
					+ "emailAddress)"+"VALUES("+
					
					
			cota+id+cota+","+
			cota+name+cota+","+
			cota+position+cota+","+
			cota+business+cota+","+
			cota+phoneNo+cota+","+
			cota+mobileNo+cota+","+
			cota+email+cota+")";
			
						
			statement.execute(sql);

			
		}
		catch(Exception e){
			System.out.println("error");
			
		}
	}







public static void editSupplierManager(String refID,String colName,String newValue){
	Connection connection;
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
		Statement statement = connection.createStatement();
		
		String sql = "UPDATE SUPPLIERMANAGER SET "+colName+" = "+cota+newValue+cota+" WHERE referenceId = "+cota+refID+cota;
		statement.execute(sql);
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}








public static void editSupplierDetails(String refID,String colName,String newValue){
	Connection connection;
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
		Statement statement = connection.createStatement();
		
		String sql = "UPDATE SUPPLIERDETAILS SET "+colName+" = "+cota+newValue+cota+" WHERE referenceId = "+cota+refID+cota;
		statement.execute(sql);
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}



public static void editClientDetails(String refID,String colName,String newValue){
	Connection connection;
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
		Statement statement = connection.createStatement();
		
		String sql = "UPDATE CLIENTDETAILS SET "+colName+" = "+cota+newValue+cota+" WHERE referenceId = "+cota+refID+cota;
		statement.execute(sql);
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}


















public static void editClientManager(String refID,String colName,String newValue){
	Connection connection;
	try {
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
		Statement statement = connection.createStatement();
		
		String sql = "UPDATE CLIENTMANAGER SET "+colName+" = "+cota+newValue+cota+" WHERE referenceId = "+cota+refID+cota;
		statement.execute(sql);
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

}

















public static void insertTableClientManager(
		
		String id,String name,
		String position,String business,
		String phoneNo,String mobileNo,
		String email
		
		
){
	try{
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
		Statement statement = connection.createStatement();
		

		String sql = 
				"INSERT INTO CLIENTMANAGER ("
				+ "referenceId, "
				+ "name, "
				+ "position, "
				+ "businessUnit, "
				+ "phoneNo, "
				+ "mobileNo, "
				+ "emailAddress)"+"VALUES("+
				
				
		cota+id+cota+","+
		cota+name+cota+","+
		cota+position+cota+","+
		cota+business+cota+","+
		cota+phoneNo+cota+","+
		cota+mobileNo+cota+","+
		cota+email+cota+")";
		
					
		statement.execute(sql);

		
	}
	catch(Exception e){
		System.out.println("error");
		
	}
}














	
	
	
	
	
	
	
	
	
	
	
	
	
	public void createTable() throws Exception{
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ContractManagement","root","");
		Statement statement = connection.createStatement();
		
		
		
		
		
		
		
		
		
		
		
		
		
		statement.executeUpdate("CREATE TABLE  SUPPLIERDETAILS ( "
                +"referenceId VARCHAR(255) not NULL,"
                +"description VARCHAR(255),"
                +"contractValue VARCHAR(255)," 
                +"awardDate VARCHAR(255)," 
                +"expireDate VARCHAR(255),"
                +"tenderProcess VARCHAR(255)," 
                +"contractOption VARCHAR(255),"
                +"contractCategory VARCHAR(255)," 
                +"typesOfSupplier VARCHAR(255),"
                +"PRIMARY KEY ( referenceId ) )" ) ;
		
		
		
		
		statement.executeUpdate("CREATE TABLE  SUPPLIERMANAGER ( "
                +"referenceId VARCHAR(255) not NULL,"
                +"name VARCHAR(255),"
                +"position VARCHAR(255)," 
                +"businessUnit VARCHAR(255)," 
                +"phoneNo VARCHAR(255),"
                +"mobileNo VARCHAR(255)," 
                +"emailAddress VARCHAR(255),"
				+"PRIMARY KEY ( referenceId ) )" ) ;
		
		
		
		
		
		
		statement = connection.createStatement();
		
		
		
		
		
		
		
		
		
		
		statement.executeUpdate("CREATE TABLE  CLIENTDETAILS ( "
                +"referenceId VARCHAR(255) not NULL,"
                +"description VARCHAR(255),"
                +"contractValue VARCHAR(255)," 
                +"awardDate VARCHAR(255)," 
                +"expireDate VARCHAR(255),"
                +"tenderProcess VARCHAR(255)," 
                +"contractOption VARCHAR(255),"
                +"contractCategory VARCHAR(255)," 
                +"typesOfSupplier VARCHAR(255),"
                +"PRIMARY KEY ( referenceId ) )" ) ;
		
		
		
		
		statement.executeUpdate("CREATE TABLE  CLIENTMANAGER ( "
                +"referenceId VARCHAR(255) not NULL,"
                +"name VARCHAR(255),"
                +"position VARCHAR(255)," 
                +"businessUnit VARCHAR(255)," 
                +"phoneNo VARCHAR(255),"
                +"mobileNo VARCHAR(255)," 
                +"emailAddress VARCHAR(255),"
				+"PRIMARY KEY ( referenceId ) )" ) ;
		
		
		
		statement = connection.createStatement();
		
		statement.executeUpdate("CREATE TABLE  CONFLICTS ( "
                +"referenceId VARCHAR(255) not NULL,"
                +"answer VARCHAR(255),"
				+"PRIMARY KEY ( referenceId ) )" ) ;
		
		
		statement.executeUpdate("CREATE TABLE  WHS ( "
                +"referenceId VARCHAR(255) not NULL,"
                +"answer VARCHAR(255),"
				+"PRIMARY KEY ( referenceId ) )" ) ;
		
		
		statement.executeUpdate("CREATE TABLE  RECENT ( "
                +"referenceId VARCHAR(255) not NULL,"
                +"answer VARCHAR(255),"
				+"PRIMARY KEY ( referenceId ) )" ) ;
		
		
		statement = connection.createStatement();
		

		
		statement.executeUpdate("CREATE TABLE  PL ( "
                +"referenceId VARCHAR(255) not NULL,"
                +"answer VARCHAR(255),"
				+"PRIMARY KEY ( referenceId ) )" ) ;
		
		
		
		
		statement.executeUpdate("CREATE TABLE  ENV ( "
                +"referenceId VARCHAR(255) not NULL,"
                +"answer VARCHAR(255),"
				+"PRIMARY KEY ( referenceId ) )" ) ;
		
		
		statement = connection.createStatement();
		
		
		statement.executeUpdate("CREATE TABLE  QUALITY ( "
                +"referenceId VARCHAR(255) not NULL,"
                +"answer VARCHAR(255),"
				+"PRIMARY KEY ( referenceId ) )" ) ;
		
		
		
		
		statement = connection.createStatement();
		
		
		
		
		
		
		
		statement.executeUpdate("CREATE TABLE  CSR ( "
                +"referenceId VARCHAR(255) not NULL,"
                +"answer VARCHAR(255),"
				+"PRIMARY KEY ( referenceId ) )" ) ;
		
		
		statement.executeUpdate("CREATE TABLE  GIPA1 ( "
                +"referenceId VARCHAR(255) not NULL,"
                +"answer1 VARCHAR(255),"
                +"answer2 VARCHAR(255),"
                +"answer3 VARCHAR(255),"
                +"answer4 VARCHAR(255),"
                +"answer5 VARCHAR(255),"
                +"answer6 VARCHAR(255),"
                +"answer7 VARCHAR(255),"
                +"answer8 VARCHAR(255),"
                +"answer9 VARCHAR(255),"
                +"answer10 VARCHAR(255),"
				+"PRIMARY KEY ( referenceId ) )" ) ;
		
		
		
		
		statement = connection.createStatement();
		
		statement.executeUpdate("CREATE TABLE  GIPA2 ( "
                +"referenceId VARCHAR(255) not NULL,"
                +"answer1 VARCHAR(255),"
                +"answer2 VARCHAR(255),"
                +"answer3 VARCHAR(255),"
                +"answer4 VARCHAR(255),"
                +"answer5 VARCHAR(255),"
                +"answer6 VARCHAR(255),"
                +"answer7 VARCHAR(255),"
                +"answer8 VARCHAR(255),"
                +"answer10 VARCHAR(255),"
                +"answer11 VARCHAR(255),"
                +"answer12 VARCHAR(255),"
                +"answer13 VARCHAR(255),"
                +"answer14 VARCHAR(255),"
                +"answer15 VARCHAR(255),"
                +"answer16 VARCHAR(255),"
                +"answer17 VARCHAR(255),"
                +"answer18 VARCHAR(255),"
				+"PRIMARY KEY ( referenceId ) )" ) ;
		
		
		
		statement.executeUpdate("CREATE TABLE  GIPA3 ( "
                +"referenceId VARCHAR(255) not NULL,"
                +"answer1 VARCHAR(255),"
                +"answer2 VARCHAR(255),"
                +"answer3 VARCHAR(255),"
                +"answer4 VARCHAR(255),"
                +"answer5 VARCHAR(255),"
                +"answer6 VARCHAR(255),"
                +"answer7 VARCHAR(255),"
                +"answer8 VARCHAR(255),"
                +"answer10 VARCHAR(255),"
                +"answer11 VARCHAR(255),"
                +"answer12 VARCHAR(255),"
                +"answer13 VARCHAR(255),"
                +"answer14 VARCHAR(255),"
                +"answer15 VARCHAR(255),"
                +"answer16 VARCHAR(255),"
                +"answer17 VARCHAR(255),"
                +"answer18 VARCHAR(255),"
				+"PRIMARY KEY ( referenceId ) )" ) ;
		

	}

}
