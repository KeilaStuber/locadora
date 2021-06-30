package com.locadora.locadora.repository;
import com.locadora.locadora.models.Locacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocacaoRepository extends JpaRepository <Locacao,Long> {
    Locacao findById(long id);
}
