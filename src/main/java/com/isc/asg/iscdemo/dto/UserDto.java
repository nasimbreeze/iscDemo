package com.isc.asg.iscdemo.dto;

import com.isc.asg.iscdemo.model.User;
import lombok.Value;
import utils.ShipmentStr;

import java.io.Serializable;
import java.time.Instant;

/**
 * DTO for {@link User}
 */
@Value
public class UserDto implements Serializable {
    Long userId;
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