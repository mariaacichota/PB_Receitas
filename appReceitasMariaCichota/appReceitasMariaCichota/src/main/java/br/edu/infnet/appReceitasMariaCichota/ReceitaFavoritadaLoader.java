package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import br.edu.infnet.appReceitasMariaCichota.model.domain.ReceitaFavoritada;
import br.edu.infnet.appReceitasMariaCichota.model.service.ReceitaFavoritadaService;

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
			
			ReceitaFavoritada receitaFavoritada = new ReceitaFavoritada();
			receitaFavoritada.setCodigo(Integer.valueOf(campos[0]));
			receitaFavoritada.setCodigoUsuario(Integer.valueOf(campos[1]));
			receitaFavoritada.setCodigoReceita(Integer.valueOf(campos[2]));
			receitaFavoritada.setDataModificacao(campos[3]);
			receitaFavoritada.setLike(Integer.valueOf(campos[4]));
			receitaFavoritada.setDeslike(Integer.valueOf(campos[5]));
			
			receitaFavoritadaService.incluirReceitaFavoritada(receitaFavoritada);
			
			linha = leitura.readLine();
		}
		
		for(ReceitaFavoritada receitaFavoritada : receitaFavoritadaService.obterListaReceitaFavoritada()) {
			System.out.println("[RECEITA FAVORITADA] " + receitaFavoritada);
		}
		
		leitura.close();
	}
}
