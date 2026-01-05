package io.mihaijulien.professeur.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfesseurDto {
    private Long id;
    private String prenom;
    private String surnom;
}
