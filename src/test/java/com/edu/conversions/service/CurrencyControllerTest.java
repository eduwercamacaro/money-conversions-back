package com.edu.conversions.service;

import com.edu.conversions.controller.CurrencyController;
import com.edu.conversions.dto.CurrencyDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JUnitPlatform.class)
@ExtendWith(MockitoExtension.class)
public class CurrencyControllerTest {

    @Mock
    private CurrencyService currencyService;
    @InjectMocks
    private CurrencyController currencyController = new CurrencyController();

    @Test
    public void shouldCallFindCurrencyFrom(){
        when(currencyService.findCurrencyFromDefault()).thenReturn(new CurrencyDto());
        CurrencyDto currencyFromDefault = currencyController.findCurrencyFromDefault();
        assertNotNull(currencyFromDefault);
        verify(currencyService).findCurrencyFromDefault();
    }

    @Test
    public void shouldCallFindCurrencyTo(){
        when(currencyService.findCurrencyToDefault()).thenReturn(new CurrencyDto());
        CurrencyDto currencyFromDefault = currencyController.findCurrencyToDefault();
        assertNotNull(currencyFromDefault);
        verify(currencyService).findCurrencyToDefault();
    }


}
