package com.tonovarela.tu_cv_spring_boot.cv.controller;
import com.tonovarela.tu_cv_spring_boot.cv.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping(value = "cv")


public class CvController {

    private final Person person2;

    public CvController(Person person2) {
        this.person2 = person2;
    }
  @GetMapping("/")
  public String index(Model model) {
      Person person = new Person("Tono", "Varela", "Software Engineer");
      model.addAttribute("nombre", "To");
      model.addAttribute("person", person);
      model.addAttribute("property", person2.getName());
    return "index";
  }



}

