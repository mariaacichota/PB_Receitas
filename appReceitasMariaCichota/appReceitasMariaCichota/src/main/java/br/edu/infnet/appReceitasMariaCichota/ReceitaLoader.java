package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;

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
			usuario.setId(Integer.valueOf(campos[5]));

			TipoReceita tipoReceita = new TipoReceita();
			tipoReceita.setId(Integer.valueOf(campos[12]));
			
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
			receita.setTipoReceita(tipoReceita);
			receita.setUsuario(usuario);
			
			receitaService.incluirReceita(receita);
			
			linha = leitura.readLine();
		}
		
		for(Receita receita : receitaService.obterListaReceita()) {
			System.out.println("[RECEITA] " + receita);
		}
		
		leitura.close();
	}
}
