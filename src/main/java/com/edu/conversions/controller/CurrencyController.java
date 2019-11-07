package com.edu.conversions.controller;

import com.edu.conversions.dto.CurrencyDto;
import com.edu.conversions.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    @Autowired
    private CurrencyService currencyService;

    @GetMapping("/currency/default/to")
    public CurrencyDto findCurrencyToDefault(){
        return currencyService.findCurrencyToDefault();
    }

    @GetMapping("/currency/default/from")
    public CurrencyDto findCurrencyFromDefault(){
        return currencyService.findCurrencyFromDefault();
    }

}
