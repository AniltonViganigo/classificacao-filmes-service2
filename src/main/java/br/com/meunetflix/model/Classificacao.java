package br.com.meunetflix.model;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Classificacao {

	@Id
	private String id;
	private Integer idadeMinima;
	private String sigla;
}
