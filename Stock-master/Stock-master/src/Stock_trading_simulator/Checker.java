package Stock_trading_simulator;
import java.util.*;
import java.sql.*;

public class Checker {

	private String email;
	private Connection con;
	
	Database db=new Database();
	Checker(String email)
	{
		this.email=email;
	}
	
	void check()
	{
		try
		{
		this.con=db.getConnection();
		System.out.println("your information");
		PreparedStatement ps1=con.prepareStatement("select * from user where email=?");
		ps1.setString(1,email);
		ResultSet rs=ps1.executeQuery();
		while(rs.next())
		{
			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getDouble(5)+"  ");
		}
		}
		catch(Exception e)
		{
			System.out.println("Checker.java "+e);
		}
		
	}
}
