package io.mihaijulien.departement.repos;

import io.mihaijulien.departement.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartementRepository extends JpaRepository<Departement, Long> {

    Departement findByDepCode(String code);
}
