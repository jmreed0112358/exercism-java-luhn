package luhn;

import java.util.ArrayList;
import java.util.List;

import exceptions.NotImplementedException;
import utilities.IntegerUtils;

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
		throw new NotImplementedException();
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
		throw new NotImplementedException();
	}
	
	/**
	 * Is a given integer a valid luhn number?
	 * @return
	 */
	public boolean isValid( ) {
		throw new NotImplementedException();
	}
}
