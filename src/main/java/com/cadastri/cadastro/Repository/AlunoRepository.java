package com.cadastri.cadastro.Repository;

import com.cadastri.cadastro.Model.Aluno;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AlunoRepository extends CrudRepository<Aluno, String> {
    Aluno findById(long id);
    boolean existsByCpfOrRg(String cpf, String rg);
}
