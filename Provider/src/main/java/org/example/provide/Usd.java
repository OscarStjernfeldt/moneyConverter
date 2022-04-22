package org.example.provide;

import org.example.convert.Converter;
import org.example.convert.CurrencyFullName;

@CurrencyFullName(currency = "US Dollars")
public class Usd implements Converter {

    @Override
    public double convertMoney(int givenAmount) {
        return givenAmount / 10.60;
    }

    @Override
    public String currency() {
        return "USD";
    }
}
