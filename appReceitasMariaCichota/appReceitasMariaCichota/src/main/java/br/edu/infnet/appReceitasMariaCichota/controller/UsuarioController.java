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

import br.edu.infnet.appReceitasMariaCichota.model.domain.Usuario;
import br.edu.infnet.appReceitasMariaCichota.model.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@GetMapping(value = "/listar")
	public List<Usuario> obterLista(){
		return (List<Usuario>) usuarioService.obterListaUsuario();
	}
	
	@PostMapping(value = "/incluir")
	public void incluir(@RequestBody Usuario usuario){
		usuarioService.incluirUsuario(usuario);
	}
	
	@DeleteMapping(value = "/{id}/excluir")
	public void excluir(@PathVariable Integer id){
		usuarioService.excluir(id);
	}
	
}
