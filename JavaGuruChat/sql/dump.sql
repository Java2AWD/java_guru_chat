SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

CREATE TABLE conversation (
    type character(10),
    name character(60),
    id bigint NOT NULL
);


ALTER TABLE public.conversation OWNER TO postgres;

CREATE SEQUENCE conversation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.conversation_id_seq OWNER TO postgres;

ALTER SEQUENCE conversation_id_seq OWNED BY conversation.id;

CREATE TABLE message (
    id bigint NOT NULL,
    user_id bigint,
    convesation_id bigint
);


ALTER TABLE public.message OWNER TO postgres;

COMMENT ON COLUMN message.convesation_id IS '';

CREATE SEQUENCE message_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE public.message_id_seq OWNER TO postgres;

ALTER SEQUENCE message_id_seq OWNED BY message.id;

CREATE TABLE participant (
    id bigint NOT NULL,
    user_id bigint,
    conversation_id bigint
);

ALTER TABLE public.participant OWNER TO postgres;

CREATE SEQUENCE participant_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.participant_id_seq OWNER TO postgres;

ALTER SEQUENCE participant_id_seq OWNED BY participant.id;

CREATE TABLE "user" (
    id bigint NOT NULL,
    name character(50),
    surname character(50),
    username character(50),
    password character(50),
    email character(60)
);


ALTER TABLE public."user" OWNER TO postgres;

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_id_seq OWNER TO postgres;

ALTER SEQUENCE user_id_seq OWNED BY "user".id;

ALTER TABLE ONLY conversation ALTER COLUMN id SET DEFAULT nextval('conversation_id_seq'::regclass);

ALTER TABLE ONLY message ALTER COLUMN id SET DEFAULT nextval('message_id_seq'::regclass);

ALTER TABLE ONLY participant ALTER COLUMN id SET DEFAULT nextval('participant_id_seq'::regclass);

ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);

SELECT pg_catalog.setval('conversation_id_seq', 1, false);

SELECT pg_catalog.setval('message_id_seq', 1, false);

SELECT pg_catalog.setval('participant_id_seq', 1, false);

SELECT pg_catalog.setval('user_id_seq', 1, false);

ALTER TABLE ONLY conversation
    ADD CONSTRAINT id PRIMARY KEY (id);

ALTER TABLE ONLY message
    ADD CONSTRAINT message_id PRIMARY KEY (id);

ALTER TABLE ONLY participant
    ADD CONSTRAINT participant_id PRIMARY KEY (id);

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_id PRIMARY KEY (id);

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;