package labs;

/**
 *  Fibonacci Sequence: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
 */
public class RecursionFibonacci {

	public static void main(String[] args) {

		displayFibonacci();

	}


	public static void displayFibonacci() {

		for ( int counter = 0; counter <= 10; counter++ ) {

			System.out.printf( "Fibonacci of %d is: %d\n", counter, 
				fibonacci( counter ) );

		}
	}


	public static long fibonacci( long number ) {

		// base case
		if ( ( number == 0 ) || ( number == 1 ) ) {

			return number;

		} else {
			// recursive call
			return fibonacci( number - 1 ) + fibonacci( number - 2 );

		}
	}

}