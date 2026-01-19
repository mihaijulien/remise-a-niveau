package io.mihaijulien.departement.restControllers;

import io.mihaijulien.departement.dto.DepartementDto;
import io.mihaijulien.departement.service.DepartementService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/departements")
public class DepartementController {
    private DepartementService departmentService;
    @Value("${build.version")
    private String buildVersion;

    public DepartementController(DepartementService departmentService){
        this.departmentService = departmentService;
    }

    @GetMapping("{code}")
    public ResponseEntity<DepartementDto> getDepByCode(@PathVariable("code")
                                                      String code )
    {
        return new ResponseEntity<DepartementDto>(
                departmentService.getDepartementByCode(code),
                HttpStatus.OK);
    }

    @GetMapping("/version")
    public ResponseEntity<String> version(){
        return ResponseEntity.status(HttpStatus.OK).body(buildVersion);
    }
}