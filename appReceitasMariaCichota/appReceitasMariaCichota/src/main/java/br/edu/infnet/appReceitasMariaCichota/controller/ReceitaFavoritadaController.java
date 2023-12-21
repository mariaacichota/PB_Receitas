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

import br.edu.infnet.appReceitasMariaCichota.model.domain.ReceitaFavoritada;
import br.edu.infnet.appReceitasMariaCichota.model.service.ReceitaFavoritadaService;

@RestController
@RequestMapping(value = "/api/receitaFavoritada")
public class ReceitaFavoritadaController {

	@Autowired
	private ReceitaFavoritadaService receitaFavoritadaService;
	
	@GetMapping(value = "/listar")
	public List<ReceitaFavoritada> obterLista(){
		return (List<ReceitaFavoritada>) receitaFavoritadaService.obterListaReceitaFavoritada();
	}
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody ReceitaFavoritada receitaFavoritada){
		receitaFavoritadaService.incluirReceitaFavoritada(receitaFavoritada);
	}
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id){
		receitaFavoritadaService.excluir(id);
	}
	
}
