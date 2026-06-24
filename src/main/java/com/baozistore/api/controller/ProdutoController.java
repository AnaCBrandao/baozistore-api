package com.baozistore.api.controller;

import com.baozistore.api.model.Produto;
import com.baozistore.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

  @Autowired
  private ProdutoRepository repository;

  @PostMapping
  public Produto criar(@RequestBody Produto produto) {
    return repository.save(produto);
  }

  @GetMapping
  public List<Produto> listarTodos() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
    return repository.findById(id)
        .map(produto -> ResponseEntity.ok().body(produto))
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    return repository.findById(id)
        .map(produto -> {
          repository.deleteById(id);
          return ResponseEntity.noContent().<Void>build();
        })
        .orElse(ResponseEntity.notFound().build());
  }
}