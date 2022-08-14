CREATE DATABASE demo;
CREATE USER user_demo WITH ENCRYPTED PASSWORD 'user_demo';
GRANT ALL PRIVILEGES ON DATABASE demo TO user_demo;

CREATE TABLE Utilisateur
(
    id serial ,
    nom character varying(30) NOT NULL,
    prenom character varying(30) NOT NULL,
    email character varying(60) NOT NULL,
    PRIMARY KEY (id)
);