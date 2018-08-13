package com.abc.jdbc2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestType4ThinDriver {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InterruptedException {
		
		
		//step1:load the driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//step2:create the connection
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","468ALLUsandy");
		System.out.println("connection is created successfully");
		
		Statement statement=connection.createStatement();
		
		//write the query
		String q1="create table emp(eid number,ename varchar2(30),eemail varchar2(30),esalary number)";
		
		//execute the query by using statement object
		int x1=statement.executeUpdate(q1);
		System.out.println("creation of table is done =======>"+x1);//will return 0 beacuse it is type 4 driver
		
		//for inserting values into table emp
		String q2="insert into emp(eid,ename,eemail,esalary) values(1,'Pavan','pavan@gmail.com',4500)";
		String q3="insert into emp(eid,ename,eemail,esalary) values(1,'Santhosh','santhosh@gmail.com',5000)";
		String q4="insert into emp(eid,ename,eemail,esalary) values(1,'Sushwanth','sushwanth@gmail.com',5500)";
		
		int x2=statement.executeUpdate(q2);
		int x3=statement.executeUpdate(q3);
		int x4=statement.executeUpdate(q4);
		System.out.println("insertion is completed ====>"+x2);
		System.out.println("insertion is completed ====>"+x3);
		System.out.println("insertion is completed ====>"+x4);
		
		//updating a table
		String q5="update emp set eid=4 where ename='Pavan'";
		String q6="update emp set eemail='pavanreddy@gmail.com' where ename='Pavan'";
		int x5=statement.executeUpdate(q5);
		int x6=statement.executeUpdate(q6);
		System.out.println("updation is done ====>"+x5);
		System.out.println("updation is complete =======>"+x6);
		
		//droping query
		String q7="delete from emp where eid=2";
		int x7=statement.executeUpdate(q6);
		System.out.println("deletion is done =====>"+x7);
		
		//select query
		String q8="select * from emp";
		ResultSet rs=statement.executeQuery(q8);
		System.out.println("we are doing select query operation");
		
		Thread.sleep(10000);
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"         "+rs.getString("ename")+"        "+rs.getString(3)+"      "+rs.getInt(4));
		}
		
		//step5:close the connection
		connection.close();
		
		
		

	}

}
