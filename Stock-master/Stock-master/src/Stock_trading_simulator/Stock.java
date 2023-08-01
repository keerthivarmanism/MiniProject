package Stock_trading_simulator;
import java.util.*;
import java.sql.*;
public class Stock
{

	private String stkName;
	private String stkOwner;
	private double stkValue;
	private double stkamt;
	private Connection con;
	Database db=new Database();
	Stock(String h)
	{
		
	}
	Stock()
	{
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Stock name");
		stkName=s.nextLine();
		System.out.println("Enter the Stock owner");
		stkOwner=s.nextLine();
		int max=5,min=-5;
		stkValue=Math.random()*(max-min+1)+min;
	
		System.out.println("Enter the stock amount");
		stkamt=s.nextDouble();
		con=db.getConnection();
		addStock(con);
	}
	void stdisplay()
	{
		try
		{
			System.out.println("The Available stocks in below");
			con=db.getConnection();
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from stocklist");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getDouble(4));
			}
		}
		catch(Exception e)
		{
			System.out.println("stock.java "+e);
		}
	}
	public String getStkName() {
		return stkName;
	}

	public void setStkName(String stkName) {
		this.stkName = stkName;
	}

	public String getStkOwner() {
		return stkOwner;
	}

	public void setStkOwner(String stkOwner) {
		this.stkOwner = stkOwner;
	}

	public double getStkValue() {
		return stkValue;
	}

	public void setStkValue(double stkValue) {
		this.stkValue = stkValue;
	}
	
	public double getStkamt() {
		return stkamt;
	}
	public void setStkamt(double stkamt) {
		this.stkamt = stkamt;
	}
	void addStock(Connection con)
	{
		try
		{
			PreparedStatement ps1=con.prepareStatement("insert into stocklist values(?,?,?,?)");
			ps1.setString(1,stkName);
			ps1.setString(2,stkOwner);
			ps1.setDouble(3,stkValue);
			ps1.setDouble(4,stkamt);
			ps1.executeUpdate();
			System.out.println("Stock added successfully");
		}
		catch(Exception e)
		{
			System.out.println("Stock.java "+e);
		}
	}
}
