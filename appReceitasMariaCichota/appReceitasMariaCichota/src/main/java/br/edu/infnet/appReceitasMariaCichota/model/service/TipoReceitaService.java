package br.edu.infnet.appReceitasMariaCichota.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitasMariaCichota.model.domain.TipoReceita;
import br.edu.infnet.appReceitasMariaCichota.model.repositories.TipoReceitaRepository;

@Service
public class TipoReceitaService {
	@Autowired
	private TipoReceitaRepository tipoReceitaRepository;
	
	public void incluirTipoReceita (TipoReceita tipoReceita) {
		tipoReceitaRepository.save(tipoReceita);
	}
	
	public Collection<TipoReceita> obterListaTipoReceita() {
		return (Collection<TipoReceita>) tipoReceitaRepository.findAll();
	}
}
