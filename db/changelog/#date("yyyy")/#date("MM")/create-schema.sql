CREATE TABLE customer
(
    customer_id          BIGINT NOT NULL,
    firstname            VARCHAR(15),
    lastname             VARCHAR(15),
    account_no           VARCHAR(10),
    shipping_address     VARCHAR(40),
    national_code        VARCHAR(10),
    phone_no             INT,
    email                VARCHAR(255),
    authentication_token VARCHAR(255),
    CONSTRAINT pk_customer PRIMARY KEY (customer_id)
);

ALTER TABLE customer
    ADD CONSTRAINT uc_customer_national_code UNIQUE (national_code);

CREATE TABLE card
(
    card_id     BIGINT      NOT NULL,
    activated   BOOLEAN     NOT NULL,
    card_no     VARCHAR(16) NOT NULL,
    card_type   VARCHAR(6)  NOT NULL,
    expiry_date TIMESTAMP,
    issuer_code VARCHAR(6),
    customer_id BIGINT,
    CONSTRAINT pk_card PRIMARY KEY (card_id),
    CONSTRAINT uc_card_cardno UNIQUE (card_no),
    CONSTRAINT FK_CARD_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (customer_id)
);


CREATE TABLE issuer
(
    id          BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    issuer_code VARCHAR(6)   NOT NULL,
    issuer_name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_issuer PRIMARY KEY (issuer_code),
    CONSTRAINT uc_issuer_issuer_code UNIQUE (issuer_code)
);


/*
CREATE TABLE card_details
(
    card_type   VARCHAR(255) NOT NULL,
    issuer_code INT          NOT NULL,
    CONSTRAINT pk_carddetails PRIMARY KEY (card_type, issuer_code)
);

ALTER TABLE card_details
    ADD CONSTRAINT FK_CARDDETAILS_ON_CARD_TYPE FOREIGN KEY (card_type) REFERENCES card (card_id);

ALTER TABLE card_details
    ADD CONSTRAINT FK_CARDDETAILS_ON_ISSUER_CODE FOREIGN KEY (issuer_code) REFERENCES issuer (issuer_code) ;
*/

ALTER TABLE card
    ADD CONSTRAINT FK_CARD_ON_ISSUER_CODE FOREIGN KEY (issuer_code) REFERENCES issuer (issuer_code);