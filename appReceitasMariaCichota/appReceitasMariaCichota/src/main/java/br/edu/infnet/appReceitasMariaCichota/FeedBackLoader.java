package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitasMariaCichota.model.domain.FeedBack;
import br.edu.infnet.appReceitasMariaCichota.model.domain.Receita;
import br.edu.infnet.appReceitasMariaCichota.model.domain.Usuario;
import br.edu.infnet.appReceitasMariaCichota.model.service.FeedBackService;

@Order(6)
@Component
public class FeedBackLoader implements ApplicationRunner {
	
	@Autowired
	private FeedBackService feedbackService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		FileReader file = new FileReader("files/feedbacks.txt");
		BufferedReader leitura = new BufferedReader(file);
		
		String linha = leitura.readLine();
		String[] campos = null;
		
		while (linha != null) {
			campos = linha.split(";");

			Usuario usuario = new Usuario();
			usuario.setId(Integer.valueOf(campos[3]));
			
			Receita receita = new Receita();
			receita.setId(Integer.valueOf(campos[4]));
			
			FeedBack feedback = new FeedBack();
			feedback.setDescricao(campos[0]);
			feedback.setCodigoReceita(receita);
			feedback.setiLike(Integer.valueOf(campos[1]));
			feedback.setiDeslike(Integer.valueOf(campos[2]));
			feedback.setUsuario(usuario);
			
			feedbackService.incluirFeedBack(feedback);
			
			linha = leitura.readLine();
		}
		
		for(FeedBack feedback : feedbackService.obterListaFeedBack()) {
			System.out.println("[FEEDBACK] " + feedback);
		}
		
		leitura.close();
	}
}
