package org.example.provide;

import org.example.convert.Converter;
import org.example.convert.CurrencyFullName;

@CurrencyFullName(currency = "British Pounds")
public class Gbp implements Converter {

    @Override
    public double convertMoney(int givenAmount) {
        return givenAmount / 8.12;
    }

    @Override
    public String currency() {
        return "GBP";
    }
}
