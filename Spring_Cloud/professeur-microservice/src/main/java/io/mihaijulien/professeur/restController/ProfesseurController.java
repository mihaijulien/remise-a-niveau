package io.mihaijulien.professeur.restController;

import io.mihaijulien.professeur.dto.APIResponseDto;
import io.mihaijulien.professeur.dto.ProfesseurDto;
import io.mihaijulien.professeur.service.ProfesseurService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/professeurs")
@AllArgsConstructor
public class ProfesseurController {
    private ProfesseurService professeurService;
    @GetMapping("{id}")
    public ResponseEntity<APIResponseDto> getDepByCode(@PathVariable("id")
                                                       Long id)
    {
        return new ResponseEntity<APIResponseDto>(
                professeurService.getProfesseurById(id),
                HttpStatus.OK);
    }
}