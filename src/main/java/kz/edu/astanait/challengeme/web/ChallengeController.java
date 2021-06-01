package kz.edu.astanait.challengeme.web;

import kz.edu.astanait.challengeme.entity.Challenge;
import kz.edu.astanait.challengeme.entity.Participant;
import kz.edu.astanait.challengeme.entity.User;
import kz.edu.astanait.challengeme.repository.ParticipantRepository;
import kz.edu.astanait.challengeme.repository.UserRepository;
import kz.edu.astanait.challengeme.service.ChallengeService;
import kz.edu.astanait.challengeme.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

@Controller
public class ChallengeController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ParticipantRepository participantRepository;
    private ChallengeService challengeService;
    private ParticipantService participantService;

    @Autowired
    public ChallengeController(ChallengeService challengeService, ParticipantService participantService) {
        this.challengeService = challengeService;
        this.participantService = participantService;
    }

    //private User user;
    //private Challenge challenge;

    @GetMapping("/challenge")
    public String viewChallengePage(Model model){
        User user= getCurrentUser();
        model.addAttribute("user",user);
        model.addAttribute("listChallenges", challengeService.findAll());
        model.addAttribute("enrolled", participantRepository.findAll());
        return "challenge";
    }

    @GetMapping("/showNewChallengeForm")
    public String showNewChallengeForm(Model model){
        Challenge challenge = new Challenge();
        model.addAttribute("challenge", challenge);
        return "challenge_registration";
    }


    @RequestMapping("/saveChallenge")
    public String saveChallenge(@ModelAttribute("challenge") Challenge challenge){
        //challenge.setUserByAdminId(user);
        User user = getCurrentUser();
        challenge.setUserByAdminId(user);
        challengeService.save(challenge);
        return "redirect:/challenge";
    }

    @GetMapping("/challengeUpdate/{id}")
    public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {


        Challenge challenge = challengeService.getChallengeById(id);
        model.addAttribute("challenge", challenge);
        return "update_challenge";
    }

    @GetMapping("/deleteChallenge/{id}")
    public String deleteChallenge(@PathVariable (value = "id") long id) {

        // call delete employee method
        this.challengeService.deleteChallengeById(id);
        return "redirect:/challenge";
    }

   /* @RequestMapping("/enroll")
    public String enrollChallenge(@PathVariable( value = "id")long id){

        //challenge.setUserByAdminId(user);
        User user = getCurrentUser();
        Challenge challenge= challengeService.getChallengeById(id);
        Participant participant=new Participant();
        participant.setChallengeByChallengeId(challenge);
        participant.setUserByUserId(user);
        participantService.save(participant);
        return "redirect:/challenge";
    }*/

   /* @PostMapping("enroll")
    public RedirectView edit(HttpServletRequest request) {
        long id=Long.parseLong(request.getParameter("id"));
        Challenge challenge = challengeService.getChallengeById(id);
        User user = getCurrentUser();
        Participant participant=new Participant();
        participant.setChallengeByChallengeId(challenge);
        participant.setUserByUserId(user);
        participant.setUserXp((long) 0);
        participantRepository.save(participant);
        System.out.println("Test: "+ id);
        return new RedirectView("/challenge");
    }*/

    @GetMapping("/enroll/{id}")
    public String enrollChallenge(@PathVariable (value = "id") long id) {
        Challenge challenge = challengeService.getChallengeById(id);
        User user = getCurrentUser();
        Participant participant=new Participant();
        participant.setChallengeByChallengeId(challenge);
        participant.setUserByUserId(user);
        participant.setUserXp((long) 0);
        participantRepository.save(participant);
        return "redirect:/challenge";
    }
    @GetMapping("/cancel/{id}")
    public String cancelChallenge(@PathVariable (value = "id") long id) {
        Challenge challenge = challengeService.getChallengeById(id);
        User user = getCurrentUser();
        Participant participant=participantService.getParticipantByChallengeByChallengeIdAndAndUserByUserId(challenge, user);
        participantRepository.delete(participant);
        return "redirect:/challenge";
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        return userRepository.findByEmail(userEmail);
    }
}
