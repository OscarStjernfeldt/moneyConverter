package org.example.provide;

import org.example.convert.Converter;

public class ConvertFromSekToGbp implements Converter {
    @Override
    public double convertMoney() {
        return 100 / 8.12;
    }

    @Override
    public String currency() {
        return "GBP";
    }
}
