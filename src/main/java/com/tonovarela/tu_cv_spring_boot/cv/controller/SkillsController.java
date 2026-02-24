package com.tonovarela.tu_cv_spring_boot.cv.controller;

import com.tonovarela.tu_cv_spring_boot.cv.model.Skill;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "skills")
public class SkillsController {
    private final List<Skill> skills = new ArrayList<>();

    @ModelAttribute(name = "skills2")
    public List<Skill> getSkills() {
        return skills;
    }


    @GetMapping
    public  String showSkills(@RequestParam(defaultValue = "",required = false)  String filter, Model model) {
        List<Skill> filteredSkills = skills.stream()
                .filter(skill -> skill.getName().contains((filter.toLowerCase())))
                .toList();
        model.addAttribute("skills", filteredSkills);
        model.addAttribute("filter", filter);
        return "skills";
    }
    @GetMapping("/")
    public String showSkills() {

        return "skills";
    }

    @GetMapping("/new")
    public String showForm(Model model) {
        model.addAttribute("skill", new Skill());
        return "add-skills";
    }

     @GetMapping("id/{index}")
    public String showSkillDetail(@PathVariable  int index,Model model){
    if (index>0 && index<=skills.size()){
        model.addAttribute("skill", skills.get(index-1));
        return "skill-detail";
    }
    return "redirect:/skills";
    }

//    @GetMapping("name/{name}")
//    public String filterByName(@PathVariable  String name, RedirectAttributes redirectAttributes){
//        List<Skill> filteredSkills = skills.stream()
//                .filter(skill -> skill.getName().equalsIgnoreCase(name))
//                .toList();
//        if (filteredSkills.isEmpty()){
//            redirectAttributes.addFlashAttribute("filteredMessage", "No skills found with name: " + name);
//            return "redirect:/skills?filter=" +  name ;
//        }
//        redirectAttributes.addFlashAttribute("skills", filteredSkills);
//        redirectAttributes.addFlashAttribute("filteredMessage", "Skills filtered by name: " + name);
//        return "redirect:/skills?filter=" +  name ;
//    }

    @GetMapping("name/{name}")
    public String filterByName(@PathVariable  String name, RedirectAttributes redirectAttributes){
        boolean hasResults = skills.stream()
                .anyMatch(skill -> skill.getName().equalsIgnoreCase(name));
        if (!hasResults) {
            redirectAttributes.addFlashAttribute("filteredMessage", "No skills found with name: " + name);
        }else {
            redirectAttributes.addFlashAttribute("filteredMessage", "Skills filtered by name: " + name);
        }
            return "redirect:/skills?filter=" + name;

    }

    @GetMapping("search/{name}/{level}")
    public String showFilteredSkill(@PathVariable String name,@PathVariable String level,Model model){
       if(name!=null && level!=null){
           List<Skill> filteredSkills = skills.stream()
                   .filter(skill -> skill.getName().equalsIgnoreCase(name) && skill.getLevel().equalsIgnoreCase(level))
                   .toList();
           model.addAttribute("skills", filteredSkills);
           model.addAttribute("filteredMessage", "Skills filtered by name: " + name + " and level: " + level);
           return "skills";
       }
        return "redirect:/skills";
    }






    @PostMapping("/add")
    public String showForm(Skill skill, Model model) {
        skills.add(skill);
        model.addAttribute("skills", skills);

        return "redirect:/skills";
    }


}

