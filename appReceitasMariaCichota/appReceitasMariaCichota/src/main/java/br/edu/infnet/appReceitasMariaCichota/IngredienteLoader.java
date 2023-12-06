package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Ingrediente;

@Component
public class IngredienteLoader implements ApplicationRunner {
	private Map<Integer, Ingrediente> mapaIngrediente = new HashMap<Integer, Ingrediente>();
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("files/ingredientes.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] campos = null;
		
		while (linha != null) {
			campos = linha.split(";");
			
			Ingrediente ingrediente = new Ingrediente();
			ingrediente.setCodigo(Integer.valueOf(campos[0]));
			ingrediente.setDescricao(campos[1]);
			
			mapaIngrediente.put(ingrediente.getCodigo(), ingrediente);
			
			linha = leitura.readLine();
		}
		
		for(Integer codigo : mapaIngrediente.keySet()) {
			System.out.println("[CÓDIGO] " + codigo);
		}
		
		for(Ingrediente ingrediente : mapaIngrediente.values()) {
			System.out.println("[INGREDIENTE] " + ingrediente);
		}
		
		leitura.close();
	}
}
