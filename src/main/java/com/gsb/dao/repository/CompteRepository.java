package com.gsb.dao.repository;
import com.gsb.dao.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompteRepository extends JpaRepository<Compte, String> {
    Compte findByCodeCompte(String codeCmpt);

    List<Compte> findByCodeCli(Long codeCli);
}