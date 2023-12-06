package br.edu.infnet.appReceitasMariaCichota.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitasMariaCichota.model.domain.TipoReceita;

@Service
public class TipoReceitaService {
	private Map<Integer, TipoReceita> mapaTipoReceita = new HashMap<Integer, TipoReceita>();
	
	public void incluirTipoReceita (TipoReceita tipoReceita) {
		mapaTipoReceita.put(tipoReceita.getCodigo(), tipoReceita);
	}
	
	public Collection<TipoReceita> obterListaTipoReceita() {
		return mapaTipoReceita.values();
	}
}
