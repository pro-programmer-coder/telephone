package core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TelephoneTest {

    @Test
    public void correctNumberWithNoExtraSyntax(){
        String expected = "+16085551212";
        String actual;
        Telephone telephone = new Telephone(expected);

        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void correctNumberWithExtraSyntax(){
        String testInput = "+1 (608) 555 - 1212";
        String expected = "+16085551212";
        String actual;
        Telephone telephone = new Telephone(testInput);

        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void numberTooLong(){
        String testInput = "+1 (608) 555 - 12122";
        String expected = "invalid";
        String actual;
        Telephone telephone = new Telephone(testInput);

        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void numberTooShort(){
        String testInput = "+1 (608) 555 - 121";
        String expected = "invalid";
        String actual;
        Telephone telephone = new Telephone(testInput);

        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void incorrectPlusAtStart(){
        String testInput = "-1 (608) 555 - 121";
        String expected = "invalid";
        String actual;
        Telephone telephone = new Telephone(testInput);

        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void incorrectOneAtStart(){
        String testInput = "+3 (608) 555 - 121";
        String expected = "invalid";
        String actual;
        Telephone telephone = new Telephone(testInput);

        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void testValidNumberNPA(){
        String expected = "+1 NPA NAA 1234";
        String actual;
        Telephone telephone = new Telephone("+1-NPA-NAA-1234");
        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidNumberWrongAreaCode(){
        String expected = "invalid";
        String actual;
        Telephone telephone = new Telephone("+1-NPQ-NAA-1234");
        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidNumberWrongExchangeCode(){
        String expected = "invalid";
        String actual;
        Telephone telephone = new Telephone("+1-NPA-QA2-1234");
        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void testInvalidNumberLettersInSubNo(){
        String expected = "invalid";
        String actual;
        Telephone telephone = new Telephone("+1-NPA-NA2-1as4");
        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void testMissingAreaCode(){
        String expected = "invalid";
        String actual;
        Telephone telephone = new Telephone("+1-NA2-1as4");
        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void testMissingExchangeCode(){
        String expected = "invalid";
        String actual;
        Telephone telephone = new Telephone("+1-NPA-1as4");
        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void testMissingSubscriberCode(){
        String expected = "invalid";
        String actual;
        Telephone telephone = new Telephone("+1-NPA-NA2");
        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void testEmptyString(){
        String expected = "invalid";
        String actual;
        Telephone telephone = new Telephone("");
        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

    @Test
    public void secondAndThirdExchangeCodeTheSame(){
        String expected = "invalid";
        String actual;
        Telephone telephone = new Telephone("+1-NPA-Q11-1234");
        actual = telephone.getNumber();

        assertEquals(expected, actual);
    }

}