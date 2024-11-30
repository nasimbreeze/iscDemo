package com.isc.asg.iscdemo.repo;

import com.isc.asg.iscdemo.model.Card;
import com.isc.asg.iscdemo.model.Customer;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public interface CustomerRepository extends Repository<Customer, Long> {
    Optional<Customer> findByCards(Card cards);
}