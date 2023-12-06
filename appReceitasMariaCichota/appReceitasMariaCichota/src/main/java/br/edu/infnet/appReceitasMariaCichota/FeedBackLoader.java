package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitasMariaCichota.model.domain.FeedBack;
import br.edu.infnet.appReceitasMariaCichota.model.service.FeedBackService;

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
			
			FeedBack feedback = new FeedBack();
			feedback.setCodigo(Integer.valueOf(campos[0]));
			feedback.setDescricao(campos[1]);
			feedback.setCodigoUsuario(Integer.valueOf(campos[2]));
			feedback.setCodigoReceita(Integer.valueOf(campos[3]));
			feedback.setLike(Integer.valueOf(campos[4]));
			feedback.setDeslike(Integer.valueOf(campos[5]));
			
			feedbackService.incluirFeedBack(feedback);
			
			linha = leitura.readLine();
		}
		
		for(FeedBack feedback : feedbackService.obterListaFeedBack()) {
			System.out.println("[FEEDBACK] " + feedback);
		}
		
		leitura.close();
	}
}
