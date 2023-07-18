\c postgres
SET ROLE postgres;

DROP DATABASE IF EXISTS sk_example_db;
DROP USER IF EXISTS sk_example_user;

CREATE USER sk_example_user WITH PASSWORD 'pwuser';
CREATE DATABASE sk_example_db OWNER sk_example_user;

GRANT CONNECT ON DATABASE sk_example_db TO sk_example_user;
GRANT ALL PRIVILEGES ON database sk_example_db TO sk_example_user;
SET ROLE sk_example_user;
\c sk_example_db

CREATE TABLE IF NOT EXISTS sk_example_table
(
    id SERIAL,
    obj JSONB NOT NULL,
    PRIMARY KEY (id)
);
ALTER TABLE public.sk_example_table OWNER TO sk_example_user;
INSERT INTO sk_example_table (obj)
VALUES ('{
  "current": 0
}'::JSONB);