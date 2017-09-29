DROP SCHEMA IF EXISTS Oblig2 CASCADE;
DROP TABLE IF EXISTS Oblig2.bruker CASCADE;

CREATE SCHEMA Oblig2;

CREATE TABLE Oblig2.bruker (
  telefon     VARCHAR      NOT NULL,
  kjonn       VARCHAR,
  fornavn     VARCHAR,
  etternavn   VARCHAR,
  har_betalt   BOOLEAN,
  PRIMARY KEY(telefon)
);