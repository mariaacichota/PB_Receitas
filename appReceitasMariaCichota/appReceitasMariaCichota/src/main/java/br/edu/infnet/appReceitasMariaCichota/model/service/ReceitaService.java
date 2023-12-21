package br.edu.infnet.appReceitasMariaCichota.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Receita;
import br.edu.infnet.appReceitasMariaCichota.model.repositories.ReceitaRepository;

@Service
public class ReceitaService {
	@Autowired
	private ReceitaRepository receitaRepository;
	
	public void incluirReceita (Receita receita) {
		receitaRepository.save(receita);
	}
	
	public Collection<Receita> obterListaReceita() {
		return (Collection<Receita>) receitaRepository.findAll();
	}

	public void excluir (Integer id) {
		receitaRepository.deleteById(id);
	}
}
