package com.isc.asg.iscdemo.service;

import com.isc.asg.iscdemo.model.Card;
import com.isc.asg.iscdemo.model.Customer;
import com.isc.asg.iscdemo.repo.CardRepository;
import com.isc.asg.iscdemo.repo.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CardService {

    @Qualifier("customerRepository")
    private CustomerRepository customerRepository;

    @Autowired
    private CardRepository cardRepository;

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Card> getExclusiveCardsByCustomerId(Long customerId) {
        List<Card> cards = cardRepository.findCardsByCustomerId(customerId);
        return cards.stream()
                .collect(Collectors.toMap(
                        card -> Arrays.asList(card.getIssuer().getId(), card.getCardType()),
                        card -> card,
                        (existing, replacement) -> existing
                ))
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
}