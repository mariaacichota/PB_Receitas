package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Usuario;

@Component
public class UsuarioLoader implements ApplicationRunner {
	
	private Map<Integer, Usuario> mapaUsuario = new HashMap<Integer, Usuario>();
	
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
			
			mapaUsuario.put(usuario.getCodigo(), usuario);
			
			linha = leitura.readLine();
		}
		
		for(Integer codigo : mapaUsuario.keySet()) {
			System.out.println("[CÓDIGO] " + codigo);
		}
		
		for(Usuario usuario : mapaUsuario.values()) {
			System.out.println("[USUÁRIO] " + usuario);
		}
		
		leitura.close();
	}
	
}
