package com.isc.asg.iscdemo.model;

import lombok.Value;
import utils.ShipmentStr;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link User}
 */
@Value
public class UserDto implements Serializable {
    Long id;
    String firstname;
    String lastname;
    int accountNo;
    ShipmentStr shippingAddress;
    String uid;
    int NationalCode;
    int cardNo;
    int phoneNo;
    String authenticationToken;
    String encryptedPassword;
    Instant birthday;
}