package br.exaltagame.backgame.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.exaltagame.backgame.entity.Categoria;
import br.exaltagame.backgame.entity.Avaliacao;
import br.exaltagame.backgame.entity.BrowserGame;
import br.exaltagame.backgame.repository.AvaliacaoRepository;
import br.exaltagame.backgame.repository.BrowserGameRepository;
import br.exaltagame.backgame.repository.CategoriaRepository;

@RestController
public class AvaliacaoController {
    @Autowired
    private AvaliacaoRepository repository;

    @RequestMapping(value = "/avaliacoes", method = RequestMethod.GET)
    public List<Avaliacao> getAvaliacoes() {
        return repository.findAll();
    }

    @RequestMapping(value = "/avaliacoes/{id}", method = RequestMethod.GET)
    public ResponseEntity<Avaliacao> getById(@PathVariable(value = "id") long id) {
        Optional<Avaliacao> response = repository.findById(id);
        if (response.isPresent()) {
            return new ResponseEntity<Avaliacao>(response.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/avaliacoes/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Avaliacao> Put(@PathVariable(value = "id") long id,
            @Valid @RequestBody Avaliacao newAvaliacao) {
        Optional<Avaliacao> oldAvaliacao = repository.findById(id);
        if (oldAvaliacao.isPresent()) {
            Avaliacao avaliacao = oldAvaliacao.get();
            avaliacao.setEstrelas(newAvaliacao.getEstrelas());
            avaliacao.setData(newAvaliacao.getData());
            avaliacao.setLikes(newAvaliacao.getLikes());
            avaliacao.setTexto(newAvaliacao.getTexto());
            repository.save(avaliacao);
            return new ResponseEntity<Avaliacao>(avaliacao, HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/avaliacoes/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        Optional<Avaliacao> avaliacao = repository.findById(id);
        if (avaliacao.isPresent()) {
            repository.delete(avaliacao.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}