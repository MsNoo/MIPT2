package com.example.mipt2;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.mipt2.calc.Utils;

public class UnitTest {

    //---removeExcessiveSpacesFromString---
    //null
    @Test(expected = NullPointerException.class)
    public void Given_NullString_When_removeExcessiveSpacesFromStringIsCalled_Then_NullPointerExceptionIsThrown(){
        Utils.removeExcessiveSpacesFromString(null);
    }

    //empty string
    @Test
    public void Given_EmptyString_When_removeExcessiveSpacesFromStringIsCalled_Then_ReturnedEmptyString(){
        final String givenString = "";
        final String expectedResult = "";
        final String actualResult = Utils.removeExcessiveSpacesFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //string with multiple spaces
    @Test
    public void Given_StringOfMultipleEmptySpaces_When_removeExcessiveSpacesFromStringIsCalled_Then_ReturnedEmptyString(){
        final String givenString = "   ";
        final String expectedResult = "";
        final String actualResult = Utils.removeExcessiveSpacesFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //text with multiple spaces
    @Test
    public void Given_TextString_When_removeExcessiveSpacesFromStringIsCalled_Then_StringWithoutExcessiveSpacesIsReturned(){
        final String givenString = "Poetry   of  logical ideas  ";
        final String expectedResult = "Poetry of logical ideas";
        final String actualResult = Utils.removeExcessiveSpacesFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //---removeNumbersFromString---
    //null
    @Test(expected = NullPointerException.class)
    public void Given_NullString_When_removeNumbersFromStringIsCalled_Then_NullPointerExceptionIsThrown(){
        Utils.removeNumbersFromString(null);
    }

    //empty string
    @Test
    public void Given_EmptyString_When_removeNumbersFromStringIsCalled_Then_ReturnedEmptyString(){
        final String givenString = "";
        final String expectedResult = "";
        final String actualResult = Utils.removeNumbersFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //string with letters only
    @Test
    public void Given_String_When_removeNumbersFromStringIsCalledWithLettersOnly_Then_ReturnedInitialString(){
        final String givenString = "xyz";
        final String expectedResult = "xyz";
        final String actualResult = Utils.removeNumbersFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //string with letters and numbers
    @Test
    public void Given_String_When_removeNumbersFromStringIsCalledWithLettersAndNumbers_Then_ReturnedStringWithLettersOnly(){
        final String givenString = "x2y3z";
        final String expectedResult = "xyz";
        final String actualResult = Utils.removeNumbersFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //string with numbers only
    @Test
    public void Given_String_When_removeNumbersFromStringIsCalledWithNumbersOnly_Then_ReturnedEmptyString(){
        final String givenString = "234";
        final String expectedResult = "";
        final String actualResult = Utils.removeNumbersFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }


    //---removeLettersFromString---
    //null
    @Test(expected = NullPointerException.class)
    public void Given_NullString_When_removeLettersFromStringIsCalled_Then_NullPointerExceptionIsThrown(){
        Utils.removeLettersFromString(null);
    }

    //empty string
    @Test
    public void Given_EmptyString_When_removeLettersFromStringIsCalled_Then_ReturnedEmptyString(){
        final String givenString = "";
        final String expectedResult = "";
        final String actualResult = Utils.removeLettersFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

    //string with letters only
    @Test
    public void Given_String_When_removeLettersFromStringIsCalledWithLettersOnly_Then_ReturnedEmptyString(){
        final String givenString = "abc";
        final String expectedResult = "";
        final String actualResult = Utils.removeLettersFromString(givenString);

        assertEquals(expectedResult, actualResult);
    }

}