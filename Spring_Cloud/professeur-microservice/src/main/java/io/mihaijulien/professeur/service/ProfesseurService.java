package io.mihaijulien.professeur.service;

import io.mihaijulien.professeur.dto.APIResponseDto;

public interface ProfesseurService {
    APIResponseDto getProfesseurById(Long id);
}
