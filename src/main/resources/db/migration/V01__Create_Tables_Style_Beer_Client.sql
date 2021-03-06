CREATE TABLE style(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE beer(
	id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	sku VARCHAR(50) NOT NULL,
	name VARCHAR(80) NOT NULL,
	description TEXT NOT NULL,
	stock_quantity INTEGER NOT NULL,
	price DECIMAL(10,2) NOT NULL,
	alcohol_strength DECIMAL(10,2) NOT NULL,
	comission DECIMAL(10,2) NOT NULL,
	flavour VARCHAR(50) NOT NULL,
	origin VARCHAR(50) NOT NULL,
	style_id BIGINT(20) NOT NULL,
	FOREIGN KEY(style_id) REFERENCES style(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO style VALUES (0, 'Amber Lager');
INSERT INTO style VALUES (0, 'Dark Lager');
INSERT INTO style VALUES (0, 'Pale Lager');
INSERT INTO style VALUES (0, 'Pilsner');
