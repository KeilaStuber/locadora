package com.locadora.locadora.service;
import com.locadora.locadora.models.Categoria;
import com.locadora.locadora.models.Cliente;
import com.locadora.locadora.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    CategoriaRepository categoriaRepository;

    //Método que vai salvar o cliente
    public Categoria save(Categoria categoria){
        return this.categoriaRepository.save(categoria);
    }

    //Método get na lista
    public List<Categoria> getAll(){
        return (List<Categoria>) this.categoriaRepository.findAll();
    }

    //Método pra pegar a categoria pelo ID
    public Optional<Categoria> getCategoria(Long id){
        return this.categoriaRepository.findById(id);
    }

    public List<Categoria> findAll() {
        return this.categoriaRepository.findAll();
    }

    public void deleteById(long id) {

    }
    public Categoria atualizaCategoria (Categoria categoria) {
        Optional<Categoria> optionalCategoria = Optional.ofNullable(this.categoriaRepository.findById(categoria.getId()));
        return this.categoriaRepository.save(categoria);
    }
}