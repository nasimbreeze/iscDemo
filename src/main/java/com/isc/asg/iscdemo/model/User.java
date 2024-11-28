package com.isc.asg.iscdemo.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "User.countBy", query = "select count(u) from User u")
})
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull
    @Setter
    @Getter
    @Column(length = 15)
    private String firstname;

    @NotNull
    @Setter
    @Getter
    @Column(length = 15)
    private String lastname;

    @Setter
    @Getter
    @NotNull
    @Column(length = 10)
    @Size(min = 10, max = 10)
    private int accountNo;

    @Column(length = 40)
    @Setter
    @Getter
    private String shippingAddress;

    //TODO to be done followingly if VALIDATION is a priority
    //TODO violations and payload from
    //https://medium.com/@saiteja-erwa/spring-boot-dto-validation-using-groups-and-payload-attributes-e2c139f5b1ef
    @Column(name = "national_code", length = 10, unique = true)
    @Getter
    @Setter
    @Size(message = "national code must be 10 digits", min = 10, max = 10)
    private int nationalCode;

    @Column(length = 10)
    @Setter
    @Getter
    @NotNull
    private int phoneNo;

    @Column
    @Setter
    @Getter
    private String authenticationToken;

    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    private Set<Card> cards;


    public User() {
        /*this.firstname = firstname;
        this.lastname = lastname;
        this.authenticationToken = authenticationToken;
        this.phoneNo= phoneNo;
        this.shippingAddress = shippingAddress;
        this.NationalCode = NationalCode;
        this.cardNo = cardNo;*/
    }

}
