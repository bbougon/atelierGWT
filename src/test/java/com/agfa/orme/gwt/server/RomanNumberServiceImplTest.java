package com.agfa.orme.gwt.server;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RomanNumberServiceImplTest {

    @Test
    public void canPrintRomanNumber() {
        String romanNumber = new RomanNumberServiceImpl().getRomanNumber(34);

        assertThat(romanNumber).isEqualTo("XXXIV");
    }

}