package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Ingrediente;
import br.edu.infnet.appReceitasMariaCichota.model.service.IngredienteService;

@Component
public class IngredienteLoader implements ApplicationRunner {
	
	@Autowired
	private IngredienteService ingredienteService;
	
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

			ingredienteService.incluirIngrediente(ingrediente);
			
			linha = leitura.readLine();
		}
		
		for(Ingrediente ingrediente : ingredienteService.obterListaIngrediente()) {
			System.out.println("[INGREDIENTE] " + ingrediente);
		}
		
		leitura.close();
	}
}
