package org.example.consumer;

import org.example.convert.Converter;
import org.example.convert.CurrencyFullName;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static ServiceLoader<Converter> serviceLoader = ServiceLoader.load(Converter.class);

    private static float givenAmount;

    public static void main(String[] args) {
        System.out.println("WELCOME TO OUR CURRENCY CONVERTER");
        System.out.println("---------------------------------");
        while (true) {
            System.out.println("1. To list all currencies");
            System.out.println("2. To run converter");
            System.out.println("[Press E to Exit]");
            System.out.println();
            String choice = sc.nextLine();
            switch (choice) {
                case "1" -> listAllCurrencies();
                case "2" -> runConverter();
            }
            if (choice.toLowerCase(Locale.ROOT).equals("e"))
                break;
        }
    }

    private static void convertToCurrency(ServiceLoader<Converter> serviceLoader) {
        System.out.println();
        System.out.println("Converting " + givenAmount + " SEK to:");
        System.out.println("--------------------");

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .forEach(convertProvider -> System.out.println(convertProvider.convertMoney(givenAmount) + " - " + convertProvider.currency()));
        System.out.println("--------------------");
    }

    private static void listAllCurrencies() {
        System.out.println("List of currencies: ");
        System.out.println("--------------------");
        serviceLoader.stream()
                .map(ServiceLoader.Provider::type)
                .forEach(p -> System.out.println(p.getAnnotation(CurrencyFullName.class)
                        .currency()));
        System.out.println("--------------------");
    }

    private static void runConverter() {
        System.out.println("Please enter the amount of SEK that you'd like to convert: ");
        try {
            givenAmount = sc.nextInt();
            if (givenAmount > 0)
                convertToCurrency(serviceLoader);
            else
                throw new IllegalArgumentException();
        } catch (InputMismatchException | IllegalArgumentException e) {
            System.out.println("Invalid input, only numbers above 0");
        }
    }
}
