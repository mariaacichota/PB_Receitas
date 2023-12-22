package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Receita;
import br.edu.infnet.appReceitasMariaCichota.model.domain.TipoReceita;
import br.edu.infnet.appReceitasMariaCichota.model.domain.Usuario;
import br.edu.infnet.appReceitasMariaCichota.model.service.ReceitaService;

@Order(4)
@Component
public class ReceitaLoader implements ApplicationRunner {
	@Autowired
	private ReceitaService receitaService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("files/receitas.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] campos = null;
		
		while (linha != null) {
			campos = linha.split(";");

			Usuario usuario = new Usuario();
			usuario.setId(Integer.valueOf(campos[10]));

			TipoReceita tipoReceita = new TipoReceita();
			tipoReceita.setId(Integer.valueOf(campos[9]));

			Receita receita = new Receita();
			receita.setTitulo(campos[0]);
			receita.setDescricao(campos[1]);
			receita.setQuantidade(Double.valueOf(campos[2]));
			receita.setMedida(campos[3]);
			receita.setTempoPreparo(Integer.valueOf(campos[4]));
			receita.setAnexos(campos[5]);
			receita.setAprovada(campos[6]);
			receita.setCatalogada(campos[7]);
		    receita.setDataPublicacao(LocalDate.parse(campos[8]));
			
			receitaService.incluirReceita(receita);
			
			linha = leitura.readLine();
		}
		
		for(Receita receita : receitaService.obterListaReceita()) {
			System.out.println("[RECEITA] " + receita);
		}
		
		leitura.close();
	}
}
