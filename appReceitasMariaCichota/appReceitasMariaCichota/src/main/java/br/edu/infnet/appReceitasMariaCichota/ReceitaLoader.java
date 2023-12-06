package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Receita;

public class ReceitaLoader implements ApplicationRunner {
private Map<Integer, Receita> mapaReceita = new HashMap<Integer, Receita>();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("files/receitas.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] campos = null;
		
		while (linha != null) {
			campos = linha.split(";");
			
			Receita receita = new Receita();
			receita.setCodigo(Integer.valueOf(campos[0]));
			receita.setCodigoIngrediente(Integer.valueOf(campos[1]));
			receita.setTitulo(campos[2]);
			receita.setDescricao(campos[3]);
			receita.setQuantidade(Integer.valueOf(campos[4]));
			receita.setMedida(campos[5]);
			receita.setTempoPreparo(Integer.valueOf(campos[6]));
			receita.setAnexos(campos[7]);
			receita.setAprovada(campos[8]);
			receita.setCodigoTipo(Integer.valueOf(campos[9]));
			receita.setCatalogada(campos[10]);
			receita.setDataPublicacao(campos[11]);
			
			mapaReceita.put(receita.getCodigo(), receita);
			
			linha = leitura.readLine();
		}
		
		for(Integer codigo : mapaReceita.keySet()) {
			System.out.println("[CÓDIGO] " + codigo);
		}
		
		for(Receita receita : mapaReceita.values()) {
			System.out.println("[RECEITA] " + receita);
		}
		
		leitura.close();
	}
}
