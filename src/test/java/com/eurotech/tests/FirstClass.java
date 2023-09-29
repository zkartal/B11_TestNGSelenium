package com.eurotech.tests;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class FirstClass {
    public static void main(String[] args) {
        // Faker ile birlikte biz fake bilgiler olusturabiliyoruz
        System.out.println("Hello World");
        Faker faker = new Faker();
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.gameOfThrones().character() = " + faker.gameOfThrones().character());
        System.out.println("faker.finance().creditCard(CreditCardType.AMERICAN_EXPRESS) = " + faker.finance().creditCard(CreditCardType.AMERICAN_EXPRESS));
        for (int i = 0; i < 10; i++) {
            System.out.println(faker.address().cityName());

        }
    }
}
