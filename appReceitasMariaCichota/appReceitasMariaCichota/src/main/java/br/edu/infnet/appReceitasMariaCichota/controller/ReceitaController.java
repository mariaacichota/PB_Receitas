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

import br.edu.infnet.appReceitasMariaCichota.model.domain.Receita;
import br.edu.infnet.appReceitasMariaCichota.model.service.ReceitaService;

@RestController
@RequestMapping(value = "/api/receita")
public class ReceitaController {

	@Autowired
	private ReceitaService receitaService;
	
	@GetMapping(value = "/listar")
	public List<Receita> obterLista(){
		return (List<Receita>) receitaService.obterListaReceita();
	}
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Receita receita){
		receitaService.incluirReceita(receita);
	}
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id){
		receitaService.excluir(id);
	}
	
}
