package com.edu.conversions.service.impl;

import com.edu.conversions.dto.CurrencyDto;
import com.edu.conversions.entity.Currency;
import com.edu.conversions.repository.CurrencyRepository;
import com.edu.conversions.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.UUID;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;
    @Value("${application.configuration.defaultCurrencyFrom}")
    private UUID defaultCurrencyFromId;
    @Value("${application.configuration.defaultCurrencyTo}")
    private UUID defaultCurrencyToId;

    @Override
    public CurrencyDto findCurrencyToDefault(){
        return this.findCurrency(defaultCurrencyToId);
    }

    @Override
    public CurrencyDto findCurrencyFromDefault(){
        return this.findCurrency(defaultCurrencyFromId);
    }

    @Override
    public CurrencyDto findCurrency(UUID currencyId){
        Currency currency = currencyRepository.findById(currencyId)
                .orElseThrow(() -> new ValidationException("Default Currency From is not found!"));
        return CurrencyDto.builder()
                .id(currency.getId())
                .name(currency.getName())
                .symbol(currency.getSymbol())
                .build();
    }

}
