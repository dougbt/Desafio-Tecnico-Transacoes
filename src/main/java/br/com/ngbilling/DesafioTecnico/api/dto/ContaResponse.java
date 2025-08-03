package br.com.ngbilling.DesafioTecnico.api.dto;

import java.math.BigDecimal;

public record ContaResponse(Integer numeroConta, BigDecimal saldo) {
}
