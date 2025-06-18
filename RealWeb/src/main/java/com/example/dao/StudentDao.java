package com.example.dao;
import java.sql.*;
import java.util.*;

import com.example.bean.StudentBean;


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
		int i=0;
		try
		{
			ps=con.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1, sb.getRollno());
			ps.setString(2, sb.getName());
			ps.setString(3, sb.getBranch());
			i=ps.executeUpdate();
			
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return i;
	}
	
	public static int updatestudent(StudentBean sb)
	{
		int i=0;
		try
		{
			ps=con.prepareStatement("update student set name=?,branch=? where rollno=?");
			
			ps.setString(1, sb.getName());
			ps.setString(2, sb.getBranch());
			ps.setInt(3, sb.getRollno());
			i=ps.executeUpdate();
			
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return i;
	}
	
	public static int deletestudent(int rno)
	{
		int i=0;
		try
		{
			ps=con.prepareStatement("delete from student where rollno=?");
			ps.setInt(1, rno);
			i=ps.executeUpdate();
			
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return i;
	}
	
	public static ArrayList<StudentBean> selectAll()
	{
		ArrayList<StudentBean> a1 =new ArrayList<StudentBean>();
		try
		{
			ps=con.prepareStatement("select * from student");
			rs=ps.executeQuery();
			while(rs.next())
			{
				StudentBean sb=new StudentBean();
				sb.setRollno(rs.getInt("rollno"));
				sb.setName(rs.getString(2));
				sb.setBranch(rs.getString("branch"));
				a1.add(sb);
				
			}
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return a1;
	}
	public static StudentBean selectByRollno(int rno)
	{
		StudentBean sb=new StudentBean();
		try
		{
			ps=con.prepareStatement("select * from student where rollno=?");
			ps.setInt(1, rno);
			rs=ps.executeQuery();
			while(rs.next())
			{
				sb.setRollno(rs.getInt(1));
				sb.setName(rs.getString(2));
				sb.setBranch(rs.getString(3));
			}
		}
		catch(SQLException sql)
		{
			System.out.println(sql);
		}
		return sb;
	}
}
 