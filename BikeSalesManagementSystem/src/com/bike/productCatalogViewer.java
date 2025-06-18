package com.bike;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class productCatalogViewer {
	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bikeStores","root","Password@12");
			Statement stm=con.createStatement();
			ResultSet rs=stm.executeQuery("select brand_id,category_id,model_year,list_price from production.products");
			while(rs.next()){
				System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getInt(3)+"\t"+rs.getFloat(4));
			}
			}catch(Exception e) {
				System.out.println(e.toString( ));
			}
		}

}
