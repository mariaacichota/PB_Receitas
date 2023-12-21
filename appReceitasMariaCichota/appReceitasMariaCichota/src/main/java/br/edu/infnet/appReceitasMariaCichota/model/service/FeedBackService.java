package br.edu.infnet.appReceitasMariaCichota.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitasMariaCichota.model.domain.FeedBack;
import br.edu.infnet.appReceitasMariaCichota.model.repositories.FeedBackRepository;

@Service
public class FeedBackService {
	@Autowired
	private FeedBackRepository feedbackRepository;
	
	public void incluirFeedBack (FeedBack feedback) {
		feedbackRepository.save(feedback);
	}
	
	public Collection<FeedBack> obterListaFeedBack() {
		return (Collection<FeedBack>) feedbackRepository.findAll();
	}

	public void excluir (Integer id) {
		feedbackRepository.deleteById(id);
	}
}
