package io.mihaijulien.departement.service;

import io.mihaijulien.departement.dto.DepartementDto;

public interface DepartementService {
    DepartementDto getDepartementByCode(String code);
}
