package com.example.petshop.controller;

import com.example.petshop.cadastro.Cadastro;
import com.example.petshop.cadastro.CadastroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/cadastro")
public class CadastroController {

    @Autowired
    private CadastroRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public ResponseEntity <List<Cadastro>> getAll(){

        List<Cadastro> cadastroList = repository.findAll();
        return ResponseEntity.ok(cadastroList);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/post")
    public ResponseEntity<String> create(@RequestBody Cadastro cadastro) {

        Cadastro novoCadastro = repository.save(cadastro);
        return new ResponseEntity<>( "Cadastro realizado com sucesso!",HttpStatus.CREATED);

    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/{id}")
    public ResponseEntity<String> update(@RequestBody Cadastro cadastro, @PathVariable Long id){
        Cadastro cadastroAtualizado =repository.getReferenceById(id);

        if(!repository.existsById(id)){
            return new ResponseEntity<>("Id não encontrado", HttpStatus.NOT_FOUND);
        }

        repository.save(cadastro);
        return new ResponseEntity<>("Cadastro do " + id +" atualizado com sucesso ", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){

        if (!repository.existsById(id)) {
            return new ResponseEntity<>("Não tem cadastro com esse id!", HttpStatus.NOT_FOUND);
        }

        repository.deleteById(id);
        return new ResponseEntity<>("Item deletado com sucesso", HttpStatus.OK);

    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping
    public ResponseEntity<String> delete() {
        return new ResponseEntity<>("Por favor, forneça um id para deletar um item específico.", HttpStatus.BAD_REQUEST);
    }

}
