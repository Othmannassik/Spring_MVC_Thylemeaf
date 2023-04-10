package ma.emsi.spring_mvc_thylemeaf;

import ma.emsi.spring_mvc_thylemeaf.entities.Patient;
import ma.emsi.spring_mvc_thylemeaf.repositories.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class SpringMvcThylemeafApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringMvcThylemeafApplication.class, args);
    }

    @Bean
    CommandLineRunner start(PatientRepository patientRepository){
        return args -> {
            patientRepository.save(new Patient(null, "othman", new Date(), false, 783));
            patientRepository.save(new Patient(null, "othman2", new Date(), true, 387));
        };
    }
}
