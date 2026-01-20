package emily.amorim.desafio_tecnico.controller;

import emily.amorim.desafio_tecnico.entity.Projeto;
import emily.amorim.desafio_tecnico.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService service;

    @PostMapping
    public ResponseEntity<Projeto> create(@RequestBody Projeto obj){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(obj));
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Projeto> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Projeto> getId(@PathVariable Long id){
        return ResponseEntity.ok().body(service.getId(id));
    }

    @GetMapping
    public ResponseEntity<List<Projeto>> getId(){
        return ResponseEntity.ok().body(service.getAll());
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Projeto> update(@PathVariable Long id, @RequestBody Projeto obj){
        obj.setId(id);
        return ResponseEntity.ok().body(service.update(obj));
    }




}
