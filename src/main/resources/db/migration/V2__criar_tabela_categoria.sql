CREATE TABLE categoria (
  id int not null primary key auto_increment,
  categoria varchar(100) not null DEFAULT '',
  preco     varchar(30) not null DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
