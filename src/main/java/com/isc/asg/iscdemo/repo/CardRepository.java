package com.isc.asg.iscdemo.repo;

import com.isc.asg.iscdemo.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("SELECT c FROM Card c WHERE c.customer.customerId = :customerId")
    List<Card> findCardsByCustomerId(Long customerId);
}