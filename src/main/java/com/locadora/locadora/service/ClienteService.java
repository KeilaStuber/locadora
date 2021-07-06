package com.locadora.locadora.service;
import com.locadora.locadora.models.Cliente;
import com.locadora.locadora.repository.ClienteRepository;
import com.locadora.locadora.repository.LocacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    //Método que vai salvar o cliente
    public Cliente save(Cliente cliente){
        return this.clienteRepository.save(cliente);
    }

    //Método get na lista
    public List<Cliente> getAll(){
        return (List<Cliente>) this.clienteRepository.findAll();
    }

    //Método pra pegar o cliente pelo ID
    public Optional<Cliente> getCliente(Long id){
        return this.clienteRepository.findById(id);
    }

    public List<Cliente> findAll() {
        return this.clienteRepository.findAll();
    }

    public void deleteById(long id) {

    }

    public Cliente atualizaCliente (Cliente cliente) {
        Optional<Cliente> optionalCliente = Optional.ofNullable(this.clienteRepository.findById(cliente.getId()));
            return this.clienteRepository.save(cliente);
    }

}
