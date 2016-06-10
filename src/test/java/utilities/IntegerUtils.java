package utilities;

import exceptions.NotImplementedException;

public class IntegerUtils
{
	public static int[] integerToIntArray(Integer input) {
		input = Math.abs( input );
		String digits = input.toString( );
		char[] digitArray = digits.toCharArray( );
		
		int[] result = new int[digitArray.length];
		for ( int i = 0 ; i < digitArray.length ; i++ ) {
			result[i] = Character.getNumericValue( digitArray[i] );
		}
		
		return result;
	}
}
