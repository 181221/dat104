DROP SCHEMA IF EXISTS handleliste CASCADE;
DROP TABLE IF EXISTS handleliste.bruker CASCADE;
DROP TABLE IF EXISTS handleliste.varer CASCADE;
DROP TABLE IF EXISTS handleliste.kurv CASCADE;

CREATE SCHEMA handleliste;

CREATE TABLE handleliste.bruker (
  bruker_id     SERIAL      NOT NULL,
  brukernavn    VARCHAR(20),
  passord       VARCHAR(20),
  PRIMARY KEY(bruker_id)
);

CREATE TABLE handleliste.kurv (
  kurv_id          SERIAL      NOT NULL,
  bruker_id        INTEGER     REFERENCES handleliste.bruker(bruker_id),
  beskrivelse      VARCHAR(20),
  PRIMARY KEY(kurv_id)
);
CREATE TABLE handleliste.vare (
  vare_id          SERIAL      NOT NULL,
  kurv_id          INTEGER     REFERENCES handleliste.kurv(kurv_id),
  navn             VARCHAR(20) NOT NULL,
  PRIMARY KEY(vare_id )
);

ALTER TABLE handleliste.bruker ADD UNIQUE (brukernavn);