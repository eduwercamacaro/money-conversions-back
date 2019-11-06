package com.edu.conversions.service;

import com.edu.conversions.dto.CurrencyConversionDto;

import java.math.BigDecimal;
import java.util.UUID;

public interface CurrencyConversionService {

    CurrencyConversionDto findConversion(UUID currencyFromId, UUID currencyToId, BigDecimal amount);

}
