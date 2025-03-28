DO
$$
BEGIN
    IF
EXISTS (SELECT FROM pg_database WHERE datname = 'first_db') THEN
        PERFORM pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = 'first_db';
        DROP
DATABASE first_db;
END IF;
END
$$;

CREATE DATABASE first_db
    WITH OWNER = 'test'
    ENCODING = 'UTF8'
    LC_COLLATE = 'ja_JP.UTF-8'
    LC_CTYPE = 'ja_JP.UTF-8'
    TEMPLATE = template0;

DO
$$
BEGIN
    IF
EXISTS (SELECT FROM pg_database WHERE datname = 'second_db') THEN
        PERFORM pg_terminate_backend(pid) FROM pg_stat_activity WHERE datname = 'second_db';
        DROP
DATABASE second_db;
END IF;
END
$$;

CREATE DATABASE second_db
    WITH OWNER = 'test'
    ENCODING = 'UTF8'
    LC_COLLATE = 'ja_JP.UTF-8'
    LC_CTYPE = 'ja_JP.UTF-8'
    TEMPLATE = template0;

\c first_db;

CREATE TABLE IF NOT EXISTS first_table (
    id CHAR(26) COLLATE "C" PRIMARY KEY
);

\c second_db;

CREATE TABLE IF NOT EXISTS second_table (
    id CHAR(26) COLLATE "C" PRIMARY KEY
);
