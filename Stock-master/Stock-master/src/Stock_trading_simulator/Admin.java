package Stock_trading_simulator;
import java.sql.*;
import java.util.*;
public class Admin extends Admin_Security
{
	private String email;
	private String password;
	private Connection con;
	Scanner s=new Scanner(System.in);
	Database db=new Database();
	
	
	Admin()
	{
		System.out.println("===Please the Email and Password to verify===");
		getData();
	}
	
	void getData()
	{
		System.out.println("Enter the username");
		email=s.nextLine();
		System.out.println("Enter the password");
		password=s.nextLine();
		verify();
		
	}
	
	void verify()
	{
		try
		{
			
			con=db.getConnection();
			PreparedStatement pst=con.prepareStatement("select * from admin where email=? and password=?");
			pst.setString(1,email);
			pst.setString(2,password);
			boolean flag=true;
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				System.out.println("----Welcome "+rs.getString(1)+" ----");
				flag=false;
			}
			if(flag)
			{
				System.out.println("Please enter the valid username and password");
			}
			else
			{
				choice();
			}
		}
		catch(Exception e)
		{
			System.out.println("Admin.java "+e);
		}
		
	}
	void choice()
	{
		System.out.println("Enter 1 to add stocks");
		System.out.println("Enter 2 to view the customer information");
		int ch=s.nextInt();
		if(ch==1)
		{
			Stock st=new Stock();
			
		}
		else if(ch==2)
		{
			Display ds=new Display();
		}
	}
	
}
