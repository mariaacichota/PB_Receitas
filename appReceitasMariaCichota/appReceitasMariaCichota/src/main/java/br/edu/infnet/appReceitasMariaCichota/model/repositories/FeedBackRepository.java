package br.edu.infnet.appReceitasMariaCichota.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appReceitasMariaCichota.model.domain.FeedBack;

@Repository
public interface FeedBackRepository extends CrudRepository<FeedBack, Integer> {

}
