package org.example.consumer;

import org.example.convert.Converter;

import java.util.List;
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
        List<String> listOfCurrencies = serviceLoader.stream()
                .map(ServiceLoader.Provider::type)
                .map(Class::getSimpleName)
                .toList();
        while (true) {
            String menuOption = sc.nextLine()
                    .toLowerCase();


            switch (menuOption) {
                case "eur" -> ConvertToCurrency(serviceLoader, "Eur", "Euro");
                case "usd" -> ConvertToCurrency(serviceLoader, "Usd", "US Dollar");
                case "gbp" -> ConvertToCurrency(serviceLoader, "Gbp", "British Pound");
                case "jpy" -> ConvertToCurrency(serviceLoader, "Jpy", "Japanese Yen");
                case "cny" -> ConvertToCurrency(serviceLoader, "Cny", "Chinese Yuan");
                case "e" -> System.exit(0);
            }

            System.out.println("Please enter the name of the currency:");
            System.out.println("--------------------");
            System.out.println(listOfCurrencies);

            //serviceLoader.stream().map(ServiceLoader.Provider::type).forEach(p -> System.out.println(p.getSimpleName()));
            System.out.println("[Enter E for Exit]");
        }
    }

    private static void ConvertToCurrency(ServiceLoader<Converter> serviceLoader, String endsWith, String currency) {
        System.out.println();
        System.out.println("Converting " + givenAmount + " SEK to: " + currency);
        System.out.println("--------------------");

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .endsWith(endsWith))
                .forEach(convertProvider -> System.out.println(convertProvider.convertMoney(givenAmount)));

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .filter(convertProvider -> convertProvider.getClass()
                        .getSimpleName()
                        .endsWith(endsWith))
                .forEach(convertProvider -> System.out.println(convertProvider.currency()));
        System.out.println("--------------------");
    }
}
