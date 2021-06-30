CREATE TABLE carro (
  id int not null primary key auto_increment,
  nome varchar(100) not null DEFAULT '',
  marca varchar(50) not null DEFAULT '',
  categoria varchar(50) not null DEFAULT '',
  ano date not null
) ENGINE=InnoDB DEFAULT CHARSET=latin1;