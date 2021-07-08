package com.locadora.locadora.service;

import com.locadora.locadora.models.Carro;
import com.locadora.locadora.models.Cliente;
import com.locadora.locadora.models.Locacao;
import com.locadora.locadora.repository.CarroRepository;
import com.locadora.locadora.repository.ClienteRepository;
import com.locadora.locadora.repository.LocacaoRepository;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocacaoService {
    @Autowired
    LocacaoRepository locacaoRepository;

    @Autowired
    ClienteService clienteService;

    @Autowired
    CarroService carroService;


    //Método que vai salvar a locacao
    public Locacao save(Locacao locacao) throws NullPointerException{
        if (locacao.getCarro() != null && locacao.getCliente() != null){
            if(locacao.getId() > 0 && locacao.getId() >0 ){
                Optional<Carro> optionalCarro = this.carroService.getCarro(locacao.getId());
                Optional<Cliente>optionalCliente = this.clienteService.getCliente(locacao.getId());
                if (optionalCarro.isPresent() && optionalCliente.isPresent()){
                    locacao.setCarro(optionalCarro.get());
                    locacao.setCliente(optionalCliente.get());
                    return locacaoRepository.save(locacao);
                }else{
                    throw new NullPointerException ("Verifique se o carro e o cliente estão cadastrados");
                }
            } throw new NullPointerException("Cadastro não localizado");
        }
        return null;
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
