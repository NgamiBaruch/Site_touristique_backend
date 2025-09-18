package com.example.tedon.repository;

import com.example.tedon.models.Hebergement;
import com.example.tedon.models.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HebergementRepository extends JpaRepository<Hebergement, Long> {
}
