PostgreSQL needs to be created with the following type, cast and table

CREATE TYPE tasks.prio_enum AS ENUM ('LOW', 'NORMAL', 'URGENT');
CREATE CAST (varchar as tasks.prio_enum) WITH INOUT AS IMPLICIT;
CREATE TABLE tasks.task (
id serial primary key,
name VARCHAR(255),
done BOOLEAN,
created TIMESTAMP WITHOUT TIME ZONE,
priority tasks.prio_enum
);

#TODO: junit tests for service & controller class
#TODO: dto vs entity class & mapping
