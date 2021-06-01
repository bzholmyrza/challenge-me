package kz.edu.astanait.challengeme.web;

import kz.edu.astanait.challengeme.entity.Challenge;
import kz.edu.astanait.challengeme.entity.Material;
import kz.edu.astanait.challengeme.entity.User;
import kz.edu.astanait.challengeme.repository.UserRepository;
import kz.edu.astanait.challengeme.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
public class ParticipantController {
    @Autowired
    UserRepository userRepository;

    private ChallengeService challengeService;
    private ParticipantService participantService;
    private MaterialService materialService;
    private DayService dayService;
    private ActivityService activityService;

    public ParticipantController(ChallengeService challengeService, ParticipantService participantService,
                                 MaterialService materialService, DayService dayService, ActivityService activityService) {
        this.challengeService = challengeService;
        this.participantService = participantService;
        this.materialService = materialService;
        this.dayService = dayService;
        this.activityService = activityService;
    }

    @GetMapping("/enrolled/{id}")
    public String viewParticipantPage(Model model, @PathVariable(value = "id") long id){
        User user= getCurrentUser();
        Challenge challenge=challengeService.getChallengeById(id);
        model.addAttribute("user",user);
        model.addAttribute("days", dayService.getDays());
        model.addAttribute("challenge", challenge);
        model.addAttribute("activities", activityService.getChallengeActivities(challenge, user));
        model.addAttribute("participant", participantService.getParticipant(challenge, user));
        model.addAttribute("materials",materialService.getAllMaterials(challenge));
        return "participantpage";
    }

    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        return userRepository.findByEmail(userEmail);
    }
}
