package io.mihaijulien.professeur.service;

import io.mihaijulien.professeur.dto.DepartementDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8080", value = "DEPARTEMENT")
public interface APIClient {

    @GetMapping("/api/departements/{departement-code}")
    DepartementDto getDepartementByCode(@PathVariable("departement-code") String departementCode);
}
