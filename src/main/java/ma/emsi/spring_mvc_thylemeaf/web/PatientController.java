package ma.emsi.spring_mvc_thylemeaf.web;

import lombok.AllArgsConstructor;
import ma.emsi.spring_mvc_thylemeaf.repositories.PatientRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping(path = "patients")
    public String AfficherPatients(Model model){
        model.addAttribute("listePatients", patientRepository.findAll());
        return "patients";
    }

}
