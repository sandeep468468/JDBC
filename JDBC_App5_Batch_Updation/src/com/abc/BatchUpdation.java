package com.abc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchUpdation{

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","468ALLUsandy");
		Statement statement=connection.createStatement();
		 
        statement.addBatch("create table emp1(eid number,efname varchar2(30),elname varchar2(30),esalary number)");
		statement.addBatch("insert into emp1(eid,efname,elname,esalary) values (1,'Sandeep','Malladi',4500)");
		statement.addBatch("insert into emp1(eid,efname,elname,esalary) values (2,'Pavan','Malladi',5000)");
		statement.addBatch("update emp1 set esalary=esalary+500 where esalary>1000");
		statement.addBatch("drop table emp1");
		
		int[] a=statement.executeBatch();
		
		for(int xx:a)
		{
			System.out.println(xx);
		}
		
		connection.close();
	}
}
