CREATE TYPE prio_enum AS ENUM ('LOW', 'NORMAL', 'URGENT');
CREATE CAST (varchar as prio_enum) WITH INOUT AS IMPLICIT;
CREATE TABLE task (
   id serial primary key,
   name VARCHAR(255),
   done BOOLEAN,
   created TIMESTAMP WITHOUT TIME ZONE,
   priority prio_enum
);