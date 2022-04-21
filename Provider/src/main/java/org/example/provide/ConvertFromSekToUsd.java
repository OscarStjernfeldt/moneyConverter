package org.example.provide;

import org.example.convert.Converter;

public class ConvertFromSekToUsd implements Converter {
    @Override
    public double convertMoney() {
        return 100 / 10.60;
    }

    @Override
    public String currency() {
        return "USD";
    }
}
