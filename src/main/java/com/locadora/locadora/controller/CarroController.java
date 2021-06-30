package com.locadora.locadora.controller;
import com.locadora.locadora.models.Carro;
import com.locadora.locadora.models.Cliente;
import com.locadora.locadora.repository.CarroRepository;
import java.util.List;
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
    public CarroRepository carroRepository;
    @GetMapping
    public ResponseEntity<List <Carro>> listaCarro() {

        ResponseEntity response = ResponseEntity.badRequest().build();
        List<Carro> carroList = carroRepository.findAll();

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
    public Carro lCarro (@PathVariable(value = "id") long id) {return carroRepository.findById(id);}

    @PutMapping("/{id}")
    public Carro aCarro(@RequestBody Carro carro) {
        return carroRepository.save(carro);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Carro sCarro(@RequestBody Carro carro) {
        return carroRepository.save(carro);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dCarro(@PathVariable(value = "id") long id) {
        carroRepository.deleteById(id);
    }

}
