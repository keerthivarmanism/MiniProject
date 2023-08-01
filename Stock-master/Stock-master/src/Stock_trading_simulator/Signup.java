package Stock_trading_simulator;
import java.util.*;
import java.util.regex.*;
import java.sql.*;
public class Signup
{

	private String name;
	private String email;
	private String password;
	private long acc_no;
	private double amt;
	private Connection con;
	Database db=new Database();
	
	
	Signup(String name,String email,String password,long accno,double amt)
	{
		con=db.getConnection();
		try
		{
			this.name=name;
			this.email=email;
			this.password=password;
			this.acc_no=accno;
			this.amt=amt;
			
			PreparedStatement ps1=con.prepareStatement("insert into user values(?,?,?,?,?)");
			ps1.setString(1,name);
			ps1.setString(2,email);
			ps1.setString(3,password);
			ps1.setLong(4,acc_no);
			ps1.setDouble(5,amt);
			ps1.executeUpdate();
			System.out.println("Data add successfully");
		}
		catch(Exception e)
		{
			System.out.println("signup.java "+e);
		}
	}
	
}
