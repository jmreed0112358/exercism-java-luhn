package utilities;

import java.security.InvalidParameterException;

public class LongUtils
{
	public static int[] longToIntArray( Long input, boolean reverse ) {
		input = Math.abs( input );
		String digits = input.toString( );
		if (reverse) {
			digits = new StringBuilder(digits).reverse( ).toString( );
		}
		char[] digitArray = digits.toCharArray( );
		
		int[] result = new int[digitArray.length];
		for ( int i = 0 ; i < digitArray.length ; i++ ) {
			result[i] = Character.getNumericValue( digitArray[i] );
		}
		
		return result;
	}
	
	/**
	 * Takes a valid int array, and converts it to a long.
	 * Unit Tests: Complete.
	 * @param input
	 * @return
	 */
	public static long intArrayToLong( int[] input ) {
		if ( input == null ) {
			throw new NullPointerException();
		} else if ( input.length == 0 ) {
			throw new InvalidParameterException();
		}
		
		int[] inputReverse = new int[input.length];
		for ( int i = 0 ; i < input.length ; i++ ) {
			inputReverse[i] = input[input.length - 1 - i];
		}
		
		long result = 0;
		
		for ( int i = 0 ; i < inputReverse.length ; i++ ) {
			result += (long)(inputReverse[i] * Math.pow( 10, i ) );
		}
		return result;
	}
}
