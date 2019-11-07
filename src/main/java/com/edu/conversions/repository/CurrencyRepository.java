package com.edu.conversions.repository;

import com.edu.conversions.entity.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface CurrencyRepository extends CrudRepository<Currency, UUID> {
}
