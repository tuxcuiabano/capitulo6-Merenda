package br.edu.ficdev;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MerendaRepository extends JpaRepository<Merenda, Long> {
    List<Merenda> findByNome(String nome);
}
