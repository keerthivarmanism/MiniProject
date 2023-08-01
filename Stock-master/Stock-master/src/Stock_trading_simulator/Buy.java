package Stock_trading_simulator;

import java.util.*;
import java.sql.*;

public class Buy{

	private Connection con;
	private String stockName;
	private String email;
	Database db=new Database();
	Buy(String email)
	{
		this.email=email;
		con=db.getConnection();
		Stock st=new Stock("nk");
		st.stdisplay();
		buyStock();
	}
	
	void buyStock()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the stock name to buy the stock");
		stockName=s.nextLine();
		check(stockName);
	}
	
	void check(String stockName)
	{
		try
		{
			PreparedStatement ps1=con.prepareStatement("select * from stocklist where name=?");
			ps1.setString(1,stockName);
			
			double val=0,amt=0;
			String stname="";
			ResultSet rs=ps1.executeQuery();
			boolean flag=true;
			while(rs.next())
			{
				flag=false;
				stname=rs.getString(1);
				val=rs.getDouble(3);
				amt=rs.getDouble(4);
			}
			if(flag)
			{
				System.out.println("The stock is not available");
			}
			else
			{	
				double amt1=0;
				PreparedStatement ps5=con.prepareStatement("select amount from user where email=?");
				ps5.setString(1,email);
				ResultSet rs1=ps5.executeQuery();
				while(rs1.next())
				{
					amt1=rs1.getDouble(1);
				}
				if(amt1>amt)
				{
					double ans=amt1-amt;
					PreparedStatement ps2=con.prepareStatement("insert into report values(?,?)");
					ps2.setString(1,stname);
					ps2.setString(2,email);
					ps2.executeUpdate();
					
					PreparedStatement ps3=con.prepareStatement("update user set amount=? where email=?");
					ps3.setDouble(1,ans);
					ps3.setString(2,email);
					ps3.executeUpdate();
					System.out.println("Thank you...");
				}
				else
				{
					System.out.println("sry,try other stocks due to insufficient money");
				}
			}
		}
		catch(Exception e)
		{
			System.out.println("Buy.java "+e);
		}
		
	}
}
