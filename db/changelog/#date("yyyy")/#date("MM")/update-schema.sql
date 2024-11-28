CREATE TABLE "user"
(
    user_id              BIGINT NOT NULL,
    firstname            VARCHAR(15),
    lastname             VARCHAR(15),
    account_no           INT,
    shipping_address     VARCHAR(40),
    national_code        INT,
    card_no              INT,
    phone_no             INT,
    authentication_token VARCHAR(255),
    CONSTRAINT pk_user PRIMARY KEY (user_id)
);

ALTER TABLE "user"
    ADD CONSTRAINT uc_user_national_code UNIQUE (national_code);

CREATE TABLE card
(
    card_id     BIGINT NOT NULL,
    activated   BOOLEAN,
    card_no     VARCHAR(16),
    card_type   VARCHAR(255),
    expiry_date TIMESTAMP,
    user_id     BIGINT,
    CONSTRAINT pk_card PRIMARY KEY (card_id)
);

ALTER TABLE card
    ADD CONSTRAINT FK_CARD_ON_USER FOREIGN KEY (user_id) REFERENCES "user" (user_id);

CREATE TABLE issuer
(
    issuer_id   BIGINT       NOT NULL,
    issuer_code INT          NOT NULL,
    issuer_name VARCHAR(255) NOT NULL,
    CONSTRAINT pk_issuer PRIMARY KEY (issuer_id)
);


ALTER TABLE issuer
    ADD CONSTRAINT uc_issuer_issuer_code UNIQUE (issuer_code);


CREATE TABLE card_details
(
    card_type   VARCHAR(255) NOT NULL,
    issuer_code INT          NOT NULL,
    CONSTRAINT pk_carddetails PRIMARY KEY (card_type, issuer_code)
);

ALTER TABLE card_details
    ADD CONSTRAINT FK_CARDDETAILS_ON_CARD_TYPE FOREIGN KEY (card_type) REFERENCES card (card_id);

ALTER TABLE card_details
    ADD CONSTRAINT FK_CARDDETAILS_ON_ISSUER_CODE FOREIGN KEY (issuer_code) REFERENCES issuer (issuer_id);



