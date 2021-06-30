CREATE TABLE locacao (
    id INT NOT NULL PRIMARY KEY auto_increment,
    cliente VARCHAR(100) NOT NULL DEFAULT '',
    categoria VARCHAR(50) NOT NULL DEFAULT '',
    carro VARCHAR (50) NOT NULL DEFAULT '',
    valor VARCHAR(30) NOT NULL DEFAULT '',
    dataini DATE NOT NULL,
    datafim DATE NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;