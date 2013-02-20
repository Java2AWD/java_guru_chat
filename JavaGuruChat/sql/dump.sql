--<ScriptOptions statementTerminator=";"/>

CREATE TABLE conversation (
		type BPCHAR(10),
		name BPCHAR(60),
		id BIGSERIAL DEFAULT nextval('conversation_id_seq'::regclass) NOT NULL
	);

CREATE TABLE user (
		id BIGSERIAL DEFAULT nextval('user_id_seq'::regclass) NOT NULL,
		name BPCHAR(50),
		surname BPCHAR(50),
		username BPCHAR(50),
		password BPCHAR(50),
		email BPCHAR(60)
	);

CREATE TABLE message (
		id BIGSERIAL DEFAULT nextval('message_id_seq'::regclass) NOT NULL,
		user_id INT8,
		convesation_id INT8
	);

CREATE TABLE participant (
		id BIGSERIAL DEFAULT nextval('participant_id_seq'::regclass) NOT NULL,
		user_id INT8,
		conversation_id INT8
	);

CREATE UNIQUE INDEX message_id ON message (id ASC);

CREATE UNIQUE INDEX participant_id ON participant (id ASC);

CREATE UNIQUE INDEX id ON conversation (id ASC);

CREATE UNIQUE INDEX user_id ON user (id ASC);

ALTER TABLE conversation ADD CONSTRAINT id PRIMARY KEY (id);

ALTER TABLE message ADD CONSTRAINT message_id PRIMARY KEY (id);

ALTER TABLE user ADD CONSTRAINT user_id PRIMARY KEY (id);

ALTER TABLE participant ADD CONSTRAINT participant_id PRIMARY KEY (id);

