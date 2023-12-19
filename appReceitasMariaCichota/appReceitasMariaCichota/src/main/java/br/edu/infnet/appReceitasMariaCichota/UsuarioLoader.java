package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Usuario;
import br.edu.infnet.appReceitasMariaCichota.model.service.UsuarioService;

@Order(1)
@Component
public class UsuarioLoader implements ApplicationRunner {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("files/usuarios.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] campos = null;
		
		while (linha != null) {
			campos = linha.split(";");
			
			Usuario usuario = new Usuario();
			usuario.setCodigo(Integer.valueOf(campos[0]));
			usuario.setNome(campos[1]);
			usuario.setEndereco(campos[2]);
			usuario.setEmail(campos[3]);
			usuario.setTelefone(campos[4]);
			usuario.setSenha(campos[5]);
			usuario.setFoto(campos[6]);
			usuario.setDescricao(campos[7]);
			
			usuarioService.incluirUsuario(usuario);
			
			linha = leitura.readLine();
		}
		
		for(Usuario usuario : usuarioService.obterListaUsuario()) {
			System.out.println("[USUÁRIO] " + usuario);
		}
		
		leitura.close();
	}
	
}
