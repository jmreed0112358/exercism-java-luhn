package utilities;

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
	
	/**
	 * A valid integer array is one where each element in the array is a positive integer in the interval [0, 9].
	 * Unit Tests: Complete.
	 * @param input
	 * @return
	 */
	public static boolean isIntArrayValid( int[] input ) {
		if ( input == null ) {
			throw new NullPointerException();
		} else if ( input.length == 0 ) {
			return false;
		}
		
		for ( int i = 0 ; i < input.length ; i++ ) {
			if ( input[i] >= 10 ) {
				return false;
			}
		}
		return true;
	}
}
