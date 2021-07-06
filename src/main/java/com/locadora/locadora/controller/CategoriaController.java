package com.locadora.locadora.controller;
import com.locadora.locadora.models.Categoria;
import com.locadora.locadora.service.CategoriaService;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;


@CrossOrigin(value = "*")
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    public CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {

        ResponseEntity response = ResponseEntity.badRequest().build();
        List<Categoria> categoriaList = categoriaService.findAll();

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
    public Optional<Categoria> listarCategoriaId (@PathVariable(value = "id") long id) {return categoriaService.getCategoria(id);}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Categoria cadastrarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @PutMapping("/{id}")
    public Categoria aCategoria(@RequestBody Categoria categoria) {
        return categoriaService.save(categoria);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dCliente(@PathVariable(value = "id") long id) {categoriaService.deleteById(id);

    }

}
