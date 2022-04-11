package br.exaltagame.backgame.repository;

import org.springframework.stereotype.Repository;

import br.exaltagame.backgame.entity.Avaliacao;
import br.exaltagame.backgame.entity.Membro;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {

}