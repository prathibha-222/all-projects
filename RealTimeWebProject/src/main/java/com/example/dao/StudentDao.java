package com.example.dao;
import java.sql.*;
public class StudentDao {
	public static Connection con=getCon();
	public static PreparedStatement ps;
	public static ResultSet rs;
	public static Connection getCon() {
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mphasis","root","Password@12");
			System.out.println("Connected Successfully...");
		}
		catch(ClassNotFoundException cnf) 
		{
			System.out.println(cnf);
		}
		catch(SQLException sql) 
		{
			System.out.println(sql);
		}
		return con;
	}
	public static int addstudent(StudentBean sb)
	{
		try
		{
			ps=con.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1, sb.getRollno());
			ps.setString(2, sb.getName());
			ps.setString(3, sb.getBranch());
			i = ps.executeUpdate();
			
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return i;
	}
	
}
 