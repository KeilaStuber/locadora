package com.locadora.locadora.service;

import com.locadora.locadora.models.Locacao;
import com.locadora.locadora.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocacaoService {
    @Autowired
    LocacaoRepository locacaoRepository;

    //Método que vai salvar a locacao
    public Locacao save(Locacao locacao){
        return this.locacaoRepository.save(locacao);
    }

    //Método get na lista
    public List<Locacao> getAll(){
        return (List<Locacao>) this.locacaoRepository.findAll();
    }

    //Método pra pegar a locacao pelo ID
    public Optional<Locacao> getLocacao(Long id){return this.locacaoRepository.findById(id);}

    public List<Locacao> findAll() {
        return this.locacaoRepository.findAll();
    }

    public void deleteById(long id) {

    }

    public Locacao atualizaCliente (Locacao locacao) {
        Optional<Locacao> optionalLocacao = Optional.ofNullable(this.locacaoRepository.findById(locacao.getId()));
        return this.locacaoRepository.save(locacao);
    }
}
