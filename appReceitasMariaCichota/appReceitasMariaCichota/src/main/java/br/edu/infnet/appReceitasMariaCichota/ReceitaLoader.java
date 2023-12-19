package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Ingrediente;
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
			
			Ingrediente ingrediente = new Ingrediente();
			ingrediente.setCodigo(Integer.valueOf(campos[22]));
			ingrediente.setDescricao(campos[23]);
			
			Receita receita = new Receita();
			receita.setCodigo(Integer.valueOf(campos[0]));
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
			receita.setTipoReceita(new TipoReceita(Integer.valueOf(campos[12]), (campos[13])));
			receita.setUsuario(new Usuario(Integer.valueOf(campos[14]), (campos[15]), (campos[16]), 
									(campos[17]), (campos[18]), (campos[19]), (campos[20]), (campos[21])));
			receita.setIngredientes(new ArrayList<Ingrediente>());
			
			receita.getIngredientes().add(ingrediente);
			
			receitaService.incluirReceita(receita);
			
			linha = leitura.readLine();
		}
		
		for(Receita receita : receitaService.obterListaReceita()) {
			System.out.println("[RECEITA] " + receita);
		}
		
		leitura.close();
	}
}
