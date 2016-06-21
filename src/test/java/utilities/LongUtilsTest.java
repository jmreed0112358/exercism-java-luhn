package utilities;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

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
		int[] actual = LongUtils.longToIntArray( 543210L, true );
		
		assertEquals( expected.length, actual.length );
		
		for ( int i = 0 ; i < expected.length ; i++ ) {
			assertEquals( expected[i], actual[i] );
		}
	}
	
	@Test
	public void test_longToIntArray_NegativeInput_Reverse_ExpectedResult() {
		int[] expected = { 0, 1, 2, 3, 4, 5 };
		int[] actual = LongUtils.longToIntArray( 543210L, true );
		
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
	
	@Test
	public void test_intArrayToLong_ValidInput_ExpectedResult() {
		int[] input = { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		long expected = 100000000000L;
		long actual = LongUtils.intArrayToLong( input );
		
		assertEquals( expected, actual );
	}
	
	@Test
	public void test_intArrayToLong_EmptyInput_ThrowsException() {
		try {
			int[] input = { };
			LongUtils.intArrayToLong( input );
			fail("Expected to catch InvalidParameterException");
		} catch ( InvalidParameterException ipe ) {
			
		} catch ( Exception e ) {
			fail("Supposed to catch InvalidParameterException");
		}
	}
	
	@Test
	public void test_intArrayToLong_NullInput_ThrowsException() {
		try {
			LongUtils.intArrayToLong( null );
			fail("Expected to catch NullPointerException");
		} catch ( NullPointerException npe ) {
			
		} catch ( Exception e ) {
			fail("Supposed to catch NullPointerException");
		}
	}
}
