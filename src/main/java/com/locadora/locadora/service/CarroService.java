package com.locadora.locadora.service;

import com.locadora.locadora.models.Carro;
import com.locadora.locadora.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {
    @Autowired
    CarroRepository carroRepository;

    //Método que vai salvar o carro
    public Carro save(Carro carro){
        return this.carroRepository.save(carro);
    }

    //Método get na lista
    public List<Carro> getAll(){
        return (List<Carro>) this.carroRepository.findAll();
    }

    //Método pra pegar o cliente pelo ID
    public Optional<Carro> getCarro(Long id){
        return this.carroRepository.findById(id);
    }

    public List<Carro> findAll() {
        return this.carroRepository.findAll();
    }

    public void deleteById(long id) {
    }

    public Carro atualizaCarro (Carro carro) {
        Optional<Carro> optionalCliente = Optional.ofNullable(this.carroRepository.findById(carro.getId()));
        return this.carroRepository.save(carro);
    }

}
