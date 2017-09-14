DROP TABLE IF EXISTS bruker CASCADE;
CREATE TABLE bruker (
  bruker_id     SERIAL    NOT NULL,
  brukernavn    VARCHAR(20),
  PRIMARY KEY(bruker_id)
);
INSERT INTO bruker (brukernavn) VALUES('peder')