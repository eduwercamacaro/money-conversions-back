package com.edu.conversions.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = "id")
@Builder
@AllArgsConstructor
public class CurrencyDto {

    private UUID id;
    private String name;
    private String symbol;

}
