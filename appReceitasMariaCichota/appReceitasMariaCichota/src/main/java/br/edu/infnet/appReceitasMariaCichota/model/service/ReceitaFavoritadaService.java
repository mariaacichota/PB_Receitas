package br.edu.infnet.appReceitasMariaCichota.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitasMariaCichota.model.domain.ReceitaFavoritada;

@Service
public class ReceitaFavoritadaService {
	private Map<Integer, ReceitaFavoritada> mapaReceitaFavoritada = new HashMap<Integer, ReceitaFavoritada>();
	
	
	public void incluirReceitaFavoritada (ReceitaFavoritada receitaFavoritada) {
		mapaReceitaFavoritada.put(receitaFavoritada.getCodigo(), receitaFavoritada);
	}
	
	public Collection<ReceitaFavoritada> obterListaReceitaFavoritada() {
		return mapaReceitaFavoritada.values();
	}
}
