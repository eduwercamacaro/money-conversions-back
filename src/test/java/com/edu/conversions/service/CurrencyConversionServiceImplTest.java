package com.edu.conversions.service;

import com.edu.conversions.TestData;
import com.edu.conversions.dto.CurrencyConversionDto;
import com.edu.conversions.entity.Currency;
import com.edu.conversions.entity.CurrencyConversion;
import com.edu.conversions.repository.CurrencyConversionRepository;
import com.edu.conversions.service.impl.CurrencyConversionServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
public class CurrencyConversionServiceImplTest {

    @Mock
    private CurrencyConversionRepository currencyConversionRepository;
    @InjectMocks
    private CurrencyConversionService currencyConversionService = new CurrencyConversionServiceImpl();

    @Test
    public void shouldCalculateConversionForCurrency(){
        Currency currencyFrom = TestData.getInstance().currency();
        Currency currencyTo = TestData.getInstance().currency();
        BigDecimal testQuantity = BigDecimal.valueOf(10);
        CurrencyConversion currencyConversion = TestData.getInstance().currencyConversion(currencyFrom, currencyTo);
        when(currencyConversionRepository.findByCurrencyFromAndCurrencyTo(currencyFrom.getId(), currencyTo.getId()))
                .thenReturn(
                        Optional.of(currencyConversion)
                );
        CurrencyConversionDto conversion = currencyConversionService.findConversion(currencyFrom.getId(), currencyTo.getId(), testQuantity);
        assertNotNull(conversion);
        assertNotNull(conversion.getId());
        assertNotNull(conversion.getCurrencyFromDto());
        assertNotNull(conversion.getCurrencyFromDto().getId());
        assertNotNull(conversion.getCurrencyFromDto().getName());
        assertNotNull(conversion.getCurrencyToDto());
        assertNotNull(conversion.getCurrencyToDto().getId());
        assertNotNull(conversion.getCurrencyToDto().getName());
        assertNotNull(conversion.getFromQuantity());
        assertEquals(conversion.getTotalTo(), currencyConversion.getMultiplyRate().multiply(testQuantity));
    }

}
