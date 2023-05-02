package datetimestamp;

import java.util.Date;

public class Datetime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
			Date date = new Date();
			System.out.println(date);
			System.out.println(date.toString());
			String replacedDate = date.toString().replace(" ", "_");
			System.out.println(replacedDate);
			String FinalReplacedDate = replacedDate.replace(":", "_");
			System.out.println(FinalReplacedDate);
			
			System.out.println("hello");
		}


	}


