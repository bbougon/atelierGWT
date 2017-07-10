package com.agfa.orme.gwt.server;

public enum RomanNumberEquivalency {
    Thousand(1000, "M"), NineHundred(900, "CM"), FiveHundred(500, "D"), FourHundred(400, "CD"), Hundred(100, "C"), Ninety(90, "XC"), Fifty(50, "L"), Fourty(40, "XL") ,Ten(10, "X"), Nine(9, "IX"), Five(5, "V"), Four(4, "IV"), One(1, "I");

    RomanNumberEquivalency(final int arab, final String roman) {
        this.arab = arab;
        this.roman = roman;
    }

    public int arab() {
        return arab;
    }

    public String roman() {
        return roman;
    }

    private final int arab;
    private final String roman;
}
