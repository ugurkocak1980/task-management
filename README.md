PoatgreSQL needs to be created with the following type, cast and table

CREATE TYPE tasks.prio_enum AS ENUM ('LOW', 'NORMAL', 'URGENT');
CREATE CAST (varchar as tasks.prio_enum) WITH INOUT AS IMPLICIT;
CREATE TABLE tasks.task (
   id BIGINT NOT NULL,
   name VARCHAR(255),
   done BOOLEAN,
   created TIMESTAMP WITHOUT TIME ZONE,
   priority tasks.prio_enum,
   CONSTRAINT pk_task PRIMARY KEY (id)
);
