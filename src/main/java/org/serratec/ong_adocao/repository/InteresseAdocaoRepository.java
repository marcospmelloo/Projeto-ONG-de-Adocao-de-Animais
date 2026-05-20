package org.serratec.ong_adocao.repository;

import org.serratec.ong_adocao.domain.InteresseAdocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InteresseAdocaoRepository extends JpaRepository<InteresseAdocao, Long> {
}
