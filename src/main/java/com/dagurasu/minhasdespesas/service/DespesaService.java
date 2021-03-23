package com.dagurasu.minhasdespesas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dagurasu.minhasdespesas.exception.DespesaNotFoundException;
import com.dagurasu.minhasdespesas.model.Despesa;
import com.dagurasu.minhasdespesas.repositories.DespesaRepository;

@Service
public class DespesaService {

	@Autowired
	private DespesaRepository repository;

	public List<Despesa> findAll() {
		return repository.findAll();
	}

	public Despesa findById(Long id) {
		Optional<Despesa> despesa = repository.findById(id);
		return despesa.orElseThrow(() -> new DespesaNotFoundException(
				"Despesa não encontrada! Id: " + id + ", Descrição: " + Despesa.class.getName()));
	}

	public Despesa update(Long id, Despesa despesa) {
		Despesa novaDespesa = findById(id);
		novaDespesa.setDescricao(despesa.getDescricao());
		novaDespesa.setDataVencimento(despesa.getDataVencimento());

		return repository.save(novaDespesa);
	}

	public Despesa create(Despesa despesa) {
		despesa.setId(null);
		return repository.save(despesa);
	}

	public void delete(Long id) {
		findById(id);
		repository.deleteById(id);
	}

}
