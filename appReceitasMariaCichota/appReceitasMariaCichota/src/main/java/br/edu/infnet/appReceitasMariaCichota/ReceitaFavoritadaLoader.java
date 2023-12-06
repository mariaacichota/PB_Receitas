package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import br.edu.infnet.appReceitasMariaCichota.model.domain.ReceitaFavoritada;

public class ReceitaFavoritadaLoader implements ApplicationRunner {
private Map<Integer, ReceitaFavoritada> mapaReceitaFavoritada = new HashMap<Integer, ReceitaFavoritada>();
	
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
			
			mapaReceitaFavoritada.put(receitaFavoritada.getCodigo(), receitaFavoritada);
			
			linha = leitura.readLine();
		}
		
		for(Integer codigo : mapaReceitaFavoritada.keySet()) {
			System.out.println("[CÓDIGO] " + codigo);
		}
		
		for(ReceitaFavoritada receitaFavoritada : mapaReceitaFavoritada.values()) {
			System.out.println("[RECEITA FAVORITADA] " + receitaFavoritada);
		}
		
		leitura.close();
	}
}
