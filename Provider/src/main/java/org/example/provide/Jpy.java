package org.example.provide;

import org.example.convert.Converter;
import org.example.convert.CurrencyFullName;

@CurrencyFullName(currency = "Japanese Yen")
public class Jpy implements Converter {

    @Override
    public double convertMoney(float givenAmount) {
        return givenAmount * 13.55;
    }

    @Override
    public String currency() {
        return "JPY";
    }
}
