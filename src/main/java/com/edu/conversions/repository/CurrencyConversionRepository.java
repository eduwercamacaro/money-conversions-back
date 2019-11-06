package com.edu.conversions.repository;

import com.edu.conversions.entity.CurrencyConversion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CurrencyConversionRepository extends CrudRepository<CurrencyConversion, UUID> {

    @Query("select cc from CurrencyConversion cc " +
            "join fetch cc.currencyFrom cf " +
            "join fetch cc.currencyTo ct " +
            "where cf.id = :currencyFromId and ct.id = :currencyToId")
    Optional<CurrencyConversion> findByCurrencyFromAndCurrencyTo(@Param("currencyFromId") UUID currencyFromId,
                                                                 @Param("currencyToId") UUID currencyToId);

}
