package com.agfa.orme.gwt.server;

class RomanNumber {

    RomanNumber(final int arab) {
        this.arab = arab;
    }

    String print() {
        checkNumberIsNotZero();
        checkNumberIsNotOver4999();
        StringBuilder result = new StringBuilder();
        int temporary = this.arab;
        for (RomanNumberEquivalency equivalency : RomanNumberEquivalency.values()) {
            if (temporary >= equivalency.arab()) {
                int occurence = temporary / equivalency.arab();
                temporary -= occurence * equivalency.arab();
                for (int i = 0; i < occurence; i++) {
                    result.append(equivalency.roman());
                }
            }
        }
        return result.toString();
    }

    private void checkNumberIsNotOver4999() {
        if (arab > MAX_ROMAN_NUMBER) {
            throw new RomanNumberException("Numbers over 4999 " + explaination());
        }
    }

    private String explaination() {
        return "have no roman number equivalency (number given is '" + arab + "')";
    }

    private void checkNumberIsNotZero() {
        if (arab <= ZERO_VALUE) {
            throw new RomanNumberException("Numbers under 0 " + explaination());
        }
    }

    private final int arab;
    private static final int MAX_ROMAN_NUMBER = 4999;
    private static final int ZERO_VALUE = 0;
}
