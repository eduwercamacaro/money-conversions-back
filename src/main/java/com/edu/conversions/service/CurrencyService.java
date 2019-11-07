package com.edu.conversions.service;

import com.edu.conversions.dto.CurrencyDto;

import java.util.UUID;

public interface CurrencyService {

    CurrencyDto findCurrencyToDefault();

    CurrencyDto findCurrencyFromDefault();

    CurrencyDto findCurrency(UUID currencyId);

}
