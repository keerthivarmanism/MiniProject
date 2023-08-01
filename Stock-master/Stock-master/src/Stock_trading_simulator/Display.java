package Stock_trading_simulator;
import java.util.*;
import java.sql.*;
public class Display{

	private Connection con;
	Database db=new Database();
	Display()
	{
		con=db.getConnection();
		try
		{
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from user");
			while(rs.next())
			{
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getLong(4)+"  "+rs.getLong(5));
			}
		}
		catch(Exception e)
		{
			System.out.println("Display.java "+e);
		}
	}
}
