DROP SCHEMA IF EXISTS brukersystem CASCADE;
DROP TABLE IF EXISTS brukersystem.bruker CASCADE;

CREATE SCHEMA brukersystem;

CREATE TABLE brukersystem.bruker (
bruker_id     SERIAL      NOT NULL,
brukernavn    VARCHAR(20),
email    VARCHAR(30),
passord       VARCHAR(250),
PRIMARY KEY(bruker_id)
);
ALTER TABLE brukersystem.bruker ADD UNIQUE (brukernavn);