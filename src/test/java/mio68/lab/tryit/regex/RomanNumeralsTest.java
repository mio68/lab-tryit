package mio68.lab.tryit.regex;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RomanNumeralsTest {

    @Test
    public void whenCorrectRomanNumeral_thanTrue() {
        assertAll("valid Roman numerals",
                () -> assertTrue(RomanNumerals.isValidRomanNumeral("VI"),"VI"),
                () -> assertTrue(RomanNumerals.isValidRomanNumeral("IV"), "IV"),
                () -> assertTrue(RomanNumerals.isValidRomanNumeral("XL"), "XL"),
                () -> assertTrue(RomanNumerals.isValidRomanNumeral("XXI"), "XXI"),
                () -> assertTrue(RomanNumerals.isValidRomanNumeral("CCLXXXIII"), "CCLXXXIII"),
                () -> assertTrue(RomanNumerals.isValidRomanNumeral("MMMCMXCIX"), "MMMCMXCIX")
                );
    }

}