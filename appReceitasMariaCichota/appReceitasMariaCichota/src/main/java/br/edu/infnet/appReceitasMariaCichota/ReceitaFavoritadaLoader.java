package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Receita;
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
			usuario.setId(Integer.valueOf(campos[4]));
			
			Receita receita = new Receita();
			receita.setId(Integer.valueOf(campos[0]));
			
			ReceitaFavoritada receitaFavoritada = new ReceitaFavoritada();
			receitaFavoritada.setCodigoReceita(receita);
			receitaFavoritada.setDataModificacao(campos[1]);
			receitaFavoritada.setiLike(Integer.valueOf(campos[2]));
			receitaFavoritada.setiDeslike(Integer.valueOf(campos[3]));
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
