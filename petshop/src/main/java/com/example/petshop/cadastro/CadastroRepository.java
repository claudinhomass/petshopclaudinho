package com.example.petshop.cadastro;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CadastroRepository extends JpaRepository <Cadastro, Long>{

    List<Cadastro> findAll();

}
