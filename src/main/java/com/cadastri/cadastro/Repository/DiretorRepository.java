package com.cadastri.cadastro.Repository;

import com.cadastri.cadastro.Model.Diretor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.core.CrudMethods;
import org.springframework.stereotype.Repository;

@Repository
public interface DiretorRepository extends CrudRepository<Diretor, String> {

}
