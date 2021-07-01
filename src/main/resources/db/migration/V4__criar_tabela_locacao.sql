CREATE TABLE locacao (
    id INT NOT NULL PRIMARY KEY auto_increment,
    cliente INT NOT NULL,
    carro INT (50) NOT NULL,
    valor VARCHAR(30) NOT NULL DEFAULT '',
    dataini DATE NOT NULL,
    datafim DATE NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;