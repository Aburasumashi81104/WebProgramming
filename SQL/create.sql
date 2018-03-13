CREATE TABLE user (
	id SERIAL  NOT NULL,
	login_id varchar(255) UNIQUE NOT NULL,
	name varchar(255) NOT NULL,
	birth_date DATE NOT NULL,
	password varchar(255) NOT NULL,
	create_date DATETIME NOT NULL,
	update_date DATETIME NOT NULL,
	PRIMARY KEY (id)
);

INSERT INTO user (login_id,name,birth_date,password,create_date,update_date) VALUES
    ('admin','ä«óùé“','2000-01-01','password','1000-01-01 00:00:00','9999-12-31 23:59:59');
	
