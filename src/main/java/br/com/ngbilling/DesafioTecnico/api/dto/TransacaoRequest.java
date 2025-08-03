package br.com.ngbilling.DesafioTecnico.api.dto;

import br.com.ngbilling.DesafioTecnico.domain.model.FormaDePagamento;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransacaoRequest(
        @NotNull FormaDePagamento formaPagamento,
        @NotNull Integer numeroConta,
        @NotNull @Positive BigDecimal valor
) {}
