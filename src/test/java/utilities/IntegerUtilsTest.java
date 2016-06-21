package utilities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IntegerUtilsTest
{
	@Test
	public void test_integerToIntArray_PositiveInput_ExpectedResult() {
		int[] expected = { 5, 4, 3, 2, 1, 0 };
		int[] actual = IntegerUtils.integerToIntArray( 543210, false );
		
		assertEquals( expected.length, actual.length );
		
		for ( int i = 0 ; i < expected.length ; i++ ) {
			assertEquals( expected[i], actual[i] );
		}
	}
	
	@Test
	public void test_integerToIntArray_NegativeInput_ExpectedResult() {
		int[] expected = { 5, 4, 3, 2, 1, 0 };
		int[] actual = IntegerUtils.integerToIntArray( -543210, false );
		
		assertEquals( expected.length, actual.length );
		
		for ( int i = 0 ; i < expected.length ; i++ ) {
			assertEquals( expected[i], actual[i] );
		}
	}
	
	@Test
	public void test_integerToIntArray_PositiveInput_Reverse_ExpectedResult() {
		int[] expected = { 0, 1, 2, 3, 4, 5 };
		int[] actual = IntegerUtils.integerToIntArray( 543210, true );
		
		assertEquals( expected.length, actual.length );
		
		for ( int i = 0 ; i < expected.length ; i++ ) {
			assertEquals( expected[i], actual[i] );
		}
	}
	
	@Test
	public void test_integerToIntArray_NegativeInput_Reverse_ExpectedResult() {
		int[] expected = { 0, 1, 2, 3, 4, 5 };
		int[] actual = IntegerUtils.integerToIntArray( -543210, true );
		
		assertEquals( expected.length, actual.length );
		
		for ( int i = 0 ; i < expected.length ; i++ ) {
			assertEquals( expected[i], actual[i] );
		}
	}
	
	@Test
	public void test_integerToIntArray_NullInput_ThrowsException() {
		try {
			IntegerUtils.integerToIntArray( null, false );
			fail("Expected to catch NullPointerException");
		} catch ( NullPointerException npe ) {
			
		} catch ( Exception e ) {
			fail("Supposed to catch NullPointerException");
		}
	}
	
	@Test
	public void test_reverseIntArray_ValidInput_ExpectedResult() {
		int[] expected = { 0, 1, 2, 3, 4, 5 };
		int[] input = { 5, 4, 3, 2, 1, 0 };
		int[] actual = IntegerUtils.reverseIntArray( input );
		
		assertEquals( expected.length, actual.length );
		
		for ( int i = 0 ; i < expected.length ; i++ ) {
			assertEquals( expected[i], actual[i] );
		}
	}
	
	@Test
	public void test_reverseIntArray_NullInput_ThrowsException() {
		try {
			IntegerUtils.reverseIntArray( null );
			fail("Expected to catch NullPointer Exception");
		} catch ( NullPointerException npe ) {
			
		} catch ( Exception e ) {
			fail("Supposed to catch NullPointerException");
		}
		
	}
}
