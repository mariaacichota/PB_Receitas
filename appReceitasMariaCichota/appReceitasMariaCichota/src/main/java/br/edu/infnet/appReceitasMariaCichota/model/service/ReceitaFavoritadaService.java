package br.edu.infnet.appReceitasMariaCichota.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitasMariaCichota.model.domain.ReceitaFavoritada;
import br.edu.infnet.appReceitasMariaCichota.model.repositories.ReceitaFavoritadaRepository;

@Service
public class ReceitaFavoritadaService {
	@Autowired
	private ReceitaFavoritadaRepository receitaFavoritadaRepository;
	
	public void incluirReceitaFavoritada (ReceitaFavoritada receitaFavoritada) {
		receitaFavoritadaRepository.save(receitaFavoritada);
	}
	
	public Collection<ReceitaFavoritada> obterListaReceitaFavoritada() {
		return (Collection<ReceitaFavoritada>) receitaFavoritadaRepository.findAll();
	}
}
