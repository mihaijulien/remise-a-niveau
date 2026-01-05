package io.mihaijulien.professeur.service;

import io.mihaijulien.professeur.dto.ProfesseurDto;
import io.mihaijulien.professeur.entities.Professeur;
import io.mihaijulien.professeur.repos.ProfesseurRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class ProfesseurServiceImpl implements ProfesseurService{

    private ProfesseurRepository professeurRepository;

    @Override
    public ProfesseurDto getProfesseurById(Long id) {
        Professeur professeur = professeurRepository.findById(id).get();

        return new ProfesseurDto(professeur.getId(),
                professeur.getPrenom(),
                professeur.getSurnom());
    }
}
