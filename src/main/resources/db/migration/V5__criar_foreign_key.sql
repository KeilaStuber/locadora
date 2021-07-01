ALTER TABLE locacao ADD FOREIGN KEY (cliente) REFERENCES cliente(id);
ALTER TABLE locacao ADD FOREIGN KEY (carro) REFERENCES carro(id);
ALTER TABLE carro ADD FOREIGN KEY (categoria) REFERENCES categoria(id);