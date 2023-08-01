package Stock_trading_simulator;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

	 public boolean iscorrect(String ch)
	 {
		 Pattern p=Pattern.compile("[a-zA-Z0-9.-_]*@[a-zA-z0-9]+(.[a-zA-z]+)+");
		 Matcher m=p.matcher(ch);
		 return m.matches();
	 }
	 public boolean iscorrect(String ch,int len)
	 {
		 int  count1=0,count2=0,count3=0;
		 for(int i=0;i<len;i++)
		 {
			 if(Character.isLetter(ch.charAt(i)))
			 {
				 count1++;
			 }
			 else if(Character.isDigit(ch.charAt(i)))
			 {
				 count2++;
			 }
			 else 
			 {
				 count3++;
			 }
		 }
		 if(len>=10&&count1>5 &&count2>2 && count3>0)
		 {
			 return true;
		 }
		 else
		 {
			 return false;
		 }
	 }
}
