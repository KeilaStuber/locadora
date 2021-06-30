package com.locadora.locadora.repository;
import com.locadora.locadora.models.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository <Carro,Long> {
    Carro findById(long id);
}
