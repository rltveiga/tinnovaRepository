package com.tinnova.tinnovaproject.repository;

import com.tinnova.tinnovaproject.model.domain.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

    @NonNull
    Optional<Veiculo> findById(@NonNull Long id);
}
