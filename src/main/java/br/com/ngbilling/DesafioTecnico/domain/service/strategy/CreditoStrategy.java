package br.com.ngbilling.DesafioTecnico.domain.service.strategy;

import br.com.ngbilling.DesafioTecnico.domain.service.TransacaoStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class CreditoStrategy implements TransacaoStrategy {
    private static final BigDecimal TAXA_CREDITO = new BigDecimal("0.05");

    @Override
    public BigDecimal calcularValorFinal(BigDecimal valorOriginal) {
        BigDecimal taxa = valorOriginal.multiply(TAXA_CREDITO);
        return valorOriginal.add(taxa);
    }
}