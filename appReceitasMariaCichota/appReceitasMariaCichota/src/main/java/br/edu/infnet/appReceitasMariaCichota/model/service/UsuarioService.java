package br.edu.infnet.appReceitasMariaCichota.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Usuario;

@Service
public class UsuarioService {
	private Map<Integer, Usuario> mapaUsuario = new HashMap<Integer, Usuario>();
	
	public void incluirUsuario(Usuario usuario) {
		mapaUsuario.put(usuario.getCodigo(), usuario);
		
	}
	
	public Collection<Usuario> obterListaUsuario() {
		return mapaUsuario.values();
	}

}
