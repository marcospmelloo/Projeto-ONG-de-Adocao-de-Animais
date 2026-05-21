package org.serratec.ong_adocao.repository;

import org.serratec.ong_adocao.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
    boolean existsByCpf(String cpf);
    boolean existsByEmail(String Email);
}
