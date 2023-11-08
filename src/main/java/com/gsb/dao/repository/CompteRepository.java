package com.gsb.dao.repository;
import com.gsb.dao.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CompteRepository extends JpaRepository<Compte, String> {
    Compte findByCodeCompte(String codeCmpt);
}