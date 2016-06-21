package luhn;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.security.InvalidParameterException;

public class LuhnTest {

	@Test
	public void test_getCorrectCheckDigit_ValidInput_LessThanTen_ExpectedResult() {
		int input = 6;
		int expected = 4;
		
		assertEquals( expected, Luhn.getCorrectCheckDigit( input ) );
	}
	
	@Test
	public void test_getCorrectCheckDigit_ValidInput_GreaterThanTen_ExpectedResult() {
		int input = 33;
		int expected = 7;
		
		assertEquals( expected, Luhn.getCorrectCheckDigit( input ) );
	}
	
	@Test
	public void test_getCorrectCheckDigit_NegativeInput_ThrowsException() {
		try {
			Luhn.getCorrectCheckDigit( -10 );
			fail("Expected to catch InvalidParameterException");
		} catch ( InvalidParameterException ipe ) {
			
		} catch ( Exception e ) {
			fail("Supposed to catch InvalidParameterException");
		}
	}
	
	@Test
	public void test_getAddends_ClassFunction_ValidInput_ReturnsValidArray() {
		int[] input = { 1,2,1,2,1 };
		int[] expected = { 1, 4, 1, 4, 1 };
		int[] actual = Luhn.getAddends( input );
		
		assertEquals( expected.length, actual.length );
		
		for ( int i = 0 ; i < expected.length ; i++ ) {
			assertEquals( expected[i], actual[i] );
		}
	}
	
	@Test
	public void test_getAddends_ClassFunction_ValidInputSubtracts9_ReturnsValidArray() {
		int[] input = { 1, 8, 1, 8, 1 };
		int[] expected = { 1, 7, 1, 7, 1 };
		int[] actual = Luhn.getAddends( input );
		
		assertEquals( expected.length, actual.length );
		
		for ( int i = 0 ; i < expected.length ; i++ ) {
			assertEquals( expected[i], actual[i] );
		}
	}
	
	@Test
	public void test_getAddends_ClassFunction_InvalidInput_ThrowsException() {
		try {
			int[] input = { 10, 10, 10, 10 };
			Luhn.getAddends( input );
			fail("Expected to catch InvalidParameterException");
		} catch ( InvalidParameterException ipe ) {
			
		} catch ( Exception e ) {
			fail("Supposed to catch InvalidParameterException");
		}
	}
	
	@Test
	public void test_getAddends_ClassFunction_EmptyInput_ThrowsException() {
		try {
			int[] input = { };
			Luhn.getAddends( input );
			fail("Expected to catch InvalidParameterException");
		} catch ( InvalidParameterException ipe ) {
			
		} catch ( Exception e ) {
			fail("Supposed to catch InvalidParameterException");
		}
	}
	
	@Test
	public void test_getAddends_ClassFunction_NullInput_ThrowsException() {
		try {
			Luhn.getAddends( null );
			fail("Expected to catch NullPointerException");
		} catch ( NullPointerException npe ) {
			
		} catch ( Exception e ) {
			fail("Supposed to catch NullPointerException");
		}
	}
	
    @Test
    public void checkDigitIsRightMostDigit() {
        Luhn luhn = new Luhn(34567);
        int expectedOutput = 7;

        assertEquals(expectedOutput, luhn.getCheckDigit());
    }

    @Test 
    public void checkDigitIsRightMostDigit_NegativeInput() {
    	Luhn luhn = new Luhn(-34567);
        int expectedOutput = 7;

        assertEquals(expectedOutput, luhn.getCheckDigit());
    }
    
    @Test
    public void addendsDoublesEveryOtherNumberFromRight() {
        Luhn luhn = new Luhn(12121);
        int[] expectedOutput = new int[]{1, 4, 1, 4, 1};

        assertArrayEquals(expectedOutput, luhn.getAddends());
    }

    @Test
    public void addendsSubtracts9WhenDoubledNumberIsMoreThan9() {
        Luhn luhn = new Luhn(8631);
        int[] expectedOutput = new int[]{7, 6, 6, 1};

        assertArrayEquals(expectedOutput, luhn.getAddends());
    }
    
    @Test
    public void checkSumAddsAddendsTogether1() {
        Luhn luhn = new Luhn(4913);
        int expectedOutput = 22;

        assertEquals(expectedOutput, luhn.getCheckSum());
    }

    @Test
    public void checkSumAddsAddendsTogether2() {
        Luhn luhn = new Luhn(201773);
        int expectedOutput = 21;

        assertEquals(expectedOutput, luhn.getCheckSum());
    }

    @Test
    public void numberIsValidWhenChecksumMod10IsZero1() {
        Luhn luhn = new Luhn(738);
        boolean expectedOutput = false;

        assertEquals(expectedOutput, luhn.isValid());
    }

    @Test
    public void numberIsValidWhenChecksumMod10IsZero2() {
        Luhn luhn = new Luhn(8739567);
        boolean expectedOutput = true;

        assertEquals(expectedOutput, luhn.isValid());
    }

    @Test
    public void luhnCanCreateSimpleNumbersWithValidCheckDigit_NegativeInput() {
        long expectedOutput = 1230;

        assertEquals(expectedOutput, Luhn.create(123));
    }
    
    @Test
    public void luhnCanCreateSimpleNumbersWithValidCheckDigit() {
        long expectedOutput = 1230;

        assertEquals(expectedOutput, Luhn.create(123));
    }

    @Test
    public void luhnCanCreateLargeNumbersWithValidCheckDigit() {
        long expectedOutput = 8739567;

        assertEquals(expectedOutput, Luhn.create(873956));
    }

    @Test
    public void luhnCanCreateHugeNumbersWithValidCheckDigit() {
        long expectedOutput = 8372637564L;

        assertEquals(expectedOutput, Luhn.create(837263756));
    }
}
