package com.isc.asg.iscdemo;

import com.isc.asg.iscdemo.model.Card;
import com.isc.asg.iscdemo.model.CardType;
import com.isc.asg.iscdemo.model.Customer;
import com.isc.asg.iscdemo.model.Issuer;
import com.isc.asg.iscdemo.repo.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
public class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer();
        customer.setFirstname("John");
        customer.setLastname("Doe");
        customer.setNationalCode("5588929625");

        Issuer issuer1 = new Issuer();
        issuer1.setIssuerName("Bank A");
        issuer1.setIssuerCode("123456");

        Issuer issuer2 = new Issuer();
        issuer2.setIssuerName("Bank B");
        issuer2.setIssuerCode("123457");

        Card card1 = new Card();
        card1.setCardNo("1111222233334444");
        card1.setCardType(CardType.CR);
        card1.setIssuer(issuer1);
        card1.setCustomer(customer);

        Card card2 = new Card();
        card2.setCardNo("5555666677778888");
        card2.setCardType(CardType.DE);
        card2.setIssuer(issuer2);
        card2.setCustomer(customer);

        customer.getCards().add(card1);
        customer.getCards().add(card2);
        Customer savedCustomer = customerRepository.save(customer);

        assertNotNull(savedCustomer.getId());
    }
}
