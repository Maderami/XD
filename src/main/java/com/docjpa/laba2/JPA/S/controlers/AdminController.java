package com.docjpa.laba2.JPA.S.controlers;

import com.docjpa.laba2.JPA.S.models.ListDocs;
import com.docjpa.laba2.JPA.S.models.Users;
import com.docjpa.laba2.JPA.S.repo.ListDocRepository;
import com.docjpa.laba2.JPA.S.repo.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    private UsersRepository usersRepository;
    @GetMapping("/console")
    public String documentConsole(Model model){
        model.addAttribute("title", "Main console and control pages");
        return "/console/index3";
    }
    @GetMapping("/index2")
    public String documentConsoleDash1(Model model){
        model.addAttribute("title", "Main console and control pages");
        return "/console/index2";
    }
    @GetMapping("/index3")
    public String documentConsoleDash2(Model model){
        model.addAttribute("title", "Main console and control pages");
        return "/console/index";
    }
    @GetMapping("/syssett")
    public String documentConsoleSysst(Model model){
        model.addAttribute("title", "Main console and control pages");
        return "syssett";
    }
    @GetMapping("/webset")
    public String documentConsoleWebst(Model model){
        model.addAttribute("title", "Main console and control pages");
        return "webset";
    }
    @GetMapping("/controldata")
    public String documentConsoleCondt(Model model){
        model.addAttribute("title", "Main console and control pages");
        return "controldata";
    }
    @GetMapping("/console/card-doc-control")
    public String documentConsoleAction(Model model){
        model.addAttribute("title", "Main console and control pages");
        return "/console/card-doc-control";
    }

    @GetMapping("/usersadd")
    public String usersConsoleControlAdd(Model model){
        model.addAttribute("title", "Main console and control pages");
        return "/console/users-add";
    }

    @GetMapping("/usersview")
    public String usersConsoleControlView(Model model){
        model.addAttribute("title", "Main console and control pages");
        return "/console/users-view";
    }

    @PostMapping("/usersadd")
    public String docAddPost(@RequestParam String fsm_sub, @RequestParam String position, @RequestParam String place_job, @RequestParam String subdivision
            , @RequestParam String phone_sub, @RequestParam String role_sub, @RequestParam String post_address, @RequestParam String active_acc,Model model){

        Users users = new Users(fsm_sub, position, place_job,subdivision,phone_sub,post_address,role_sub,active_acc);
        usersRepository.save(users);
        return "redirect:/console";
    }

//    @GetMapping("/doclist/{id_doc}")
//    public String DocumentDetails(@PathVariable(value="id_doc") long id_doc, Model model) {
//        if(!listdocrepository.existsById(id_doc)) {
//            return "redirect:/";
//        }
//        Optional<ListDocs> listD = listdocrepository.findById(id_doc);
//        ArrayList<ListDocs> res = new ArrayList<>();
//        listD.ifPresent(res::add);
//        model.addAttribute("listD", res);
//        return "doclistdetails";
//    }
//    @GetMapping("/doclist/{id_doc}/edit")
//    public String DocumentEdit(@PathVariable(value="id_doc") long id_doc,Model model) {
//        if(!listdocrepository.existsById(id_doc)) {
//            return "redirect:/";
//        }
//        Optional<ListDocs> listD = listdocrepository.findById(id_doc);
//        ArrayList<ListDocs> res = new ArrayList<>();
//        listD.ifPresent(res::add);
//        model.addAttribute("listD", res);
//        return "doclistedit";
//    }
//
//    @PostMapping("/doclist/{id_doc}/edit")
//    public String docUpdatePost(@PathVariable(value="id_doc") long id_doc,@RequestParam String title_doc, @RequestParam String author,@RequestParam String creation_doc,@RequestParam String registration_doc
//            ,@RequestParam String status,@RequestParam String description_doc, Model model){
//        ListDocs listds = listdocrepository.findById(id_doc).orElseThrow();
//        listds.setTitle_doc(title_doc);
//        listds.setAuthor(author);
//        listds.setCreation_doc(LocalDate.parse(creation_doc));
//        listds.setRegistration_doc(LocalDate.parse(registration_doc));
//        listds.setStatus(status);
//        listds.setDescription_doc(description_doc);
//        listdocrepository.save(listds);
//        return "redirect:/doclist";
//    }
//    @PostMapping("/doclist/{id_doc}/delete")
//    public String docDeletePost(@PathVariable(value="id_doc") long id_doc, Model model){
//        ListDocs listds = listdocrepository.findById(id_doc).orElseThrow();
//        listdocrepository.delete(listds);
//        return "redirect:/doclist";
//    }

}
