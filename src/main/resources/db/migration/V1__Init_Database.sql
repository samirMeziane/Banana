CREATE SEQUENCE sequence_generator START WITH 1050 INCREMENT BY 1;

CREATE TABLE receiver (
                      id                  UUID                   NOT NULL,
                      last_name           VARCHAR(50)            NOT NULL,
                      first_name          VARCHAR(50)            NOT NULL,
                      address             VARCHAR(50)            NOT NULL,
                      postal_code         VARCHAR(10)            NOT NULL,
                      town                VARCHAR(50)            NOT NULL,
                      country             VARCHAR(50)            NOT NULL
);

ALTER TABLE receiver ADD CONSTRAINT receiver_pk PRIMARY KEY (id);
ALTER TABLE receiver ADD CONSTRAINT receiver_uk UNIQUE (last_name, first_name, address, postal_code, town, country);

CREATE TABLE order_table (
                      id                  UUID                    NOT NULL,
                      receiver_id   UUID                    NOT NULL,
                      quantity            INTEGER                 NOT NULL,
                      date                DATE                    NOT NULL,
                      price               REAL                    NOT NULL
);

ALTER TABLE order_table ADD CONSTRAINT order_table_pk PRIMARY KEY (id);
ALTER TABLE order_table ADD CONSTRAINT order_table_receiver_fk FOREIGN KEY (receiver_id) REFERENCES receiver (id);
