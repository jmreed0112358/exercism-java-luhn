package utilities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LongUtilsTest
{
	@Test
	public void test_longToIntArray_PositiveInput_ExpectedResult() {
		int[] expected = { 5, 4, 3, 2, 1, 0 };
		int[] actual = LongUtils.longToIntArray( 543210L, false );
		
		assertEquals( expected.length, actual.length );
		
		for ( int i = 0 ; i < expected.length ; i++ ) {
			assertEquals( expected[i], actual[i] );
		}
	}
	
	@Test
	public void test_longToIntArray_NegativeInput_ExpectedResult() {
		int[] expected = { 5, 4, 3, 2, 1, 0 };
		int[] actual = LongUtils.longToIntArray( 543210L, false );
		
		assertEquals( expected.length, actual.length );
		
		for ( int i = 0 ; i < expected.length ; i++ ) {
			assertEquals( expected[i], actual[i] );
		}
	}
	
	@Test
	public void test_longToIntArray_PositiveInput_Reverse_ExpectedResult() {
		int[] expected = { 0, 1, 2, 3, 4, 5 };
		int[] actual = LongUtils.longToIntArray( 543210L, false );
		
		assertEquals( expected.length, actual.length );
		
		for ( int i = 0 ; i < expected.length ; i++ ) {
			assertEquals( expected[i], actual[i] );
		}
	}
	
	@Test
	public void test_longToIntArray_NegativeInput_Reverse_ExpectedResult() {
		int[] expected = { 0, 1, 2, 3, 4, 5 };
		int[] actual = LongUtils.longToIntArray( 543210L, false );
		
		assertEquals( expected.length, actual.length );
		
		for ( int i = 0 ; i < expected.length ; i++ ) {
			assertEquals( expected[i], actual[i] );
		}
	}
	
	@Test
	public void test_longToIntArray_NullInput_ThrowsException() {
		try {
			LongUtils.longToIntArray( null, false );
			fail("Expected to catch NullPointerException");
		} catch ( NullPointerException npe ) {
			
		} catch ( Exception e ) {
			fail("Supposed to catch NullPointerException");
		}
	}
}
