package org.example.provide;

import org.example.convert.Converter;

public class ConvertFromSekToEur implements Converter {

    @Override
    public double convertMoney() {
        return 100 / 9.76;
    }

    @Override
    public String currency() {
        return "EURO";
    }
}
