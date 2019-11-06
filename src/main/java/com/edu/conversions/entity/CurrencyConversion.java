package com.edu.conversions.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.UUID;

@Data
@Table(name = "currency_conversions", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"currency_from_id", "currency_to_id"})
})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyConversion {

    @Id
    private UUID id;
    @NotNull
    @JoinColumn(name = "currency_from_id")
    @ManyToOne
    private Currency currencyFrom;
    @NotNull
    @JoinColumn(name = "currency_to_id")
    @ManyToOne()
    private Currency currencyTo;
    @NotNull
    @Positive
    @Column(columnDefinition = "numeric(16, 6)")
    private BigDecimal multiplyRate;

}
