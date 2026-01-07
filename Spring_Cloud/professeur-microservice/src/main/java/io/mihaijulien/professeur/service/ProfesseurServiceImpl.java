package io.mihaijulien.professeur.service;

import io.mihaijulien.professeur.dto.APIResponseDto;
import io.mihaijulien.professeur.dto.DepartementDto;
import io.mihaijulien.professeur.dto.ProfesseurDto;
import io.mihaijulien.professeur.entities.Professeur;
import io.mihaijulien.professeur.repos.ProfesseurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProfesseurServiceImpl implements ProfesseurService{

    private ProfesseurRepository professeurRepository;
    private APIClient apiClient;

    @Override
    public APIResponseDto getProfesseurById(Long id) {
        Professeur professeur = professeurRepository.findById(id).get();
        DepartementDto departementDto = apiClient.getDepartementByCode(professeur.getDepCode()); // récupérer le DépartementDto
        // avec en utilisant APIClient, il va lui transmettre le code du département de mon professeur

        ProfesseurDto professeurDto = new ProfesseurDto(professeur.getId(),
                professeur.getPrenom(),
                professeur.getSurnom(),
                departementDto.getDepNom(), // ici
                professeur.getDepCode());

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setProfesseurDto(professeurDto);
        apiResponseDto.setDepartementDto(departementDto);

        return apiResponseDto;
    }
}
