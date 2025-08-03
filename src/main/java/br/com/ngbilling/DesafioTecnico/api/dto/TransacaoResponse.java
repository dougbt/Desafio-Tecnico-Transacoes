package br.com.ngbilling.DesafioTecnico.api.dto;

import java.math.BigDecimal;

public record TransacaoResponse(Integer numeroConta, BigDecimal saldo) {

}
