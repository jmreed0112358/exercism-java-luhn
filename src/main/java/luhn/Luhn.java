package luhn;

import java.security.InvalidParameterException;

import utilities.IntegerUtils;
import utilities.LongUtils;

public class Luhn
{
	private Integer number = 0;
	
	public Luhn( int number )
	{
		this.number = Math.abs( number );
	}

	/**
	 * Takes a long, and produces a long with a check digit appended.
	 * @param input
	 * @return A long with a valid check digit.
	 */
	public static long create( long input ) {
		int[] temp = LongUtils.longToIntArray( input, false );
		int[] digitArray = new int[ temp.length + 1 ];
		for ( int i = 0 ; i < temp.length ; i++ ) {
			digitArray[i] = temp[i];
		}
		digitArray[digitArray.length - 1] = 0;
		
		int[] addends = getAddends(digitArray);
		int sum = 0;
		for ( int i = 0 ; i < addends.length ; i++ ) {
			sum += addends[i];
		}
		
		digitArray[digitArray.length - 1] = getCorrectCheckDigit(sum);
		
		return LongUtils.intArrayToLong( digitArray );
	}
	
	/**
	 * Given a sum, return the correct check digit.
	 * @param sum
	 * @return
	 */
	public static int getCorrectCheckDigit( int sum ) {
		if ( sum < 0 ) {
			throw new InvalidParameterException();
		} else if ( sum < 10 ) {
			return 10 - sum;
		} else if ( sum % 10 == 0 ) {
			return 0;
		} else {
			return 10 - (sum % 10);
		}
	}
	
	/**
	 * Given an valid int array, produce an int array representing the addends according to Luhn rules.
	 * Unit Tests: Complete.
	 * @param input
	 * @return
	 */
	public static int[] getAddends( int[] input ) {
		if ( input == null ) {
			throw new NullPointerException();
		} else if ( input.length == 0 ) {
			throw new InvalidParameterException();
		} else if ( !IntegerUtils.isIntArrayValid( input ) ) {
			throw new InvalidParameterException();
		}

		input = IntegerUtils.reverseIntArray( input );
		
		for ( int i = 0 ; i < input.length ; i++ ) {
			if ( (i + 1) % 2 == 0 ) {
				input[i] = input[i] * 2;
				if ( input[i] >= 10 ) {
					input[i] -= 9;
				}
			}
		}
		
		return IntegerUtils.reverseIntArray( input );
	}
	
	/**
	 * Given an integer, produce an array of integers representing the addends.
	 * Going from right to left, doubles every second integer.  
	 * If the result is greater than 10, subtract 9.
	 * e.g. 1212 -> {1,4,1,4}
	 * 
	 * @return
	 */
	public int[] getAddends( ) {
		int[] digitArray = IntegerUtils.integerToIntArray( this.number, true );
		for ( int i = 0 ; i < digitArray.length ; i++ ) {
			if ( (i + 1) % 2 == 0 ) {
				digitArray[i] = digitArray[i] * 2;
				if ( digitArray[i] >= 10 ) {
					digitArray[i] -= 9;
				}
			}
		}
		
		return IntegerUtils.reverseIntArray( digitArray );
	}
	
	/**
	 * Pulls the checksum from the given integer.
	 * @return
	 */
	public int getCheckDigit( ) {
		String numberString = this.number.toString( );
		return Character.getNumericValue( numberString.charAt( numberString.length( ) - 1 ) );
	}
	
	/**
	 * Given an integer, give the checksum
	 * @return
	 */
	public int getCheckSum( ) {
		int[] digitArray = this.getAddends( );
		int result = 0;
		for ( int i = 0 ; i < digitArray.length ; i++ ) {
			result += digitArray[i];
		}
		
		return result;
	}
	
	/**
	 * Is a given integer a valid luhn number?
	 * @return
	 */
	public boolean isValid( ) {
		return ( this.getCheckSum() % 10 == 0 );
	}
}
