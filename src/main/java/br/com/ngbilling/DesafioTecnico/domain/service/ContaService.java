package br.com.ngbilling.DesafioTecnico.domain.service;

import br.com.ngbilling.DesafioTecnico.api.dto.ContaRequest;
import br.com.ngbilling.DesafioTecnico.api.dto.ContaResponse;

public interface ContaService {
    ContaResponse criarConta(ContaRequest request);
    ContaResponse buscarConta(Integer numeroConta);
    boolean contaExiste(Integer numeroConta);
}