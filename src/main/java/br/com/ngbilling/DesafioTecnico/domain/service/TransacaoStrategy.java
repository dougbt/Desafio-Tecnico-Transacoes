package br.com.ngbilling.DesafioTecnico.domain.service;

import java.math.BigDecimal;

public interface TransacaoStrategy {
    BigDecimal calcularValorFinal(BigDecimal valorOriginal);
}