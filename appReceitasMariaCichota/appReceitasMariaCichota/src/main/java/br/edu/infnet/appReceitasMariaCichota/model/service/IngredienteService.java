package br.edu.infnet.appReceitasMariaCichota.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Ingrediente;
import br.edu.infnet.appReceitasMariaCichota.model.repositories.IngredienteRepository;

@Service
public class IngredienteService {
	@Autowired
	private IngredienteRepository ingredienteRepository;
	
	public void incluirIngrediente (Ingrediente ingrediente) {
		ingredienteRepository.save(ingrediente);
	}
	
	public Collection<Ingrediente> obterListaIngrediente() {
		return (Collection<Ingrediente>) ingredienteRepository.findAll();
	}

	public void excluir (Integer id) {
		ingredienteRepository.deleteById(id);
	}
}
