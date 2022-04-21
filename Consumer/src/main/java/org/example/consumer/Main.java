package org.example.consumer;

import org.example.convert.Converter;

import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static ServiceLoader<Converter> serviceLoader = ServiceLoader.load(Converter.class);

    private static int givenAmount;

    public static void main(String[] args) {
        System.out.println("WELCOME TO OUR CURRENCY CONVERTER");
        System.out.println();
        System.out.println("Please enter the amount of SEK that you'd like to convert: ");
        givenAmount = sc.nextInt();
        menu();
    }

    public static void menu() {
        while (true) {
            String menuOption = sc.nextLine()
                    .toLowerCase();

            switch (menuOption) {
                case "1" -> ConvertToEuro(serviceLoader);
                case "2" -> ConvertToDollar(serviceLoader);
                case "3" -> ConvertToPound(serviceLoader);
                case "4" -> ConvertToYen(serviceLoader);
                case "5" -> ConvertToYuan(serviceLoader);
                case "e" -> System.exit(0);
            }
            menuOptions();
        }
    }

    private static void menuOptions() {
        System.out.println();
        System.out.println("You can choose from the following choices:");
        System.out.println("------------------------------------");
        System.out.println("1: Convert from SEK to EUR");
        System.out.println("2: Convert from SEK to USD");
        System.out.println("3: Convert from SEK to GBP");
        System.out.println("4: Convert from SEK to JPY");
        System.out.println("5: Convert from SEK to CNY");
        System.out.println("e: To close system, press e");
        System.out.println("------------------------------------");
    }

    private static void ConvertToEuro(ServiceLoader<Converter> serviceLoader) {
        System.out.println();
        System.out.println("Converting " + givenAmount + " SEK to Euro:");
        System.out.println("--------------------");

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToEur"))
                .forEach(convertProvider -> System.out.println(convertProvider.convertMoney(givenAmount)));

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToEur"))
                .forEach(convertProvider -> System.out.println(convertProvider.currency()));
        System.out.println("--------------------");
    }

    private static void ConvertToDollar(ServiceLoader<Converter> serviceLoader) {
        System.out.println();
        System.out.println("Converting " + givenAmount + " SEK to US Dollars:");
        System.out.println("-----------------------------");

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToUsd"))
                .forEach(convertProvider -> System.out.println(convertProvider.convertMoney(givenAmount)));

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToUsd"))
                .forEach(convertProvider -> System.out.println(convertProvider.currency()));
        System.out.println("--------------------");
    }

    private static void ConvertToPound(ServiceLoader<Converter> serviceLoader) {
        System.out.println();
        System.out.println("Converting " + givenAmount + " SEK to British Pounds:");
        System.out.println("--------------------");

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToGbp"))
                .forEach(convertProvider -> System.out.println(convertProvider.convertMoney(givenAmount)));

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToGbp"))
                .forEach(convertProvider -> System.out.println(convertProvider.currency()));
        System.out.println("--------------------");
    }

    private static void ConvertToYen(ServiceLoader<Converter> serviceLoader) {
        System.out.println();
        System.out.println("Converting " + givenAmount + " SEK to Japanese Yen:");
        System.out.println("--------------------");

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToJpy"))
                .forEach(convertProvider -> System.out.println(convertProvider.convertMoney(givenAmount)));

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToJpy"))
                .forEach(convertProvider -> System.out.println(convertProvider.currency()));
        System.out.println("--------------------");
    }

    private static void ConvertToYuan(ServiceLoader<Converter> serviceLoader) {
        System.out.println();
        System.out.println("Converting " + givenAmount + " SEK to Chinese Yuan:");
        System.out.println("--------------------");

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToCny"))
                .forEach(convertProvider -> System.out.println(convertProvider.convertMoney(givenAmount)));

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToCny"))
                .forEach(convertProvider -> System.out.println(convertProvider.currency()));
        System.out.println("--------------------");
    }
}
