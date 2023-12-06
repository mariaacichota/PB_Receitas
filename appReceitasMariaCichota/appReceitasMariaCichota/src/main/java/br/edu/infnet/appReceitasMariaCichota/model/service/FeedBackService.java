package br.edu.infnet.appReceitasMariaCichota.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitasMariaCichota.model.domain.FeedBack;

@Service
public class FeedBackService {
	private Map<Integer, FeedBack> mapaFeedBack = new HashMap<Integer, FeedBack>();
	
	public void incluirFeedBack (FeedBack feedback) {
		mapaFeedBack.put(feedback.getCodigo(), feedback);
	}
	
	public Collection<FeedBack> obterListaFeedBack() {
		return mapaFeedBack.values();
	}
}
