package br.com.ngbilling.DesafioTecnico.domain.service;

import br.com.ngbilling.DesafioTecnico.api.dto.TransacaoRequest;
import br.com.ngbilling.DesafioTecnico.api.dto.TransacaoResponse;

public interface TransacaoService {
    TransacaoResponse processarTransacao(TransacaoRequest request);
}