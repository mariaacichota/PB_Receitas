package br.edu.infnet.appReceitasMariaCichota;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.infnet.appReceitasMariaCichota.model.domain.FeedBack;

@Component
public class FeedBackLoader implements ApplicationRunner {
	private Map<Integer, FeedBack> mapaFeedBack = new HashMap<Integer, FeedBack>();
	
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
			
			mapaFeedBack.put(feedback.getCodigo(), feedback);
			
			linha = leitura.readLine();
		}
		
		for(Integer codigo : mapaFeedBack.keySet()) {
			System.out.println("[CÓDIGO] " + codigo);
		}
		
		for(FeedBack feedback : mapaFeedBack.values()) {
			System.out.println("[FEEDBACK] " + feedback);
		}
		
		leitura.close();
	}
}
