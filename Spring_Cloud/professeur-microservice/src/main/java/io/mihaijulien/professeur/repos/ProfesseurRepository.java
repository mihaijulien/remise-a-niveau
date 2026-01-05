package io.mihaijulien.professeur.repos;

import io.mihaijulien.professeur.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
}
