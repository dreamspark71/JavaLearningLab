package labs;


public class RecursionFactorial {
    

	public static void main(String[] args) {

		displayFactorials();

	}


	public static void displayFactorials() {

		// calculate the factorials for values 0 - 10
		for ( int i = 0; i <= 10; i++ ) {

			System.out.printf( "%d! = %d\n", i, factorial( i ) );

		}
	}

	// Recursive factoial method
	public static long factorial( long number ) {

		// base case
		if ( number <= 1 ) {
			
			return 1;	// base cases: 0! = 1 and 1! = 1

		} else {
			// recursive call
			return number * factorial( number - 1 );
		}
	}


} 