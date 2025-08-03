package br.com.ngbilling.DesafioTecnico.application.service;

import br.com.ngbilling.DesafioTecnico.api.dto.ContaRequest;
import br.com.ngbilling.DesafioTecnico.api.dto.ContaResponse;
import br.com.ngbilling.DesafioTecnico.domain.model.Conta;
import br.com.ngbilling.DesafioTecnico.domain.service.ContaService;
import br.com.ngbilling.DesafioTecnico.infrastructure.repository.ContaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

@Service
public class ContaServiceImpl implements ContaService {

    private final ContaRepository contaRepository;

    public ContaServiceImpl(ContaRepository contaRepository) {
        this.contaRepository = contaRepository;
    }

    @Override
    public ContaResponse criarConta(ContaRequest request) {
        if (request.saldo().compareTo(BigDecimal.ZERO) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Saldo não pode ser negativo");
        }

        if (contaRepository.existsByNumeroConta(request.numeroConta())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta já existente");
        }

        Conta novaConta = new Conta(request.numeroConta(), request.saldo());
        Conta contaSalva = contaRepository.save(novaConta);

        return new ContaResponse(contaSalva.getNumeroConta(), contaSalva.getSaldo());
    }

    @Override
    public ContaResponse buscarConta(Integer numeroConta) {
        return contaRepository.findByNumeroConta(numeroConta)
                .map(conta -> new ContaResponse(conta.getNumeroConta(), conta.getSaldo()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não encontrada"));
    }

    @Override
    public boolean contaExiste(Integer numeroConta) {
        return contaRepository.existsByNumeroConta(numeroConta);
    }
}