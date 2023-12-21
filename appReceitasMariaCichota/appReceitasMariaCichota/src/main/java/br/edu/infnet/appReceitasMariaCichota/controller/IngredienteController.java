package br.edu.infnet.appReceitasMariaCichota.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Ingrediente;
import br.edu.infnet.appReceitasMariaCichota.model.service.IngredienteService;

@RestController
@RequestMapping(value = "/api/ingrediente")
public class IngredienteController {

	@Autowired
	private IngredienteService IngredienteService;
	
	@GetMapping(value = "/listar")
	public List<Ingrediente> obterLista(){
		return (List<Ingrediente>) IngredienteService.obterListaIngrediente();
	}
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Ingrediente Ingrediente){
		IngredienteService.incluirIngrediente(Ingrediente);
	}
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id){
		IngredienteService.excluir(id);
	}
	
}
