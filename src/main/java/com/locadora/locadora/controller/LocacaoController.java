package com.locadora.locadora.controller;
import com.locadora.locadora.models.Cliente;
import com.locadora.locadora.repository.LocacaoRepository;
import java.util.List;
import java.util.Optional;

import com.locadora.locadora.service.LocacaoService;
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
import com.locadora.locadora.models.Locacao;
@CrossOrigin(value = "*")
@RestController
@RequestMapping("/locacao")

public class LocacaoController {
    @Autowired
    public LocacaoService locacaoService;

    @GetMapping
    public ResponseEntity<List<Locacao>> listaLocacoes() {

        ResponseEntity response = ResponseEntity.badRequest().build();
        List<Locacao> locacaoList = locacaoService.findAll();

        if (locacaoList != null) {
            if (locacaoList.size() > 0) {
                response = ResponseEntity.ok(locacaoList);
            } else {
                response = ResponseEntity.noContent().build();
            }
        }
        return response;
    }
    @GetMapping("/{id}")
    public Optional<Locacao> listarLocacaoId  (@PathVariable(value = "id") long id) {return locacaoService.getLocacao(id);}

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Locacao sLocacao(@RequestBody Locacao locacao) {return locacaoService.save(locacao);}

    @PutMapping("/{id}")
    public Locacao aLocacao(@RequestBody Locacao locacao) {return locacaoService.save(locacao);}

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dLocacao(@PathVariable(value = "id") long id) {locacaoService.deleteById(id);}
}
