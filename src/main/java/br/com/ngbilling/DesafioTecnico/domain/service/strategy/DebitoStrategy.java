package br.com.ngbilling.DesafioTecnico.domain.service.strategy;

import br.com.ngbilling.DesafioTecnico.domain.service.TransacaoStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class DebitoStrategy implements TransacaoStrategy {
    private static final BigDecimal TAXA_DEBITO = new BigDecimal("0.03");

    @Override
    public BigDecimal calcularValorFinal(BigDecimal valorOriginal) {
        BigDecimal taxa = valorOriginal.multiply(TAXA_DEBITO);
        return valorOriginal.add(taxa);
    }
}