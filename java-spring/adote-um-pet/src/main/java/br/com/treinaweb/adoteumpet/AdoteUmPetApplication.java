package br.com.treinaweb.adoteumpet;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.treinaweb.adoteumpet.core.models.Adocao;
import br.com.treinaweb.adoteumpet.core.models.Pet;
import br.com.treinaweb.adoteumpet.core.repositories.AdocaoRepository;
import br.com.treinaweb.adoteumpet.core.repositories.PetRepository;

@SpringBootApplication
public class AdoteUmPetApplication implements CommandLineRunner {

	@Autowired
	private PetRepository petRepository;

	@Autowired
	private AdocaoRepository adocaoRepository;

	public static void main(String[] args) {
		SpringApplication.run(AdoteUmPetApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/* Pets */
		var pet1 = new Pet();
		pet1.setNome("Totó");
		pet1.setHistoria("historia do pet");
		pet1.setFoto("https://image.cachorrogato.com.br/textimages/cachorrinho-ideal");
		petRepository.save(pet1);

		var pet2 = new Pet();
		pet2.setNome("Malu");
		pet2.setHistoria("historia do pet");
		pet2.setFoto("https://image.cachorrogato.com.br/textimages/cachorrinho-ideal");
		petRepository.save(pet2);

		var pet3 = new Pet();
		pet3.setNome("Thor");
		pet3.setHistoria("historia do pet");
		pet3.setFoto("https://image.cachorrogato.com.br/textimages/cachorrinho-ideal");
		petRepository.save(pet3);

		/* Adoções */
		var adocao1 = new Adocao();
		BigDecimal valor1 = new BigDecimal(50);
		adocao1.setEmail("email@example.com");
		adocao1.setValor(valor1);
		adocao1.setPet(pet1);
		adocaoRepository.save(adocao1);

		var adocao2 = new Adocao();
		BigDecimal valor2 = new BigDecimal(32);
		adocao2.setEmail("email@example.com");
		adocao2.setValor(valor2);
		adocao2.setPet(pet2);
		adocaoRepository.save(adocao2);

		var adocao3 = new Adocao();
		BigDecimal valor3 = new BigDecimal(78);
		adocao3.setEmail("email@example.com");
		adocao3.setValor(valor3);
		adocao3.setPet(pet2);
		adocaoRepository.save(adocao3);

		var adocao4 = new Adocao();
		BigDecimal valor4 = new BigDecimal(100);
		adocao4.setEmail("email@example.com");
		adocao4.setValor(valor4);
		adocao4.setPet(pet1);
		adocaoRepository.save(adocao4);
	}

}
