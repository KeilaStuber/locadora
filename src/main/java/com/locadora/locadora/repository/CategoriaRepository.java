package com.locadora.locadora.repository;

import com.locadora.locadora.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <Categoria,Long> {
    Categoria findById(long id);

}
