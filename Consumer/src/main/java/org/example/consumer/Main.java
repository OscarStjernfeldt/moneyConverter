package org.example.consumer;

import org.example.convert.Converter;

import java.util.Scanner;
import java.util.ServiceLoader;

public class Main {

    static Scanner sc = new Scanner(System.in);

    static ServiceLoader<Converter> serviceLoader = ServiceLoader.load(Converter.class);

    public static void main(String[] args) {
        menu();
    }

    public static void menu() {
        while (true) {
            System.out.println("Welcome to our currency changer!");
            System.out.println("You can choose from following choices:");
            System.out.println("------------------------------------");
            System.out.println("1: Convert from SEK to EUR");
            System.out.println("2: Convert from SEK to USD");
            System.out.println("3: Convert from SEK to GBP");
            System.out.println("e: To close system, press e");
            String menuOption = sc.nextLine()
                    .toLowerCase();

            switch (menuOption) {
                case "1" -> ConvertToEuro(serviceLoader);
                case "2" -> ConvertToDollar(serviceLoader);
                case "3" -> ConvertToPound(serviceLoader);
                case "e" -> System.exit(0);
            }
        }
    }

    private static void ConvertToEuro(ServiceLoader<Converter> serviceLoader) {

        System.out.println("Converting 100 SEK to new currency:");
        System.out.println("--------------------");

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToEur"))
                .forEach(convertProvider -> System.out.println(convertProvider.convertMoney()));

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToEur"))
                .forEach(convertProvider -> System.out.println(convertProvider.currency()));
        System.out.println("--------------------");
    }

    private static void ConvertToDollar(ServiceLoader<Converter> serviceLoader) {

        System.out.println("Converting 100 SEK to new currency:");
        System.out.println("--------------------");

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToUsd"))
                .forEach(convertProvider -> System.out.println(convertProvider.convertMoney()));

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToUsd"))
                .forEach(convertProvider -> System.out.println(convertProvider.currency()));
        System.out.println("--------------------");
    }

    private static void ConvertToPound(ServiceLoader<Converter> serviceLoader) {

        System.out.println("Converting 100 SEK to new currency:");
        System.out.println("--------------------");

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToGbp"))
                .forEach(convertProvider -> System.out.println(convertProvider.convertMoney()));

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .startsWith("ConvertFromSekToGbp"))
                .forEach(convertProvider -> System.out.println(convertProvider.currency()));
        System.out.println("--------------------");
    }
}
