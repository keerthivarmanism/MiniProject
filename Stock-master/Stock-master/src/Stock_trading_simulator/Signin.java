package Stock_trading_simulator;
import java.sql.*;
import java.util.*;
import java.sql.*;
public class Signin extends Validator
{

	private String email;
	private String password;
	private Connection con;
	Database db=new Database();
	
	void con()
	{
		con=db.getConnection();
		Scanner s=new Scanner(System.in);
		System.out.println("Enter your email");
		this.email=s.nextLine();
		if(!iscorrect(this.email))
		{
			System.out.println("Enter the correct email,try again....");
			System.exit(0);
		}
		System.out.println("Enter your password");
		this.password=s.nextLine();
		if(!iscorrect(password,password.length()))
		{
			System.out.println("Enter the password atleast 6 character 3 digit and 1 special character");
			System.exit(0);
		}
		check(email,password);
	}
	void check(String email,String password)
	{
		try
		{
			Statement st=con.createStatement();
			String query="select password,name from user where (password=? and email=?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(2,email);
			ps.setString(1,password);
			int h=0;
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				System.out.println("=====Welcome Back====");
				h=1;
				Decision des=new Decision(email);
			}
			if(h==0)
			{
				System.out.println("Sry..try again...");
			}
		}
		
		catch(Exception e)
		{
				System.out.println("Signin.java  "+e);	
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
