package br.com.meunetflix.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.meunetflix.model.Classificacao;

@Repository
public interface ClassificacaoRepository extends MongoRepository<Classificacao, String> {
	List<Classificacao> findBySiglaIgnoringCase(String sigla);
	Classificacao findTop1BySiglaIgnoringCase(String sigla);

	
}
