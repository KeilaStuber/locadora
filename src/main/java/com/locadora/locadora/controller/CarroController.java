package com.locadora.locadora.controller;
import com.locadora.locadora.models.Carro;
import com.locadora.locadora.models.Cliente;
import com.locadora.locadora.repository.CarroRepository;
import java.util.List;
import java.util.Optional;

import com.locadora.locadora.service.CarroService;
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

@CrossOrigin(value="*")
@RestController
@RequestMapping ("/carro")
public class CarroController {
    @Autowired
    public CarroService carroService;
    @GetMapping
    public ResponseEntity<List <Carro>> listarCarros() {

        ResponseEntity response = ResponseEntity.badRequest().build();
        List<Carro> carroList = carroService.findAll();

        if (carroList != null) {
            if (carroList.size() > 0) {
                response = ResponseEntity.ok(carroList);
            } else {
                response = ResponseEntity.noContent().build();
            }
        }
        return response;
    }

    @GetMapping("/{id}")
    public Optional<Carro> listarCarroId (@PathVariable(value = "id") long id) {
        return carroService.getCarro(id);
    }

    @PutMapping("/{id}")
    public Carro atualizarCarro(@RequestBody Carro carro) {
        return carroService.save(carro);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carro cadastrarCarro(@RequestBody Carro carro) {
        return carroService.save(carro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCarro(@PathVariable(value = "id") long id) {
        carroService.deleteById(id);
    }

}
