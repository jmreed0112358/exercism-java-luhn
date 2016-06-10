package utilities;

import exceptions.NotImplementedException;

public class IntegerUtils
{
	public static int[] integerToIntArray( Integer input, boolean reverse ) {
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
	
	public static int[] reverseIntArray( int[] input ) {
		int[] result = new int[ input.length ];
		for ( int i = 0 ; i < input.length ; i++ ) {
			result[ result.length - i - 1 ] = input[ i ];
		}
		
		return result;
	}
}
