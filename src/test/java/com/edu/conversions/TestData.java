package com.edu.conversions;

import com.edu.conversions.entity.Currency;
import com.edu.conversions.entity.CurrencyConversion;
import com.github.javafaker.Faker;

import java.math.BigDecimal;
import java.util.UUID;

public class TestData {
    private static TestData INSTANCE;
    private final Faker faker = new Faker();
    private TestData(){}

    public static TestData getInstance(){
        return INSTANCE != null ? INSTANCE : (INSTANCE = new TestData());
    }

    public Currency currency(){
        return Currency.builder()
                .id(UUID.randomUUID())
                .name(faker.gameOfThrones().house())
                .symbol(faker.address().cityPrefix())
                .build();
    }

    public CurrencyConversion currencyConversion(Currency currencyFrom, Currency currencyTo){
        return CurrencyConversion.builder()
                .currencyFrom(currencyFrom)
                .currencyTo(currencyTo)
                .id(UUID.randomUUID())
                .multiplyRate(BigDecimal.valueOf(faker.random().nextInt(1,100)))
                .build();
    }

}
