package io.mihaijulien.professeur;

import io.mihaijulien.professeur.entities.Professeur;
import io.mihaijulien.professeur.repos.ProfesseurRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProfesseurMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProfesseurMicroserviceApplication.class, args);
	}

    @Bean
    CommandLineRunner commandLineRunner(ProfesseurRepository professeurRepository) {
        return args -> {
            professeurRepository.save(Professeur.builder()
                    .prenom("Julien")
                    .surnom("Mihai")
                    .build());
        };
    }

}
