package org.example.consumer;

import org.example.convert.Converter;

import java.util.InputMismatchException;
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

    private static void convertToCurrency(ServiceLoader<Converter> serviceLoader) {
        System.out.println();
        System.out.println("Converting " + givenAmount + " SEK to:");
        System.out.println("--------------------");

        serviceLoader.stream()
                .map(ServiceLoader.Provider::get)
                .forEach(convertProvider -> System.out.println(convertProvider.convertMoney(givenAmount) + " - " + convertProvider.currency()));
        System.out.println("--------------------");
    }
}
