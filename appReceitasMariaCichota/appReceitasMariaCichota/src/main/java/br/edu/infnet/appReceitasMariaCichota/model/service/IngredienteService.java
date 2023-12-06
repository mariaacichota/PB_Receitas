package br.edu.infnet.appReceitasMariaCichota.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Ingrediente;

@Service
public class IngredienteService {

	private Map<Integer, Ingrediente> mapaIngrediente = new HashMap<Integer, Ingrediente>();
	
	public void incluirIngrediente (Ingrediente ingrediente) {
		mapaIngrediente.put(ingrediente.getCodigo(), ingrediente);
	}
	
	public Collection<Ingrediente> obterListaIngrediente() {
		return mapaIngrediente.values();
	}
}
