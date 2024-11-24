package com.isc.asg.iscdemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Setter
    @Getter
    private String firstname;
    @NotNull
    @Setter
    @Getter
    private String lastname;

    @Setter
    @Getter
    @NotNull
    @Size(min = 10, max = 10)
    private int accountNo;

    @Setter
    @Getter
    private String shippingAddress;

    //TODO to be done followingly if VALIDATION is a priority
    //TODO violations and payload from
    //https://medium.com/@saiteja-erwa/spring-boot-dto-validation-using-groups-and-payload-attributes-e2c139f5b1ef
    @Getter
    @Setter
    @Size(message ="national code must be 10 digits" , min = 10, max = 10)
    private int NationalCode;

    @Setter
    @Getter
    @Size(min = 16, max = 16)
    private int cardNo;

    @Setter
    @Getter
    @NotNull
    private int phoneNo;

    private String authenticationToken;

    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "user")
    private List<Card> cards;

    public User() {
        this.firstname = firstname;
        this.lastname = lastname;
        this.authenticationToken = authenticationToken;
        this.shippingAddress = shippingAddress;
    }

}
