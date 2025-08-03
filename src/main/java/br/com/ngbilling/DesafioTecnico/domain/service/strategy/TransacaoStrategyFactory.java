package br.com.ngbilling.DesafioTecnico.domain.service.strategy;

import br.com.ngbilling.DesafioTecnico.domain.model.FormaDePagamento;
import br.com.ngbilling.DesafioTecnico.domain.service.TransacaoStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.EnumMap;
import java.util.Map;

@Configuration
public class TransacaoStrategyFactory {

    @Bean
    public Map<FormaDePagamento, TransacaoStrategy> transacaoStrategyMap(
            CreditoStrategy creditoStrategy,
            DebitoStrategy debitoStrategy,
            PixStrategy pixStrategy) {

        Map<FormaDePagamento, TransacaoStrategy> strategies = new EnumMap<>(FormaDePagamento.class);
        strategies.put(FormaDePagamento.CREDITO, creditoStrategy);
        strategies.put(FormaDePagamento.DEBITO, debitoStrategy);
        strategies.put(FormaDePagamento.PIX, pixStrategy);
        return strategies;
    }
}