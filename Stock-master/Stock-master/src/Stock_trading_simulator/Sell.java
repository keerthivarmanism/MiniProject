package Stock_trading_simulator;

import java.util.*;
import java.sql.*;

public class Sell {

	private String email;
	private Connection con;
	Database db=new Database();
	
	Sell(String email)
	{
		this.email=email; 
		check(email);
	}
	void check(String email)
	{
		this.email=email;
		con=db.getConnection();
		try
		{
			PreparedStatement ps1=con.prepareStatement("select * from report where email=?");
			ps1.setString(1,email);
			boolean flag=true;
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) 
			{
				flag=false;
			}
			if(flag)
			{
				System.out.println("there is no stock .. pls Buy the stock");
			}
			else 
			{
				PreparedStatement ps2=con.prepareStatement("select stockname from report where email=?");
				ps2.setString(1,email);
				String stname="";
				ResultSet rs1=ps2.executeQuery();
				while(rs1.next())
				{
					stname=rs1.getString(1);
				}
				double stkamt=0;
				PreparedStatement ps3=con.prepareStatement("select value,amount from stocklist where name=?");
				ps3.setString(1,stname);
				ResultSet rs2=ps3.executeQuery();
				double val=0;
				while(rs2.next())
				{
					val=rs2.getDouble(1);
					stkamt=rs2.getDouble(2);
				}
				int max=5,min=-5;
				double rate=Math.random()*((max-min+1)+min);
				System.out.println("the value of the stock at time of buying is "+val+"%");
				System.out.println("the current value of the stock is"+rate);
				
				PreparedStatement ps4=con.prepareStatement("select amount from user where email=?");
				ps4.setString(1,email);
				double uservalue=0;
				ResultSet rs3=ps4.executeQuery();
				while(rs3.next())
				{
					uservalue=rs3.getDouble(1);
				}
				double fin_ans=uservalue+stkamt+((stkamt*rate)/100);
				
				PreparedStatement ps5=con.prepareStatement("update user set amount=? where email=?");
				ps5.setDouble(1,fin_ans);
				ps5.setString(2,email);
				ps5.executeUpdate();
				System.out.println("Stock is sold successfully");
			}
		}
		catch(Exception e)
		{
			System.out.println("Sell.java "+e);
		}
	}
}
