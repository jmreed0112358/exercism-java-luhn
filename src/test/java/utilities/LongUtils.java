package utilities;

import exceptions.NotImplementedException;

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
}
