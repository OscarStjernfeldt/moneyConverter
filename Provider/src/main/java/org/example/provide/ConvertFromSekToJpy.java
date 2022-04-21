package org.example.provide;

import org.example.convert.Converter;

public class ConvertFromSekToJpy implements Converter {
    @Override
    public double convertMoney() {
        return 100 * 13.55;
    }

    @Override
    public String currency() {
        return "JPY";
    }
}
