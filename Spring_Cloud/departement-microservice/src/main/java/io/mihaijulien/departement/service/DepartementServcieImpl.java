package io.mihaijulien.departement.service;

import io.mihaijulien.departement.dto.DepartementDto;
import io.mihaijulien.departement.entities.Departement;
import io.mihaijulien.departement.repos.DepartementRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartementServcieImpl implements DepartementService{

    private final DepartementRepository departementRepository;

    public DepartementServcieImpl(DepartementRepository departementRepository) {
        this.departementRepository = departementRepository;
    }

    @Override
    public DepartementDto getDepartementByCode(String code) {
        Departement dep = departementRepository.findByDepCode(code);

        DepartementDto departementDto = new DepartementDto(
                dep.getId(),
                dep.getDepNom(),
                dep.getDepCode()
        );

        return departementDto;
    }
}
