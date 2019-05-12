--DROP TABLE users IF EXISTS;

CREATE TABLE customer (
  id   VARCHAR(30) PRIMARY KEY,
  firstname VARCHAR(30),
  lastname  VARCHAR(50)
);