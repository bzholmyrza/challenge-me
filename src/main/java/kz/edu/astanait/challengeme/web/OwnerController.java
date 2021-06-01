package kz.edu.astanait.challengeme.web;

import kz.edu.astanait.challengeme.entity.Challenge;
import kz.edu.astanait.challengeme.entity.Day;
import kz.edu.astanait.challengeme.entity.Material;
import kz.edu.astanait.challengeme.entity.User;
import kz.edu.astanait.challengeme.repository.ParticipantRepository;
import kz.edu.astanait.challengeme.repository.UserRepository;
import kz.edu.astanait.challengeme.service.ChallengeService;
import kz.edu.astanait.challengeme.service.DayService;
import kz.edu.astanait.challengeme.service.MaterialService;
import kz.edu.astanait.challengeme.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerController {
    @Autowired
    UserRepository userRepository;


    private ChallengeService challengeService;
    private ParticipantService participantService;
    private MaterialService materialService;
    private DayService dayService;

    @Autowired
    public OwnerController(ChallengeService challengeService, ParticipantService participantService,
                           MaterialService materialService,DayService dayService ) {
        this.challengeService = challengeService;
        this.participantService = participantService;
        this.materialService=materialService;
        this.dayService=dayService;

    }

    @GetMapping("/mychallenge/{id}")
    public String viewOwnerPage(Model model, @PathVariable(value = "id") long id){
        User user= getCurrentUser();
        Material material=new Material();
        Challenge challenge=challengeService.getChallengeById(id);
        model.addAttribute("user",user);
        model.addAttribute("days", dayService.getDays());
        model.addAttribute("challenge", challenge);
        model.addAttribute("participants", participantService.findAll());
        model.addAttribute("materials",materialService.getAllMaterials(challenge));
        model.addAttribute("material", material);
        return "ownerpage";
    }

    @RequestMapping("/addChallengeTask/{id}/{did}")
    public String saveMaterial(@ModelAttribute("material") Material material, @PathVariable(value = "id") long id, @PathVariable(value = "did")long did){
        Challenge challenge=challengeService.getChallengeById(id);
        Day day =dayService.getDay(did);
        material.setDayByDayId(day);
        material.setChallengeByChallengeId(challenge);
        materialService.save(material);
        return "redirect:/mychallenge/"+id;
    }

    @GetMapping("/leaderboard/{id}")
    public String viewLeaderboard(Model model, @PathVariable(value = "id") long id){
        User user= getCurrentUser();
        Challenge challenge=challengeService.getChallengeById(id);
        model.addAttribute("user",user);
        model.addAttribute("challenge", challenge);
        model.addAttribute("participants", participantService.getPartcipantsForLeaderboard(challenge));
        return "leaderboard";
    }

    @GetMapping("/deleteTask/{id}/{pid}")
    public String deleteTask(@PathVariable (value = "id") long id, @PathVariable(value = "pid")long pid) {

        // call delete employee method
        this.materialService.deleteMaterial(id);
        return "redirect:/mychallenge/"+pid;
    }


    public User getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userEmail = authentication.getName();
        return userRepository.findByEmail(userEmail);
    }


}
