package br.edu.infnet.appReceitasMariaCichota.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Receita;

@Service
public class ReceitaService {
	private Map<Integer, Receita> mapaReceita = new HashMap<Integer, Receita>();
	
	public void incluirReceita (Receita receita) {
		mapaReceita.put(receita.getCodigo(), receita);
	}
	
	public Collection<Receita> obterListaReceita() {
		return mapaReceita.values();
	}
}
