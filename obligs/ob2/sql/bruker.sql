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
INSERT INTO Oblig2.bruker (telefon, fornavn, er_kasserer) VALUES ('55960636','peder',TRUE)