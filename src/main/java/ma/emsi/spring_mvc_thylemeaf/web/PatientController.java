package ma.emsi.spring_mvc_thylemeaf.web;

import lombok.AllArgsConstructor;
import ma.emsi.spring_mvc_thylemeaf.entities.Patient;
import ma.emsi.spring_mvc_thylemeaf.repositories.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping("/")
    public String Home(){
        return "redirect:/patients";
    }

    @GetMapping(path = "patients")
    public String AfficherPatients(Model model,
                                @RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "6") int size,
                                @RequestParam(name = "keyword", defaultValue = "") String keyword){
        Page<Patient> pagePatients = patientRepository.findByNomContains(keyword,PageRequest.of(page,size));
        model.addAttribute("listePatients", pagePatients.getContent());
        model.addAttribute("pages", new int[pagePatients.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        return "patients";
    }

    @GetMapping("/delete")
    public String Delete(Long id, int page, String keyword){
        patientRepository.deleteById(id);
        return "redirect:/patients?page="+page+"&keyword="+keyword;
    }

}
