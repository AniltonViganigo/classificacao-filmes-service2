package br.com.meunetflix.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.meunetflix.model.Classificacao;
import br.com.meunetflix.services.ClassificacaoService;

@RestController
@RequestMapping("classificacoes")
public class ClassificacaoApi {

	@Autowired
	private ClassificacaoService classificacaoService;

	public ClassificacaoApi() {
	}

	@PostMapping
	public Classificacao create(@RequestBody Classificacao classificacao) throws Exception {
		return this.classificacaoService.save(classificacao);
	}

	@GetMapping("{classificacao}/idades/{idade}")
	public String classificacaoResultado(@PathVariable("classificacao") String classificacao,
			@PathVariable("idade") Integer idade) {

		return this.classificacaoService.evaluate(classificacao, idade);

	}

}
