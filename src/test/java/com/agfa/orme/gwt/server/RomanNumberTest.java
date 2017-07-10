package com.agfa.orme.gwt.server;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

public class RomanNumberTest {

    @Test
    public void canPrintRomanNumberFromArabNumber() {
        assertThat(new RomanNumber(1).print()).isEqualTo("I");
        assertThat(new RomanNumber(2).print()).isEqualTo("II");
        assertThat(new RomanNumber(3).print()).isEqualTo("III");
        assertThat(new RomanNumber(4).print()).isEqualTo("IV");
        assertThat(new RomanNumber(5).print()).isEqualTo("V");
        assertThat(new RomanNumber(6).print()).isEqualTo("VI");
        assertThat(new RomanNumber(9).print()).isEqualTo("IX");
        assertThat(new RomanNumber(10).print()).isEqualTo("X");
        assertThat(new RomanNumber(11).print()).isEqualTo("XI");
        assertThat(new RomanNumber(14).print()).isEqualTo("XIV");
        assertThat(new RomanNumber(15).print()).isEqualTo("XV");
        assertThat(new RomanNumber(20).print()).isEqualTo("XX");
        assertThat(new RomanNumber(40).print()).isEqualTo("XL");
        assertThat(new RomanNumber(50).print()).isEqualTo("L");
        assertThat(new RomanNumber(90).print()).isEqualTo("XC");
        assertThat(new RomanNumber(100).print()).isEqualTo("C");
        assertThat(new RomanNumber(400).print()).isEqualTo("CD");
        assertThat(new RomanNumber(500).print()).isEqualTo("D");
        assertThat(new RomanNumber(900).print()).isEqualTo("CM");
        assertThat(new RomanNumber(1000).print()).isEqualTo("M");
        assertThat(new RomanNumber(1287).print()).isEqualTo("MCCLXXXVII");
    }

    @Test
    public void canPrintTheMostLongNumber() {
        assertThat(new RomanNumber(4888).print()).isEqualTo("MMMMDCCCLXXXVIII");
    }

    @Test
    public void negativeIsNotARomanNumber() {
        try {
            new RomanNumber(-1).print();
            failBecauseExceptionWasNotThrown(RomanNumberException.class);
        }catch (RomanNumberException e) {
            assertThat(e.getMessage()).isEqualTo("Numbers under 0 have no roman number equivalency (number given is '-1')");
        }
    }

    @Test
    public void numberOver4999HasNoRomanNumberEquivalency() {
        try {
            new RomanNumber(5000).print();
            failBecauseExceptionWasNotThrown(RomanNumberException.class);
        }catch (RomanNumberException e) {
            assertThat(e.getMessage()).isEqualTo("Numbers over 4999 have no roman number equivalency (number given is '5000')");
        }
    }
}