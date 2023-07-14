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
		
			String name;
			String pas;
			boolean approval;
			
		  Scanner sc=new Scanner(System.in);  
		  
	       
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
                    + " \n\n \t \t \t \t\t 1-To log in, enter a word, (go)"
                    + ANSI_RESET);
	        System.out.println( ANSI_bule
                    + "  \t \t \t \t \t 2-Exit the program, enter the word (bye)"
                    + ANSI_RESET);
	        
	       
	        String str= sc.nextLine();  
	        if (str.equals("bye")) {
	        	 System.exit(0);
	        	 
	        }
	        else if (str.equals("go")) {
	        	
	        	System.out.printf("enter your name :");
	        	name= sc.nextLine();
	        	System.out.printf("enter your pasword: ");
	        	pas= sc.nextLine();
	        	
	        	
	        	Login log =new Login();
	        	
	        	
	        	
//	        	for (Pair element :personList) {
//	        		if (name.equals(element.getName())) {
//	        			for (Pair element1 :personList) {
//	    	        		if (pas.equals(element1.getpassword())) {
//	    	        			
//	    	        			if(element1.gettype().equals("Administrator")) {
//	    	        				
//	    	        				
//	    	        				
//	    	        			}
//	    	        			else if(element1.gettype().equals("owners")) {
//	    	        				
//	    	        			}
//	    	        			else if(element1.gettype().equals("tenants")) {
//	    	        				
//	    	        			}
//	    	        			
//	    	        			
//	    	        		}
//	    	            }
//	        		}
//	            }
	        	
	        	
	        	
	        	
	        	
	        	
	        	
	        }
	        

	       
	}

}
