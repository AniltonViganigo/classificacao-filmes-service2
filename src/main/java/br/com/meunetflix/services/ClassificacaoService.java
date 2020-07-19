package br.com.meunetflix.services;

import java.util.List;
import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.meunetflix.model.Classificacao;
import br.com.meunetflix.repositories.ClassificacaoRepository;

@Service
public class ClassificacaoService {

	@Autowired
	private ClassificacaoRepository classificacaoRepository;

	private static final String MENSAGEM_OK = "Você está apto a ver o filme!";
	private static final String MENSAGEM_NOK = "Desculpe, este título não está disponível para a sua idade!";

	public Classificacao save(Classificacao classificacao) throws Exception {
		List<Classificacao> categorias = this.classificacaoRepository.findBySigla(classificacao.getSigla());
		if (categorias.size() > 0) {
			throw new Exception("Categoria já existente.");
		}
		return this.classificacaoRepository.save(classificacao);
	}

	public String evaluate(String sigla, Integer idade) {
		boolean apto = false;

		Classificacao classificacao = this.classificacaoRepository.findTop1BySiglaIgnoringCase(sigla);
		if (classificacao != null  && idade >= classificacao.getIdadeMinima()) {
			apto = true;
		}
		
		if (apto) {
			return MENSAGEM_OK;
		} else {
			return MENSAGEM_NOK;
		}
	}
}
