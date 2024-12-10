package com.isc.asg.iscdemo;

import com.isc.asg.iscdemo.model.Card;
import com.isc.asg.iscdemo.model.Customer;
import com.isc.asg.iscdemo.model.Issuer;
import com.isc.asg.iscdemo.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.isc.asg.iscdemo.model.CardType;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.isc.asg.iscdemo.repo")
@EntityScan(basePackages = "com.isc.asg.iscdemo")
public class IscDemoApplication implements CommandLineRunner {

    @Autowired
    private CardService cardService;

    public static void main(String[] args) {
        SpringApplication.run(IscDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        // Add sample data
        Customer customer = new Customer();
        customer.setFirstname("John");
        customer.setLastname("Doe");
        customer.setNationalCode("5588929623");

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

        cardService.saveCustomer(customer);

        // Fetch and display data
        System.out.println("Exclusive cards for customer ID 1:");
        List<Card> exclusiveCards = cardService.getExclusiveCardsByCustomerId(1L);
        exclusiveCards.forEach(card -> System.out.println(card.getCardNo()));

        System.out.println("All customers:");
        List<Customer> allCustomers = cardService.getAllCustomers();
        allCustomers.forEach(c -> System.out.println(c.getFirstname() + c.getLastname()));

        // Calculate memory usage
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Request garbage collection

        long initialMemory = runtime.totalMemory() - runtime.freeMemory();

        // Simulate a larger dataset
        for (long i = 2; i <= 1000; i++) {
            Customer newCustomer = new Customer();
            newCustomer.setFirstname("Customer " + i);

            Issuer newIssuer = new Issuer();
            newIssuer.setIssuerName("Issuer " + i);

            String issuerCode;
            issuerCode = "12345" + i;
            if(issuerCode.length() > 6) {
                issuerCode = issuerCode.substring(issuerCode.length() - 6);
                System.out.println("12345 " + issuerCode);
            }
            newIssuer.setIssuerCode(issuerCode);

            Card newCard = new Card();
            String cardNo ;
            cardNo = "123498763452666" + i;
            if(cardNo.length() > 16) {
                cardNo = cardNo.substring(cardNo.length() - 16);
                System.out.println("123498763452666 " + cardNo);
            }

            newCard.setCardNo(cardNo);
            newCard.setCardType(i % 2 == 0 ? CardType.CR : CardType.DE);
            newCard.setIssuer(newIssuer);
            newCard.setCustomer(newCustomer);

            newCustomer.getCards().add(newCard);

            cardService.saveCustomer(newCustomer);
        }

        long finalMemory = runtime.totalMemory() - runtime.freeMemory();
        System.out.println("Memory used by application: " + (finalMemory - initialMemory) + " bytes");
    }
}
