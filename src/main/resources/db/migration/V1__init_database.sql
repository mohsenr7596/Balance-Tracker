CREATE TABLE btr_transaction
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    fk_user_id BIGINT NOT NULL,
    amount     INT    NOT NULL,
    timestamp  datetime NULL,
    CONSTRAINT pk_btr_transaction PRIMARY KEY (id)
);

CREATE TABLE btr_user
(
    id      BIGINT AUTO_INCREMENT NOT NULL,
    name    VARCHAR(255) NULL,
    balance INT NOT NULL,
    CONSTRAINT pk_btr_user PRIMARY KEY (id)
);

ALTER TABLE btr_transaction
    ADD CONSTRAINT FK_BTR_TRANSACTION_ON_FK_USER FOREIGN KEY (fk_user_id) REFERENCES btr_user (id);