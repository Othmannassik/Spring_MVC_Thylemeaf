package ma.emsi.spring_mvc_thylemeaf.repositories;

import ma.emsi.spring_mvc_thylemeaf.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
