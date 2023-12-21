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

import br.edu.infnet.appReceitasMariaCichota.model.domain.FeedBack;
import br.edu.infnet.appReceitasMariaCichota.model.service.FeedBackService;

@RestController
@RequestMapping(value = "/api/feedBack")
public class FeedBackController {

	@Autowired
	private FeedBackService FeedBackService;
	
	@GetMapping(value = "/listar")
	public List<FeedBack> obterLista(){
		return (List<FeedBack>) FeedBackService.obterListaFeedBack();
	}
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody FeedBack FeedBack){
		FeedBackService.incluirFeedBack(FeedBack);
	}
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id){
		FeedBackService.excluir(id);
	}
	
}
