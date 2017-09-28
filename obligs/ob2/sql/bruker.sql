DROP SCHEMA IF EXISTS Oblig2 CASCADE;
DROP TABLE IF EXISTS Oblig2.bruker CASCADE;

CREATE SCHEMA Oblig2;

CREATE TABLE Oblig2.bruker (
  telefon     VARCHAR      NOT NULL,
  kjonn       VARCHAR,
  fornavn     VARCHAR,
  etternavn   VARCHAR,
  er_kasserer  BOOLEAN,
  har_betalt   BOOLEAN,
  PRIMARY KEY(telefon)
);
INSERT INTO Oblig2.bruker (telefon, fornavn) VALUES ('12345678', 'peder')