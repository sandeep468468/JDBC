package com.abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system",
				"468ALLUsandy");
		Statement statement = connection.createStatement();
		String q1 = "create table emp(eid number,ename varchar2(30),esalary number)";
		int a = statement.executeUpdate(q1);
		System.out.println("table is created successfully  " + a);

		String q2 = "insert into emp(eid,ename,esalary) values(?,?,?)";
		PreparedStatement preparedStatement = connection.prepareStatement(q2);

		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("enter eid value");
			int eid = scanner.nextInt();
			System.out.println("enter ename value");
			String ename = scanner.next();
			System.out.println("enter esalary value");
			float esalary = scanner.nextFloat();

			preparedStatement.setInt(1, eid);
			preparedStatement.setString(2, ename);
			preparedStatement.setFloat(3, esalary);
			int b = preparedStatement.executeUpdate();
			System.out.println("insertion is done successfully  " + b);

			System.out.println("do you want to insert more records --- yes or no");
			String option1 = scanner.next();
			if (option1.equals("no")) {
				break;
			}

		}
		
		Thread.sleep(15000);
		
		System.out.println("===========================================================");
		System.out.println("do you want to update your table yes or no");
		String option2=scanner.next();
		if(option2.equals("yes")){
		String q3="update emp set ename=? where ename=?";
		PreparedStatement preparedStatement2=connection.prepareStatement(q3);
		preparedStatement2.setString(1, "santosh");
	    preparedStatement2.setString(2, "sandeep");
	    int x2=preparedStatement2.executeUpdate();
	    System.out.println("updation is done success "+x2);
		} else {
			System.out.println("don't want any operations");
		}
		
	    Thread.sleep(15000);
	     
		System.out.println("===========================================================");
		System.out.println("do you want to update table yes or no");
		String option3=scanner.next();
		if(option3.equals("yes")){
			 String q4="update emp set esalary=esalary+? where esalary>?";
			 PreparedStatement preparedStatement3=connection.prepareStatement(q4);
			 preparedStatement3.setFloat(1,500);
			 preparedStatement3.setFloat(2, 2000);
			 int x3=preparedStatement3.executeUpdate();
			 System.out.println("updation is complted  "+x3);
		} else {
			System.out.println("don't want any operations");
		}
		
		Thread.sleep(15000);
		System.out.println("=================================================================");
		System.out.println("do you want to delete a table data yes or no");
		String option4=scanner.next();
		if(option4.equals("yes")) {
			String q5="delete from emp where esalary>?";
			PreparedStatement preparedStatement4 =connection.prepareStatement(q5);
			preparedStatement4.setInt(1, 4000);
			int x4=preparedStatement4.executeUpdate();
			System.out.println("deletion of table data is done successfully "+x4);
		} else {
			System.out.println("no need of deleting table data");
		}
		
		Thread.sleep(15000);
		System.out.println("=================================================================");
		System.out.println("do you want to drop a table yes or no");
		String option5=scanner.next();
		if(option5.equals("yes")) {
			String q6="drop table emp";
			int x2 = statement.executeUpdate(q6);
			System.out.println("table is dropped successfully "+x2);
		} else {
			System.out.println("no need of dropping table");
		}
		
		Thread.sleep(5000);
		
	    /*String q7="select * from emp";
	    PreparedStatement preparedStatement4=connection.prepareStatement(q7);
	    ResultSet rs=preparedStatement4.executeQuery();
	    while(rs.next())
	    {
	    	System.out.println(rs.getInt(1)+"         "+rs.getString(2)+"       "+rs.getFloat(2));
	    }*/
		
		System.out.println("=========================================");
		System.out.println("table operations done successfully");
        connection.close();
	}

}
