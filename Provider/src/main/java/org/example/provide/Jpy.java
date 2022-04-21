package org.example.provide;

import org.example.convert.Converter;

public class Jpy implements Converter {

    @Override
    public double convertMoney(int givenAmount) {
        return givenAmount * 13.55;
    }

    @Override
    public String currency() {
        return "JPY";
    }
}
