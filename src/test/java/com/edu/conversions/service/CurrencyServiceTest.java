package com.edu.conversions.service;

import com.edu.conversions.TestData;
import com.edu.conversions.dto.CurrencyDto;
import com.edu.conversions.repository.CurrencyRepository;
import com.edu.conversions.service.impl.CurrencyServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;
@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
public class CurrencyServiceTest {

    @Mock
    private CurrencyRepository currencyRepository;
    @InjectMocks
    private CurrencyService currencyService = new CurrencyServiceImpl();

    @Test
    public void shouldFindCurrency(){
        UUID testCurrencyId = UUID.randomUUID();
        when(currencyRepository.findById(testCurrencyId))
                .thenReturn(Optional.of(TestData.getInstance().currency()));
        CurrencyDto currencyDto = currencyService.findCurrency(testCurrencyId);

        assertNotNull(currencyDto);
        assertNotNull(currencyDto.getName());
        assertNotNull(currencyDto.getId());
        assertNotNull(currencyDto.getSymbol());
    }


}
