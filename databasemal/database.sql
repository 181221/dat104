DROP TABLE IF EXISTS tabell CASCADE;

CREATE TABLE tabell (
  tabell_id     SERIAL    NOT NULL,
  navn    VARCHAR(20),
  PRIMARY KEY(tabell_id)
);
INSERT INTO tabell (navn) VALUES('navn')