package com.locadora.locadora.controller;
import com.locadora.locadora.models.Categoria;
import com.locadora.locadora.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


@CrossOrigin(value = "*")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    public CategoriaRepository categoriaRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> listaCategoria() {

        ResponseEntity response = ResponseEntity.badRequest().build();
        List<Categoria> categoriaList = categoriaRepository.findAll();

        if (categoriaList != null) {
            if (categoriaList.size() > 0) {
                response = ResponseEntity.ok(categoriaList);
            } else {
                response = ResponseEntity.noContent().build();
            }
        }

        return response;
    }
    @GetMapping("/{id}")
    public Categoria lCategoria (@PathVariable(value = "id") long id) {return categoriaRepository.findById(id);}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria sCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @PutMapping("/{id}")
    public Categoria aCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dCliente(@PathVariable(value = "id") long id) {categoriaRepository.deleteById(id);

    }

}
