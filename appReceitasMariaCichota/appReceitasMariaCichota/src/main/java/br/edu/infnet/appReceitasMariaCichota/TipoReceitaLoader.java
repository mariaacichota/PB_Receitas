package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import br.edu.infnet.appReceitasMariaCichota.model.domain.TipoReceita;

public class TipoReceitaLoader implements ApplicationRunner {
private Map<Integer, TipoReceita> mapaTipoReceita = new HashMap<Integer, TipoReceita>();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("files/tiposreceita.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] campos = null;
		
		while (linha != null) {
			campos = linha.split(";");
			
			TipoReceita tipoReceita = new TipoReceita();
			tipoReceita.setCodigo(Integer.valueOf(campos[0]));
			tipoReceita.setDescricao(campos[1]);
			
			mapaTipoReceita.put(tipoReceita.getCodigo(), tipoReceita);
			
			linha = leitura.readLine();
		}
		
		for(Integer codigo : mapaTipoReceita.keySet()) {
			System.out.println("[CÓDIGO] " + codigo);
		}
		
		for(TipoReceita tipoReceita : mapaTipoReceita.values()) {
			System.out.println("[TIPO RECEITA] " + tipoReceita);
		}
		
		leitura.close();
	}
}
