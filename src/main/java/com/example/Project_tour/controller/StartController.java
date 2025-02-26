package com.example.Project_tour.controller;

import com.example.Project_tour.entity.Registration;
import com.example.Project_tour.entity.Reviews;
import com.example.Project_tour.repository.RegistrationRepo;
import com.example.Project_tour.repository.ReviewsRepository;
import com.example.Project_tour.service.RegistrationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StartController {

    @Autowired
    private RegistrationService registrationService;
    @Autowired
    RegistrationRepo rRepo;

    @GetMapping("/start")
    public ModelAndView loginForm() {
        ModelAndView modelAndView = new ModelAndView("Login");
        Registration registration = new Registration();
        modelAndView.addObject("LoginForm", registration);
        return modelAndView;
    }

    @GetMapping("/loginForm")
    public ModelAndView start() {
        ModelAndView modelAndView = new ModelAndView("Registration");
        Registration registration = new Registration();
        modelAndView.addObject("registrationForm", registration);
        return modelAndView;
    }

    @PostMapping("/registrationController")
    public String registration(@ModelAttribute Registration registration) {
        //System.out.println(registration.getUsername()+" "+registration.getEmail());
        registrationService.saveInfo(registration);
        return "redirect:/loginForm";
    }

   /* @GetMapping("/home")
    public String loginForm(ModelAndView m) {
        m.addObject("menu", "login");
        return "customerLogin.html";
    }*/

    @PostMapping("/home")
    public String getPassword(@ModelAttribute Registration registration, HttpSession session) {
        String email = registration.getEmail();
        String passwordFromHtml = registration.getPassword();

        Registration r = registrationService.login(email,passwordFromHtml);
        if(r==null)
            return "redirect:/loginForm";
        else if(r.getPassword().equals(passwordFromHtml)){
            session.setAttribute("user",r);
            return "redirect:/homeAfterLogin";
        }


        return "redirect:/loginForm";
    }

    @GetMapping("/homeAfterLogin")
    public ModelAndView homeAfterLogin(){
        ModelAndView modelAndView = new ModelAndView("home");
        return modelAndView;

    }
    @GetMapping("/aboutbangladesh")
    public  ModelAndView aboutbangladesh(){
        ModelAndView modelAndView = new ModelAndView("aboutbangladesh");
        return modelAndView;
    }



    @GetMapping("/")
    public String homepage(){
        return "home";
    }

    @GetMapping("/dhaka")
    public String dhaka(){
        return "dhaka";
    }

    @GetMapping("/chattogram")
    public String chittagong(){
        return "chattogram";
    }

    @GetMapping("/khulna")
    public String khulna(){
        return "khulna";
    }

    @GetMapping("/district_scrolldown_barishal")
    public String barishal(){
        return "district_scrolldown_barishal";
    }

    @GetMapping("/district_scroll_down_rajshahi")
    public String rajshahi(){
        return "district_scroll_down_rajshahi";
    }

    @GetMapping("/profile")
    public String profile(HttpSession session, Model m){
        Registration registration = (Registration) session.getAttribute("user");

        m.addAttribute("user",registration);
        return "userUpdate";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/start";
    }

    @PostMapping("/userupdate")
    public String userupdate(@ModelAttribute Registration registration,HttpSession session){
        Registration registration1 = (Registration) session.getAttribute("user");
        registration1.setUsername(registration.getUsername());
        registration1.setEmail(registration.getEmail());
        registration1.setPassword(registration.getPassword());
        registration1.setHobby(registration.getHobby());
        registration1.setInterest(registration.getInterest());
        session.removeAttribute("user");
        session.setAttribute("user",registration1);
        rRepo.save(registration1);
        return "home";
    }


    @GetMapping("/Coxs_Bazar_Sea_Beach")
    public String Coxs_Bazar_Sea_Beach(){ return "Coxs_Bazar_Sea_Beach";
    }

    @GetMapping("/potenga")
    public String potenga(){ return "potenga";
    }

    @GetMapping("/mountain")
    public String mountain(){
        return "mountain";
    }

    @GetMapping("/sajek")
    public String sajek(){
        return "sajek";
    }

    @GetMapping("/lalbagh")
    public String lalbagh(){
        return "lalbagh";
    }


    @GetMapping("/search")
    public String search(@RequestParam("searchContent") String searchContent, Model model) {
        return searchContent;
    }
    @Autowired
    private ReviewsRepository reviewsRepository;

    @PostMapping("/review")
    public String review(@RequestParam("reviewername") String name,
                         @RequestParam("reviewdate") String date,
                         @RequestParam("text") String text,
                         @RequestParam("rating") String rating
                         ) {
        Reviews reviews = new Reviews();
        reviews.setReviewername(name);
        reviews.setReviewdate(date);
        reviews.setText(text);
        reviews.setRating(rating);
        reviewsRepository.save(reviews);
        return "redirect:/fetchRecord";
    }
    @GetMapping("/fetchRecord")
    public String fetchRecord(Model model){
        System.out.println("hit");
        List<Reviews> reviews = reviewsRepository.findAll();
        model.addAttribute("reviews", reviews);
        return "Ratings";
    }
}

