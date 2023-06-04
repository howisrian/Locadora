package br.com.locadora.locadora.controller.veiculo;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    
    Optional<Veiculo> findByMarca(String marca);
    Optional<Veiculo> findByModelo(String modelo);
    Optional<Veiculo> findByDisponivel(Boolean disponivel);
}
