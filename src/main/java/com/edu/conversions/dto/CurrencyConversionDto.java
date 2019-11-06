package com.edu.conversions.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class CurrencyConversionDto {

    private UUID id;
    private CurrencyDto currencyFromDto;
    private CurrencyDto currencyToDto;
    private BigDecimal fromQuantity;
    private BigDecimal totalTo;

}
