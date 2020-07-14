package br.com.meunetflix;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClassificacaoApi {

	private static final String MENSAGEM_OK = "Você está apto a ver o filme!";
	private static final String MENSAGEM_NOK = "Desculpe, este título não está disponível para a sua idade!";

	public ClassificacaoApi() {
	}

	@GetMapping("classificacoes/{classificacao}/idades/{idade}")
	public String classificacaoResultado(@PathVariable("classificacao") String classificacao, @PathVariable("idade") Integer idade){
		
		boolean apto = classificacao.equals("L") | 
				classificacao.equals("PA") && idade >=12 |
				classificacao.equals("AD") && idade >=14 |
				classificacao.equals("MI") && idade >=18;
		
		if (apto) {
			return MENSAGEM_OK;
		} else {
			return MENSAGEM_NOK;
		}
		
	}

}
