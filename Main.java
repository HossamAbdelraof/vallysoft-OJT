package ara_numbers;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;


public class Main {
	static HashMap<Character, String> group0 = new HashMap<Character, String>();
	static HashMap<Character, String> hundreds = new HashMap<Character, String>();
	static HashMap<Character, String> mills = new HashMap<Character, String>();
	static HashMap<Character, String> thuand = new HashMap<Character, String>();
	static HashMap<Character, String> ones = new HashMap<Character, String>();
	static HashMap<Character, String> S_ones = new HashMap<Character, String>();
	static HashMap<Character, String> tens = new HashMap<Character, String>();
	static HashMap<Character, String> general2 = new HashMap<Character, String>();
	
	public static void main(String[] args) {
		

	    
	    hundreds.put('0', "");
	    hundreds.put('1', "مائة");
	    hundreds.put('2', "مائتان");
	    hundreds.put('3', "ثلاثمائة");
	    hundreds.put('4', "أربعمائة");
	    hundreds.put('5', "خمسمائة");
	    hundreds.put('6', "ستمائة");
	    hundreds.put('7', "سبعمائة");
	    hundreds.put('8', "ثمانمائة");
	    hundreds.put('9', "تسعمائة");

	    
	    thuand.put('0', "");
	    thuand.put('1', "ألف");
	    thuand.put('2', "ألفين");
	    
	    mills.put('0', "");
	    mills.put('1', "مليون");
	    mills.put('2', "مليونان");
	    
	    ones.put('0', "");
	    ones.put('1', "واحد");
	    ones.put('2', "إثنان");
	    ones.put('3', "ثلاثة");
	    ones.put('4', "اربعة");
	    ones.put('5', "خمسة");
	    ones.put('6', "ستة");
	    ones.put('7', "سبعة");
	    ones.put('8', "ثمانية");
	    ones.put('9', "تسعة");
	    S_ones.put('1', "إحدى عشر");
	    S_ones.put('2', "إثناعشر");

	    tens.put('1', "عشرة");
	    tens.put('2', "عشرون");
	    tens.put('3', "ثلاثون");
	    tens.put('4', "اربعون");
	    tens.put('5', "خمسون");
	    tens.put('6', "ستون");
	    tens.put('7', "سبعون");
	    tens.put('8', "ثمانون");
	    tens.put('9', "تسعون");
	    	    	    
	    String str_cash = "555555";
	    
	    System.out.println("Cash is: " + str_cash);
	    int str_len =  (str_cash.length()%3);
	    int str_correcr = 3 - str_len;
	   
		
	

		if ( str_correcr != 3) {
			for (int i = 0; i < str_correcr; i++) {
				str_cash = "0" + str_cash;
			}
		}
		
		
		

		int grop_count = (str_cash.length()/3); // number of groups i have

		

		
		// split the groups i have
		String groups[] = new String[grop_count];
		
		for (int i = 0; i < grop_count; i+=1) {
			int j = i*3;
			groups[grop_count-i-1] = str_cash.substring(j, j+3);
			
		}
		
		
		// str_cash >> cash i have
		// grop_count >> n of groups
		// groups >> the groups of number i have 0:onse, 1:thousands, 2:millions 
	
		String message = "";
		
		for (int i = grop_count-1; i >=0 ; i--) {
			message = convert(message, groups[i], i);
		}
		System.out.println(message);
		

		System.out.println("hi, from code");
	}
	
	

	
public static String convert(String message, String cash, int group) {
	String finaal = "";
	
	switch (group){
	
	case 0:
		
		if (Integer.parseInt(cash.substring(1)) == 10) {
			finaal = "جنيهات";

		}else {
			finaal = "جنيها";
		}
		break;
		
	case 1:
		finaal = "ألف";
		if (Integer.parseInt(cash.substring(1)) == 10) {
			finaal = "الاف";

		}else {
			finaal = "الف";
		}
		break;
	case 2:
		finaal = "ملايين";
		break;
	
	}
	
	
	if ((message.length() > 1) && (Integer.parseInt(cash) > 0)) {
		message += " و";
	}

	if (Integer.parseInt(cash.substring(0, 1)) > 0) {
		message += hundreds.get(cash.charAt(0));

		if (Integer.parseInt(cash.substring(1)) > 0) {
			message += " و";

		}
	}
	

	
	//////////////////////////////////////////
	
	// check special 
	boolean special = false;
	switch (Integer.parseInt(cash.substring(1))) {
	case 10:
		message += tens.get(cash.charAt(1));
		message += " " + finaal;
		special = true;
		break;
	case 11:
		message += S_ones.get(cash.charAt(2));
		message += " " + finaal;
		special = true;

		break;
	case 12:
		message += S_ones.get(cash.charAt(2));
		message += " " + finaal;
		special = true;

		break;	
	case 1:
		if (group ==1) {
			message += thuand.get(cash.charAt(2));
			special = true;
		}else if (group ==2) {
			message += mills.get(cash.charAt(2));
			special = true;
		}
		
		break;
	case 2:
		if (group ==1) {
			message += thuand.get(cash.charAt(2));
			special = true;
		}else if (group ==2) {
			message += mills.get(cash.charAt(2));
			special = true;
		}
		break;
	}
	

	if (!special) {
		if (Integer.parseInt(cash.substring(2)) > 0) {

			message += ones.get(cash.charAt(2));
			
			if (Integer.parseInt(cash.substring(1)) > 10) {
				message += " و";
			}
			
		}

		///////////////////////////////////////////////////
		if (Integer.valueOf(cash.charAt(1)) -48 > 0)  {
			
		//	System.out.println(cash.charAt(1));
			message += tens.get(cash.charAt(1));
		}
		
		message += " " + finaal;
		
	}
	//System.out.println(message);
	return message;
}


}
