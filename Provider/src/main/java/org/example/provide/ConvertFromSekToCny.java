package org.example.provide;

import org.example.convert.Converter;

public class ConvertFromSekToCny implements Converter {
    @Override
    public double convertMoney() {
        return 100 * 0.68;
    }

    @Override
    public String currency() {
        return "CNY";
    }
}
