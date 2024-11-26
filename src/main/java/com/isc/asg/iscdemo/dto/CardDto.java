package com.isc.asg.iscdemo.dto;

import lombok.Value;
import com.isc.asg.iscdemo.model.CardType;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.isc.asg.iscdemo.model.Card}
 */
@Value
public class CardDto implements Serializable {
    Long cardId;
    boolean activated;
    int cardNo;
    int issuerCode;
    CardType cardType;
    Date expiraryDate;
}