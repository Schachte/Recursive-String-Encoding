/*
 * Ryan Schachte
 * Recursive Function Programming
 * Description: This will take a users string and decode/encode the string
 * Obviously basic encoding, but used to test powers of recursion
 */
import java.util.*;

public class RecursiveStringEncoding
{
private static String newChoice;
private static String decodedString;
	public static void main (String[]args)
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Enter String: ");
		String option = input.nextLine();
		newChoice = "";
		decodedString = "";

		boolean loop = true;
		while (loop == true)
		{
			System.out.println("");
			System.out.println("Would you like to:");
			System.out.println("A: Encode a string");
			System.out.println("B: Decode a string");
			System.out.println("C: Exit the program");
			System.out.println("D: Reset value of initial input string.");
			
			String choice = input.nextLine();
			if (choice.equalsIgnoreCase("A"))
			{
				System.out.println("You initial string was " + option + " but is now encoded to read: ");
				option = stringEncode(option, 1,1);
				System.out.println(option);
			}
			else if (choice.equalsIgnoreCase("B"))
			{
				System.out.println("The initial encoded string was " + option + " but is now decoded to read: ");
				option = stringDecode(option, 0,1);
				System.out.println(option);
				
			}
			else if (choice.equalsIgnoreCase("C"))
				break;
			else if(choice.equals("D"))
			{
				System.out.print("Please enter a string to change the value of option to: ");
				String temp = option;
				option = input.nextLine();
				System.out.println("Your word was initially " + temp + " but is now changed to " + option);
			}
			else
				System.out.println("Error");
		}

	}
	
	public static String stringDecode(String userString, int start, int end)
	{
		
		if (end <= userString.length())
		{
			decodedString += userString.substring(start, end);
			start = start+2;
			end   = end+2;
			return stringDecode(userString, start, end);
		}
		
		return decodedString;
	}
	
	public static String stringEncode(String userString, int start, int start2)
	{
		
		
		if (start2 < userString.length())
		{
			if (newChoice.length()==0)
			{
				newChoice = userString.subSequence(0, start) + "x" + userString.substring(start2, userString.length());
				start = start+2;
				start2++;
				return stringEncode(userString, start, start2);
				
			}
			else if(newChoice.length()!=0)
			{
				newChoice = newChoice.substring(0,start) + "x" + userString.substring(start2,userString.length());
				start = start+2;
				start2++;
				return stringEncode(userString, start, start2);
			}

		}
		
		return newChoice;
	}

}
