package br.edu.infnet.appReceitasMariaCichota.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infnet.appReceitasMariaCichota.clients.IEnderecoClient;
import br.edu.infnet.appReceitasMariaCichota.model.domain.Endereco;

@Service
public class EnderecoService {
	@Autowired
	private IEnderecoClient enderecoClient;
	
	public Endereco buscarCep(String cep) {
		return enderecoClient.buscarCep(cep);
	}
}
