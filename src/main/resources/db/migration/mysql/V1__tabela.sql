CREATE TABLE tb_pessoa (
  id int not null primary key auto_increment,
  aniversario date ,
  email varchar(255),
  nome varchar(255) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
