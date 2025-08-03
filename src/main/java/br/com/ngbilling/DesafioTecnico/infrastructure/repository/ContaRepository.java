package br.com.ngbilling.DesafioTecnico.infrastructure.repository;

import br.com.ngbilling.DesafioTecnico.domain.model.Conta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContaRepository extends JpaRepository<Conta, Integer> {

    Optional<Conta> findByNumeroConta(Integer numeroConta);

    boolean existsByNumeroConta(Integer numeroConta);

}
