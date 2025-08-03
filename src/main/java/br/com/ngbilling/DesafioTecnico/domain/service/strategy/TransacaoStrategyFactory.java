package br.com.ngbilling.DesafioTecnico.domain.service.strategy;

import br.com.ngbilling.DesafioTecnico.domain.model.FormaDePagamento;
import br.com.ngbilling.DesafioTecnico.domain.service.TransacaoStrategy;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class TransacaoStrategyFactory {
    private final Map<FormaDePagamento, TransacaoStrategy> strategies;

    public TransacaoStrategyFactory(
            CreditoStrategy creditoStrategy,
            DebitoStrategy debitoStrategy,
            PixStrategy pixStrategy) {

        this.strategies = new EnumMap<>(FormaDePagamento.class);
        this.strategies.put(FormaDePagamento.CREDITO, creditoStrategy);
        this.strategies.put(FormaDePagamento.DEBITO, debitoStrategy);
        this.strategies.put(FormaDePagamento.PIX, pixStrategy);
    }

    public TransacaoStrategy getStrategy(FormaDePagamento formaPagamento) {
        return strategies.get(formaPagamento);
    }
}