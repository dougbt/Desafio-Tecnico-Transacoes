package br.com.ngbilling.DesafioTecnico.domain.service.strategy;

import br.com.ngbilling.DesafioTecnico.domain.service.TransacaoStrategy;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class PixStrategy implements TransacaoStrategy {
    @Override
    public BigDecimal calcularValorFinal(BigDecimal valorOriginal) {
        return valorOriginal;
    }
}