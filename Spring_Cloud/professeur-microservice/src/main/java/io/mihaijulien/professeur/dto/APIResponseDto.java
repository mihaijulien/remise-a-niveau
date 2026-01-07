package io.mihaijulien.professeur.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private ProfesseurDto professeurDto;
    private DepartementDto departementDto;
}
