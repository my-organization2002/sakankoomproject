package mahsami1;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
	
	public static final String ANSI_RESET = "\u001B[0m";
	  
    // Declaring the color
    // Custom declaration
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RESET1 = "\u001B[0m";
	  
    // Declaring the color
    // Custom declaration
    public static final String ANSI_bule = "\u001B[36m";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		  Scanner sc=new Scanner(System.in);  
		  ArrayList<Pair> personList = new ArrayList<>();

	        // Instantiate Person objects
		  Pair person1 = new Pair("ali","123","Administrator");
		  Pair person2 = new Pair("mahmoud", "m1234","owners");
		  Pair person3 = new Pair("sami", "f12345","tenants");
	        // Add Person objects to the ArrayList
	        personList.add(person1);
	        personList.add(person2);
	        personList.add(person3);
	        System.out.println(ANSI_YELLOW
                    + "\t \t \t \t \t \t  Welcome to the Skanati program"
                    + ANSI_RESET);
	        
	        System.out.println( ANSI_bule
                    + "  \t \t Is an application to manage the booking process and rent electronically and sell used furniture"
                    + ANSI_RESET);
	        System.out.println( ANSI_bule
                    + "  ________________________________________________________________________________________________________________"
                    + ANSI_RESET);
	        
	        System.out.println( ANSI_bule
                    + " \n\n \t \t \t \t\t 1-To log in, enter a word, (let's go)"
                    + ANSI_RESET);
	        System.out.println( ANSI_bule
                    + "  \t \t \t \t \t 2-Exit the program, enter the word (bye)"
                    + ANSI_RESET);
	        
	       
	        String str= sc.nextLine();  
	        if (str.equals("bye")) {
	        	 System.exit(0);
	        	 
	        }
	        

	       
	}

}
