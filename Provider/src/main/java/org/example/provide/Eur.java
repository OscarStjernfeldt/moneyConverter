package org.example.provide;

import org.example.convert.Converter;
import org.example.convert.CurrencyFullName;

@CurrencyFullName(currency = "European Euro")
public class Eur implements Converter {

    @Override
    public double convertMoney(int givenAmount) {
        return givenAmount / 9.76;
    }

    @Override
    public String currency() {
        return "EUR";
    }
}
