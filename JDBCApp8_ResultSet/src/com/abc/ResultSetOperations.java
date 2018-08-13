package com.abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetOperations {

	public static void main(String[] args) throws SQLException, ClassNotFoundException, InterruptedException {
		//step1:load the driver
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
		//step2:create the connection
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","468ALLUsandy");
	    System.out.println("connection is created successfully");

	    Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
	    
	    //by performing batch updation do it makes simple to do insert operations
	    String q1="create table employee(eid number,efname varchar2(30),elname varchar2(30),esalary number)";
	    statement.addBatch(q1);
	    statement.addBatch("insert into employee(eid,efname,elname,esalary) values(1,'Sandeep','Malladi',5000)");
	    statement.addBatch("insert into employee(eid,efname,elname,esalary) values(2,'Pavan','Malladi',6000)");
	    statement.addBatch("insert into employee(eid,efname,elname,esalary) values(3,'Santhosh','Madireddy',7000)");
	    statement.addBatch("insert into employee(eid,efname,elname,esalary) values(4,'Sushwanth','Madireddy',8000)");
	    statement.addBatch("insert into employee(eid,efname,elname,esalary) values(5,'Nithin','Palle',9000)");
	    int a[]=statement.executeBatch();
	    
	    for(int xx:a)
	    {
	    	System.out.println(xx);
	    }
	    
	    System.out.println("===========================================================================================");
	    Thread.sleep(10000);
	    
	    String q2="select * from employee";
	    ResultSet rs=statement.executeQuery(q2);
	    rs.afterLast();
	    while(rs.previous())
	    {
	    	System.out.println(rs.getInt(1)+"          "+rs.getString(2)+"          "+rs.getString(3)+"          "+rs.getFloat(4));
	    }
	    
	    System.out.println("===========================================================================================");
	    rs.last();
	    System.out.println(rs.getInt(1)+"          "+rs.getString(2)+"          "+rs.getString(3)+"          "+rs.getFloat(4));
	    
	    System.out.println("===========================================================================================");
	    rs.first();
	    System.out.println(rs.getInt(1)+"          "+rs.getString(2)+"          "+rs.getString(3)+"          "+rs.getFloat(4));
	    
	    System.out.println("===========================================================================================");
	    rs.absolute(2);
	    System.out.println(rs.getInt(1)+"          "+rs.getString(2)+"          "+rs.getString(3)+"          "+rs.getFloat(4));
	    
	    System.out.println("all operations completed successfully");
	    connection.close();
	    
	}

}
