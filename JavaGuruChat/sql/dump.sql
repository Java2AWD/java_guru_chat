--
-- PostgreSQL database dump
--

-- Dumped from database version 9.1.8
-- Dumped by pg_dump version 9.1.8
-- Started on 2013-02-18 20:43:01

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 169 (class 3079 OID 11639)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 1893 (class 0 OID 0)
-- Dependencies: 169
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 162 (class 1259 OID 16397)
-- Dependencies: 5
-- Name: conversation; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE conversation (
    type character(10),
    name character(60),
    id bigint NOT NULL
);


ALTER TABLE public.conversation OWNER TO postgres;

--
-- TOC entry 161 (class 1259 OID 16395)
-- Dependencies: 162 5
-- Name: conversation_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE conversation_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.conversation_id_seq OWNER TO postgres;

--
-- TOC entry 1894 (class 0 OID 0)
-- Dependencies: 161
-- Name: conversation_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE conversation_id_seq OWNED BY conversation.id;


--
-- TOC entry 166 (class 1259 OID 16419)
-- Dependencies: 5
-- Name: message; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE message (
    id bigint NOT NULL,
    user_id bigint,
    convesation_id bigint
);


ALTER TABLE public.message OWNER TO postgres;

--
-- TOC entry 1895 (class 0 OID 0)
-- Dependencies: 166
-- Name: COLUMN message.convesation_id; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON COLUMN message.convesation_id IS '
';


--
-- TOC entry 165 (class 1259 OID 16417)
-- Dependencies: 166 5
-- Name: message_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE message_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.message_id_seq OWNER TO postgres;

--
-- TOC entry 1896 (class 0 OID 0)
-- Dependencies: 165
-- Name: message_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE message_id_seq OWNED BY message.id;


--
-- TOC entry 168 (class 1259 OID 16427)
-- Dependencies: 5
-- Name: participant; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE participant (
    id bigint NOT NULL,
    user_id bigint,
    conversation_id bigint
);


ALTER TABLE public.participant OWNER TO postgres;

--
-- TOC entry 167 (class 1259 OID 16425)
-- Dependencies: 168 5
-- Name: participant_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE participant_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.participant_id_seq OWNER TO postgres;

--
-- TOC entry 1897 (class 0 OID 0)
-- Dependencies: 167
-- Name: participant_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE participant_id_seq OWNED BY participant.id;


--
-- TOC entry 164 (class 1259 OID 16411)
-- Dependencies: 5
-- Name: user; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE "user" (
    id bigint NOT NULL,
    name character(50),
    surname character(50),
    username character(50),
    password character(50),
    email character(60)
);


ALTER TABLE public."user" OWNER TO postgres;

--
-- TOC entry 163 (class 1259 OID 16409)
-- Dependencies: 5 164
-- Name: user_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE user_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.user_id_seq OWNER TO postgres;

--
-- TOC entry 1898 (class 0 OID 0)
-- Dependencies: 163
-- Name: user_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE user_id_seq OWNED BY "user".id;


--
-- TOC entry 1866 (class 2604 OID 16400)
-- Dependencies: 161 162 162
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY conversation ALTER COLUMN id SET DEFAULT nextval('conversation_id_seq'::regclass);


--
-- TOC entry 1868 (class 2604 OID 16422)
-- Dependencies: 165 166 166
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY message ALTER COLUMN id SET DEFAULT nextval('message_id_seq'::regclass);


--
-- TOC entry 1869 (class 2604 OID 16430)
-- Dependencies: 168 167 168
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY participant ALTER COLUMN id SET DEFAULT nextval('participant_id_seq'::regclass);


--
-- TOC entry 1867 (class 2604 OID 16414)
-- Dependencies: 164 163 164
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY "user" ALTER COLUMN id SET DEFAULT nextval('user_id_seq'::regclass);


--
-- TOC entry 1879 (class 0 OID 16397)
-- Dependencies: 162 1886
-- Data for Name: conversation; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY conversation (type, name, id) FROM stdin;
\.


--
-- TOC entry 1899 (class 0 OID 0)
-- Dependencies: 161
-- Name: conversation_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('conversation_id_seq', 1, false);


--
-- TOC entry 1883 (class 0 OID 16419)
-- Dependencies: 166 1886
-- Data for Name: message; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY message (id, user_id, convesation_id) FROM stdin;
\.


--
-- TOC entry 1900 (class 0 OID 0)
-- Dependencies: 165
-- Name: message_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('message_id_seq', 1, false);


--
-- TOC entry 1885 (class 0 OID 16427)
-- Dependencies: 168 1886
-- Data for Name: participant; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY participant (id, user_id, conversation_id) FROM stdin;
\.


--
-- TOC entry 1901 (class 0 OID 0)
-- Dependencies: 167
-- Name: participant_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('participant_id_seq', 1, false);


--
-- TOC entry 1881 (class 0 OID 16411)
-- Dependencies: 164 1886
-- Data for Name: user; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY "user" (id, name, surname, username, password, email) FROM stdin;
\.


--
-- TOC entry 1902 (class 0 OID 0)
-- Dependencies: 163
-- Name: user_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('user_id_seq', 1, false);


--
-- TOC entry 1871 (class 2606 OID 16402)
-- Dependencies: 162 162 1887
-- Name: id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY conversation
    ADD CONSTRAINT id PRIMARY KEY (id);


--
-- TOC entry 1875 (class 2606 OID 16424)
-- Dependencies: 166 166 1887
-- Name: message_id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY message
    ADD CONSTRAINT message_id PRIMARY KEY (id);


--
-- TOC entry 1877 (class 2606 OID 16432)
-- Dependencies: 168 168 1887
-- Name: participant_id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY participant
    ADD CONSTRAINT participant_id PRIMARY KEY (id);


--
-- TOC entry 1873 (class 2606 OID 16416)
-- Dependencies: 164 164 1887
-- Name: user_id; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY "user"
    ADD CONSTRAINT user_id PRIMARY KEY (id);


--
-- TOC entry 1892 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2013-02-18 20:43:01

--
-- PostgreSQL database dump complete
--

