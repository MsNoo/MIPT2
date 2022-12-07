package com.example.mipt2;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.mipt2.calc.Utils;

public class UnitTest {

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



}