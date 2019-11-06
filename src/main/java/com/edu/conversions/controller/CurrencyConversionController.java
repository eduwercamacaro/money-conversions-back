package com.edu.conversions.controller;

import com.edu.conversions.dto.CurrencyConversionDto;
import com.edu.conversions.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.UUID;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionService currencyConversionService;

    @GetMapping("/money/conversion")
    public CurrencyConversionDto currencyConversionDto(@RequestParam(value = "currencyFromId", defaultValue = "${application.configuration.defaultCurrencyFrom}") UUID currencyFromId,
                                                       @RequestParam(value = "currencyToId", defaultValue = "${application.configuration.defaultCurrencyTo}") UUID currencyToId,
                                                       @RequestParam("amount") BigDecimal amount){
        return currencyConversionService.findConversion(currencyFromId, currencyToId, amount);
    }

}
