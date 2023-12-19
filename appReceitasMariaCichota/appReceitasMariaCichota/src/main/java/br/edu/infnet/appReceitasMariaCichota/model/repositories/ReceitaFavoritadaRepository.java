package br.edu.infnet.appReceitasMariaCichota.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appReceitasMariaCichota.model.domain.ReceitaFavoritada;

@Repository
public interface ReceitaFavoritadaRepository extends CrudRepository<ReceitaFavoritada, Integer> {

}
