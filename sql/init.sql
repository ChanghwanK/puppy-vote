CREATE TABLE authentications (
    id BIGINT NOT NULL AUTO_INCREMENT,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at DATETIME NOT NULL,
    updated_at DATETIME NOT NULL,

    PRIMARY KEY (id)
)

ALTER TABLE authentications
ADD CONSTRAINT uq_email UNIQUE (email)