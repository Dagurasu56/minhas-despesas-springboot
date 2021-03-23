package com.dagurasu.minhasdespesas.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dagurasu.minhasdespesas.model.Despesa;
import com.dagurasu.minhasdespesas.service.DespesaService;

@Controller("/minhas-despesas")
public class DespesaController {

	@Autowired
	private DespesaService service;

	@GetMapping("/todas")
	public ResponseEntity<List<Despesa>> findAll() {
		List<Despesa> lista = service.findAll();
		return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Despesa> findById(@PathVariable Long id) {
		Despesa despesa = this.service.findById(id);
		return ResponseEntity.ok().body(despesa);
	}

	@PutMapping("/editar/{id}")
	public ResponseEntity<Despesa> update(@PathVariable Long id, @RequestBody Despesa despesa) {
		Despesa novaDespesa = service.update(id, despesa);
		return ResponseEntity.ok().body(novaDespesa);
	}

	@PostMapping("/nova")
	public ResponseEntity<Despesa> create(@RequestBody Despesa despesa) {
		Despesa novaDespesa = service.create(despesa);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(novaDespesa.getId())
				.toUri();
		return ResponseEntity.created(uri).body(novaDespesa);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.findById(id);
		return ResponseEntity.noContent().build();
	}

}
