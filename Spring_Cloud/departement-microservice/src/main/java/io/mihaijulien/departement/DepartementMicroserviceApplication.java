package io.mihaijulien.departement;

import io.mihaijulien.departement.entities.Departement;
import io.mihaijulien.departement.repos.DepartementRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DepartementMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartementMicroserviceApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(DepartementRepository departmentRepository) {
        return args -> {
            departmentRepository.save(Departement.builder()
                    .depNom("Info Tech")
                    .depCode("IT")
                    .build());
            departmentRepository.save(Departement.builder()
                    .depNom("Marketing")
                    .depCode("MK")
                    .build());
        };
    }

}
