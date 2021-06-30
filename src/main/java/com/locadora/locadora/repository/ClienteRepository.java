package com.locadora.locadora.repository;
import com.locadora.locadora.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {
    Cliente findById(long id);

}