package org.example.provide;

import org.example.convert.Converter;
import org.example.convert.CurrencyFullName;

@CurrencyFullName(currency = "Chinese Yuan")
public class Cny implements Converter {

    @Override
    public double convertMoney(int givenAmount) {
        return givenAmount * 0.68;
    }

    @Override
    public String currency() {
        return "CNY";
    }
}
