package br.edu.infnet.appReceitasMariaCichota.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.appReceitasMariaCichota.model.domain.Ingrediente;

@Repository
public interface IngredienteRepository extends CrudRepository<Ingrediente, Integer> {

}
