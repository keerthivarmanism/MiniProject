package Stock_trading_simulator;

import java.util.*;
public class User extends Validator {

	private String name;
	private String email;
	private String password;
	private long acc_no;
	private double amt;
	
	User(String h)
	{
		
	}
	User()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter 1 to signin");
		System.out.println("Enter 2 to signup");
		int ch=Integer.parseInt(s.nextLine());
		if(ch==1)
		{
			Signin si=new Signin();
			si.con();
		}
		else if(ch==2)
		{
			System.out.println("Enter the name");
			name=s.nextLine();
			System.out.println("Enter the email");
			email=s.nextLine();
			if(!iscorrect(email))
			{
				System.out.println("Enter the correct email,try again...");
				System.exit(0);
			}
			System.out.println("Enter the password");
			password=s.nextLine();
			if(!iscorrect(password,password.length()))
			{
				System.out.println("Enter the password atleast 6 character 3 digit and 1 special character");
				System.exit(0);
			}
			System.out.println("Enter the accno");
			acc_no=s.nextLong();
			System.out.println("Enter the amount");
			amt=s.nextDouble();
			Signup su=new Signup(name,email,password,acc_no,amt);
			
		}
		else
		{
			System.out.println("Enter the valid number");
		}
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}
	public double getAmt() {
		return amt;
	}
	public void setAmt(long amt) {
		this.amt = amt;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAmt(double amt) {
		this.amt = amt;
	}
}
