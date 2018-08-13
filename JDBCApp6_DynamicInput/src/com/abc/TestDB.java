package com.abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TestDB {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","468ALLUsandy");
		
		Statement statement=connection.createStatement();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("enter table name");
		String tname=scanner.next();
		//System.out.println("table name is created successfully "+tname);
		
		//String q1="create table emp(eid number,ename varchar2(30),eemail varchar2(30),esalary number)";
		
		String q1="create table "+tname+"(eid number,ename varchar2(30),eemail varchar2(30),esalary number)";
		statement.executeUpdate(q1);
		System.out.println("table is created successfully "+tname);
		
		while(true)
		{
			System.out.println("enter eid value");
			int eid=scanner.nextInt();
			System.out.println("enter ename value");
			String ename=scanner.next();
			System.out.println("enter esalary value");
			float esalary=scanner.nextFloat();
			
			//String q2="insert into emp(eid,ename,eemail,esalary) values(1,'Pavan','pavan@gmail.com',4500)";
			
			//String q2="insert into "+tname+" values("+eid+","+ename+"',"+esalary+")";
			String q2="insert into "+tname+"(eid,ename,esalary) values("+eid+",'"+ename+"',"+esalary+")";
			
			System.out.println(q2);
			statement.executeUpdate(q2);
			System.out.println("values are inserted successfully");
			System.out.println("if you want to enter more records yes/no?");
			String option=scanner.next();
			if(option.equals("no"))
			{
				break;
			}
		}
		
		Thread.sleep(5000);
		
		System.out.println("enter table you want to drop");
		String tablename=scanner.next();
		String q3="drop table "+tablename;
		statement.executeUpdate(q3);
		System.out.println("table is dropped successfully");
		connection.close();
		
		

	}

}
