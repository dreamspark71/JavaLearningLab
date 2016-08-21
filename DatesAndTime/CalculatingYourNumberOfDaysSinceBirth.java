package labs;

import java.io.Console;
import java.time.*;
import java.time.format.*;
import java.time.temporal.ChronoUnit;
import java.time.format.DateTimeParseException;

/*
  This class will take in your date of birth and then return you the
  number of days you are alive.
*/
class CalculatingYourNumberOfDaysSinceBirth {
	

	public static void main (String[] args) {

        System.out.println( "-----------------------------------------------------------" );
        System.out.println( "Welcome to the How Many Days Am I Alive application." );
        System.out.println( "-----------------------------------------------------------" );

        Console c = System.console();
        if ( c == null ) {
        	System.out.println( "There is no console available on this operating system." );
        }

        String enteredDOB = c.readLine( "Please enter your Date of Birth in the following format: dd/mm/yyyy or enter 'e' to exit %n" );
        if ( enteredDOB.charAt(0) == 'e'  ) {
            System.exit(0);
        }

        int numberOfDaysAlive = 0;
        
        do {

            numberOfDaysAlive = calculateDaysAlive( enteredDOB );
            if ( numberOfDaysAlive > 0 ) {
                System.out.printf( "You are alive %d days %n", + numberOfDaysAlive );
            }
            enteredDOB = c.readLine( "%nPlease enter your Date of Birth in the following format: dd/mm/yyyy or enter 'e' to exit %n" );

        } while ( enteredDOB.charAt(0) != 'e' );

	}


    private static int calculateDaysAlive( String startDate) {

        long days = 0l; // ChronoUnit between() returns long
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern( "dd/MM/yyyy" );

        try {

            LocalDate start = LocalDate.parse( startDate, dateFormat );
            LocalDate currentDate = LocalDate.now();
            days = ChronoUnit.DAYS.between( start, currentDate );
 
        } catch ( DateTimeParseException e ) {
            System.out.printf( "The date format you entered was incorrect %n %s ", e.getMessage());
        }
        return (int)days;
    }

}
