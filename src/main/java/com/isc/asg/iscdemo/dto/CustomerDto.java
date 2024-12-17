package com.isc.asg.iscdemo.dto;

import com.isc.asg.iscdemo.model.Customer;
import lombok.Value;
import utils.ShipmentStr;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link Customer}
 */
@Value
public class CustomerDto implements Serializable {
    Long id;
    String firstname;
    String lastname;
    int accountNo;
    ShipmentStr shippingAddress;
    String uid;
    int nationalCode;
    int cardNo;
    int phoneNo;
    String authenticationToken;
    String encryptedPassword;
    Instant birthday;
}