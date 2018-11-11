/*
* University of Central Florida
* COP3330 - Fall 2018
* Author: Luis Vargas 
*/
public class Euclid {

	public static void GCD (int a, int b)
	{
		// Declaration and initialization of variables.
		int q , r = 1, temp1 = 0, temp2 = 1; 
		int finalA = a, finalB = b;
	
	
		while ( b != 0) 
		{
			// q is finding the quotient using division, r is finding the remainder using modulus.
			q = a / b;
			r = a % b;
			
			// This prints out intermediate steps
			System.out.println( a + " = " + q + " ( " + b + " ) + " + r);
			
			// This is re-setting the values to one another in order to proceed through the
			// process of going through all the possible values for the Euclidean Algorithm.
			temp1 = b;
			b = r;
			a = temp1; 
			temp2 = temp1;
		}
		
		// This prints out the final result of what the GCD is of the two positive integers.
		System.out.println("\n==> gcd( " + finalA + ", " + finalB + " ) = " + temp2);
	}
	
	   

	public static void main ( String[] args )
	{
	    int a, b;
	    
	    // Initialization of variables to command line arguments.
	    a = Integer.valueOf(args[0]);
	    b = Integer.valueOf(args[1]);
	    
	    // Formatting requirements
	    System.out.println( "\n=============================================\n");
	    System.out.println("Euclid's Algorithm by Luis Vargas:\n");
	    System.out.println("Inputs: " + a + ", " + b +"\n");
	    
	    // Calling function to calculate the GCD of the two positive integers input.
	    GCD(a, b);
	}
}
