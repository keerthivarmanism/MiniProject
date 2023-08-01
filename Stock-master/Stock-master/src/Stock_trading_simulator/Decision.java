package Stock_trading_simulator;

import java.util.*;

public class Decision {

	private String email;
	Decision(String email)
	{
		this.email=email;
		Scanner s=new Scanner(System.in);
		System.out.println("Enter 1 to buy the stock");
		System.out.println("Enter 2 to sell the stock");
		System.out.println("Enter 3 to check your info");
		int ch=s.nextInt();
		if(ch==1)
		{
			Buy by=new Buy(email);
		}
		else if(ch==2)
		{
			Sell sel=new Sell(email);
		}
		else if(ch==3)
		{
			Checker ck=new Checker(email);
			ck.check();
		}
		else
		{
			System.out.println("Enter the valid number");
		}
	}
}
