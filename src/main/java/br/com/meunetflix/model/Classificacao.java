package br.com.meunetflix.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document("classificacoes")
@Getter
@Setter
public class Classificacao {

	@Id
	private String id;
	private Integer idadeMinima;
	private String sigla;
}
