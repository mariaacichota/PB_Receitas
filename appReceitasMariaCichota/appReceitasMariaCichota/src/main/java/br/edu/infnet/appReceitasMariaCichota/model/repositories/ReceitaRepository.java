package br.edu.infnet.appReceitasMariaCichota.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Receita;

@Repository
public interface ReceitaRepository extends CrudRepository<Receita, Integer> {

}
