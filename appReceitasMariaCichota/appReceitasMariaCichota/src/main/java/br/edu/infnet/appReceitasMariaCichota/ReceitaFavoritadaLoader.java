package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitasMariaCichota.model.domain.ReceitaFavoritada;
import br.edu.infnet.appReceitasMariaCichota.model.domain.Usuario;
import br.edu.infnet.appReceitasMariaCichota.model.service.ReceitaFavoritadaService;

@Order(5)
@Component
public class ReceitaFavoritadaLoader implements ApplicationRunner {
	
	@Autowired
	private ReceitaFavoritadaService receitaFavoritadaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("files/receitasfavoritadas.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] campos = null;
		
		while (linha != null) {
			campos = linha.split(";");
			
			Usuario usuario = new Usuario();
			usuario.setCodigo(Integer.valueOf(campos[4]));
			usuario.setNome(campos[5]);
			usuario.setEndereco(campos[6]);
			usuario.setEmail(campos[7]);
			usuario.setTelefone(campos[8]);
			usuario.setSenha(campos[9]);
			usuario.setFoto(campos[10]);
			usuario.setDescricao(campos[11]);
			
			ReceitaFavoritada receitaFavoritada = new ReceitaFavoritada();
			receitaFavoritada.setCodigo(Integer.valueOf(campos[0]));
			receitaFavoritada.setCodigoReceita(Integer.valueOf(campos[1]));
			receitaFavoritada.setDataModificacao(campos[2]);
			receitaFavoritada.setLike(Integer.valueOf(campos[3]));
			receitaFavoritada.setDeslike(Integer.valueOf(campos[4]));
			receitaFavoritada.setUsuario(usuario);
			
			receitaFavoritadaService.incluirReceitaFavoritada(receitaFavoritada);
			
			linha = leitura.readLine();
		}
		
		for(ReceitaFavoritada receitaFavoritada : receitaFavoritadaService.obterListaReceitaFavoritada()) {
			System.out.println("[RECEITA FAVORITADA] " + receitaFavoritada);
		}
		
		leitura.close();
	}
}
