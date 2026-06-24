package com.baozistore.api.controller;

import com.baozistore.api.model.Cliente;
import com.baozistore.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

  @Autowired
  private ClienteRepository repository;

  @PostMapping
  public Cliente criar(@RequestBody Cliente cliente) {
    return repository.save(cliente);
  }

  @GetMapping
  public List<Cliente> listarTodos() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
    return repository.findById(id)
        .map(cliente -> ResponseEntity.ok().body(cliente))
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    return repository.findById(id)
        .map(cliente -> {
          repository.deleteById(id);
          return ResponseEntity.noContent().<Void>build();
        })
        .orElse(ResponseEntity.notFound().build());
  }
}