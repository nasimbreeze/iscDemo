package com.isc.asg.iscdemo.repo;

import com.isc.asg.iscdemo.model.Card;
import com.isc.asg.iscdemo.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByCards(Card cards);

    @Override
    List<Customer> findAll();
}