package com.edu.conversions.service.impl;

import com.edu.conversions.dto.CurrencyConversionDto;
import com.edu.conversions.dto.CurrencyDto;
import com.edu.conversions.entity.Currency;
import com.edu.conversions.entity.CurrencyConversion;
import com.edu.conversions.repository.CurrencyConversionRepository;
import com.edu.conversions.service.CurrencyConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.ValidationException;
import java.math.BigDecimal;
import java.util.UUID;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

    @Autowired
    private CurrencyConversionRepository currencyConversionRepository;

    @Override
    public CurrencyConversionDto findConversion(UUID currencyFromId, UUID currencyToId, BigDecimal amount){
        Assert.notNull(currencyFromId, "Currency from is empty!");
        Assert.notNull(currencyToId, "Currency to is empty!");
        Assert.notNull(amount, "Amount is empty!");
        CurrencyConversion currencyConversion = currencyConversionRepository.findByCurrencyFromAndCurrencyTo(currencyFromId, currencyToId)
                .orElseThrow(() -> new ValidationException("Data for Currency Conversion is not found!"));
        BigDecimal totalConvertedAmount = amount.multiply(currencyConversion.getMultiplyRate());
        Currency currencyFrom = currencyConversion.getCurrencyFrom();
        Currency currencyTo = currencyConversion.getCurrencyTo();
        CurrencyDto currencyFromDto = CurrencyDto.builder()
                .id(currencyFrom.getId())
                .name(currencyFrom.getName())
                .build();
        CurrencyDto currencyToDto = CurrencyDto.builder()
                .id(currencyTo.getId())
                .name(currencyTo.getName())
                .build();
        return CurrencyConversionDto.builder()
                .id(currencyConversion.getId())
                .currencyFromDto(currencyFromDto)
                .currencyToDto(currencyToDto)
                .fromQuantity(amount)
                .totalTo(totalConvertedAmount)
                .build();
    }
}
