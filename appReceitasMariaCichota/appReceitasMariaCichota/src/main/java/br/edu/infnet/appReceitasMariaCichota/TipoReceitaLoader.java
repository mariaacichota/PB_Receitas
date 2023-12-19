package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitasMariaCichota.model.domain.TipoReceita;
import br.edu.infnet.appReceitasMariaCichota.model.service.TipoReceitaService;

@Order(2)
@Component
public class TipoReceitaLoader implements ApplicationRunner {

	@Autowired
	private TipoReceitaService tipoReceitaService; 
	
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
			
			tipoReceitaService.incluirTipoReceita(tipoReceita);
			
			linha = leitura.readLine();
		}
		
		for(TipoReceita tipoReceita : tipoReceitaService.obterListaTipoReceita()) {
			System.out.println("[TIPO RECEITA] " + tipoReceita);
		}
		
		leitura.close();
	}
}
