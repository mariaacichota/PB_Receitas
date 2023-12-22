package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Ingrediente;
import br.edu.infnet.appReceitasMariaCichota.model.domain.Receita;
import br.edu.infnet.appReceitasMariaCichota.model.service.IngredienteService;

@Order(3)
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
			
		//	Receita receita = new Receita();
		//	receita.setId(Integer.valueOf(campos[1]));
			
			Ingrediente ingrediente = new Ingrediente();
			ingrediente.setDescricao(campos[0]);
		//	ingrediente.setReceita(receita);

			ingredienteService.incluirIngrediente(ingrediente);
			
			linha = leitura.readLine();
		}
		
		for(Ingrediente ingrediente : ingredienteService.obterListaIngrediente()) {
			System.out.println("[INGREDIENTE] " + ingrediente);
		}
		
		leitura.close();
	}
}
