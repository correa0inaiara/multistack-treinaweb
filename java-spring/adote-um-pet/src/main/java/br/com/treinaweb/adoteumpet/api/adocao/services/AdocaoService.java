package br.com.treinaweb.adoteumpet.api.adocao.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoRequest;
import br.com.treinaweb.adoteumpet.api.adocao.dtos.AdocaoResponse;
import br.com.treinaweb.adoteumpet.api.adocao.mappers.AdocaoMapper;
import br.com.treinaweb.adoteumpet.core.repositories.AdocaoRepository;

@Service
public class AdocaoService {
	
	@Autowired
	private AdocaoRepository adocaoRepository;

	@Autowired
	private AdocaoMapper AdocaoMapper;

	public AdocaoResponse create(AdocaoRequest adocaoRequest) {
		var adocaoToCreate = AdocaoMapper.toModel((adocaoRequest));
		var createdAdocao = adocaoRepository.save(adocaoToCreate);
		return AdocaoMapper.toResponse(createdAdocao);
	}

	public List<AdocaoResponse> findAll() {
		return adocaoRepository.findAll()
			.stream()
			.map(AdocaoMapper::toResponse)
			.toList();
	}

}
