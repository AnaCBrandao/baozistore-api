package com.baozistore.api.controller;

import com.baozistore.api.model.Cliente;
import com.baozistore.api.model.Pedido;
import com.baozistore.api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

  @Autowired
  private PedidoRepository repository;

  @PostMapping
  public Pedido criar(@RequestBody Pedido pedido) {
    return repository.save(pedido);
  }

  @GetMapping
  public List<Pedido> listarTodos() {
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Pedido> buscarPorId(@PathVariable Long id) {
    return repository.findById(id)
        .map(pedido -> ResponseEntity.ok().body(pedido))
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletar(@PathVariable Long id) {
    return repository.findById(id)
        .map(pedido -> {
          repository.deleteById(id);
          return ResponseEntity.noContent().<Void>build();
        })
        .orElse(ResponseEntity.notFound().build());
  }
}