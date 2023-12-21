package br.edu.infnet.appReceitasMariaCichota.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Endereco;
import br.edu.infnet.appReceitasMariaCichota.model.domain.Usuario;
import br.edu.infnet.appReceitasMariaCichota.model.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EnderecoService enderecoService;
	
	public void incluirUsuario(Usuario usuario) {
		
		String cep = usuario.getEndereco().getCep();
		
		Endereco endereco = enderecoService.buscarCep(cep);
		
		usuario.setEndereco(endereco);
		
		usuarioRepository.save(usuario);	
		
	}
	
	public Collection<Usuario> obterListaUsuario() {
		return (Collection<Usuario>) usuarioRepository.findAll();
	}

	public void excluir (Integer id) {
		usuarioRepository.deleteById(id);
	}
}
