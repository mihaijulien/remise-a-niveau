package io.mihaijulien.professeur.service;

import io.mihaijulien.professeur.dto.ProfesseurDto;

public interface ProfesseurService {
    ProfesseurDto getProfesseurById(Long id);
}
