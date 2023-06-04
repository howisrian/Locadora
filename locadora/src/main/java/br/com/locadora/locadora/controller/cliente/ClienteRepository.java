package br.com.locadora.locadora.controller.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Optional<Clientimport java.util.Optional;e> findByEmail(String email);
    
}