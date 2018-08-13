package com.abc.jdbc3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","468ALLUsandy");
		System.out.println("connection created success"+connection);
		Statement statement=connection.createStatement();
		 
		String q1="create table emp1(eid number,efname varchar2(30),elname varchar2(30),esalary number)";
		int x=statement.executeUpdate(q1);
		System.out.println("table creation ====>"+x);
		
		String q2="insert into emp1(eid,efname,elname,esalary) values (1,'Sandeep','Malladi',4500)";
		int y=statement.executeUpdate(q2);
		System.out.println("insertion values ====>"+y);
		
		String q3="insert into emp1(eid,efname,elname,esalary) values (2,'Pavan','Malladi',5000)";
		int z=statement.executeUpdate(q3);
		System.out.println("insertion values ====>"+z);
		
		String q4="update emp1 set esalary=esalary+500 where esalary>1000";
		int a=statement.executeUpdate(q4);
		System.out.println("update table ====>"+a);
		
		String q5="select * from emp1";
		ResultSet rs=statement.executeQuery(q5);
		System.out.println("select query =====> "+rs);
		
		while(rs.next())
		{
			System.out.println(rs.getInt(1)+"    "+rs.getString("efname")+" "+rs.getString(3)+"  "+rs.getInt(4));
		}
		
	    connection.close();
		

	}

}
