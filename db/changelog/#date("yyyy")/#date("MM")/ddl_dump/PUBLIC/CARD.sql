create table CARD
(
    CARD_ID     BIGINT                not null,
    ACTIVATED   BOOLEAN               not null,
    CARD_NO     CHARACTER VARYING(16) not null
        constraint UC_CARD_CARDNO
            unique,
    CARD_TYPE   CHARACTER VARYING(6)  not null,
    EXPIRY_DATE TIMESTAMP,
    ISSUER_CODE CHARACTER VARYING(6),
    CUSTOMER_ID BIGINT,
    constraint PK_CARD
        primary key (CARD_ID),
    constraint FK_CARD_ON_CUSTOMER
        foreign key (CUSTOMER_ID) references CUSTOMER
);

