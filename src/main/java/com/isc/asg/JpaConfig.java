package com.isc.asg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;

import java.util.Map;

@Configuration
public class JpaConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setPersistenceUnitName("default");
        emf.setJpaPropertyMap(Map.of(
                "hibernate.entityManagerFactoryInterface", "jakarta.persistence.EntityManagerFactory"
        ));
        return emf;
    }
}