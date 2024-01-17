package org.example.Controller;

import org.example.Repo.ReservationRepository;
import org.example.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DataController {

    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping("/add-data")
    public String showAddDataForm(Model model) {
        model.addAttribute("data", new Reservation());
        return "add-data-form";  // Utwórz plik HTML w src/main/resources/templates o nazwie 'add-data-form.html'
    }

    @PostMapping("/add-data")
    public String addData(@ModelAttribute Reservation newData) {
        try {
            reservationRepository.save(newData);
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/error";
        }
        return "redirect:/success";  // Utwórz stronę success.html
    }
}
