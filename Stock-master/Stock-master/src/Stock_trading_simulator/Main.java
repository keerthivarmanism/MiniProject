package Stock_trading_simulator;
import java.util.*;
public class Main {

	public static void main(String[] args) {
		System.out.println("======Welcome to My Trading system======");
		Scanner s=new Scanner(System.in);
		while(true)
		{
		System.out.println("Enter 1 to admin");
		System.out.println("Enter 2 to customer");
		System.out.println("Enter 3 to Exit the application");
		
		int ch=s.nextInt();
		
		if(ch==1)
		{
			Admin ad=new Admin();
		}
		else if(ch==2)
		{
			User us=new User();
		}
		else if(ch==3)
		{
			System.out.println("Thank you for visiting stock trading simulator");
			System.exit(0);
		}
		else
		{
			System.out.println("Please enter 1 or 2 or 3. Try again......");
		}
	}
	}
}
