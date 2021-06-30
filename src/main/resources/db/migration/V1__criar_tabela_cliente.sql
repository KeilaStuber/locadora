CREATE TABLE cliente (
  id int not null primary key auto_increment,
  nome varchar(255),
  cpf varchar(14),
  aniversario date ,
  telefone varchar(11),
  email varchar(255)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
