/*
package com.isc.asg.iscdemo.audit.memory;

public class MemoryUsageCalculator {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        // Record initial memory usage
        runtime.gc(); // Suggest garbage collection
        long initialMemory = runtime.totalMemory() - runtime.freeMemory();

        // Create objects
        */
/*InMemoryCardCustomerRepository repository = new InMemoryCardCustomerRepository();

        // Add sample data
        for (long i = 1; i <= 10; i++) {
            Customer customer = new Customer();
            customer.setCustomerId(100L);
            customer.setFirstname("CustomerFrstNme " + i);
            customer.setLastname("CustomerLstNme " + i);
            customer.setNationalCode((int) (542918805 + i));
            customer.setAccountNo("004858675008".concat(String.valueOf(i)));
            for (long j = 1; j <= 5; j++) {
                Issuer issuer = new Issuer();
                issuer.setId(j);
                issuer.setIssuerCode(String.valueOf(j));
                issuer.setIssuerName("Issuer " + j);

                Card card = new Card();
                card.setCardId((i * 10) + j);
                card.setCardNo( "823234453626682377");
                card.setCardType(j % 2 == 0 ? CardType.CR : CardType.DE);
                card.setCustomer(customer);
                card.setIssuer(issuer);

                customer.getCards().add(card);
            }

            repository.saveCustomer(customer);
        }

        // Record final memory usage
        long finalMemory = runtime.totalMemory() - runtime.freeMemory();

        // Calculate memory used
        long memoryUsed = finalMemory - initialMemory;

        System.out.println("Memory used: " + memoryUsed + " bytes");*//*

    }
}
*/
