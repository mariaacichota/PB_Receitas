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

import br.edu.infnet.appReceitasMariaCichota.model.domain.TipoReceita;
import br.edu.infnet.appReceitasMariaCichota.model.service.TipoReceitaService;


@RestController
@RequestMapping("/api/tipoReceita")
public class TipoReceitaController {

	@Autowired
	private TipoReceitaService tipoReceitaService;
	
	@GetMapping(value = "/listar")
	public List<TipoReceita> obterLista(){
		return (List<TipoReceita>) tipoReceitaService.obterListaTipoReceita();
	}
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody TipoReceita tipoReceita){
		tipoReceitaService.incluirTipoReceita(tipoReceita);
	}
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id){
		tipoReceitaService.excluir(id);
	}
	
}
