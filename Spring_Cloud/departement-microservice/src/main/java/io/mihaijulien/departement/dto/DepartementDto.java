package io.mihaijulien.departement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartementDto {
    private Long id;
    private String depNom;
    private String depCode;
}
