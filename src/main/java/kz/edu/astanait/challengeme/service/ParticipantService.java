package kz.edu.astanait.challengeme.service;

import kz.edu.astanait.challengeme.entity.Challenge;
import kz.edu.astanait.challengeme.entity.Participant;
import kz.edu.astanait.challengeme.entity.User;
import kz.edu.astanait.challengeme.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService{
    private final ParticipantRepository participantRepository;
    private ChallengeService challengeService;
    @Autowired
    public ParticipantService(ParticipantRepository participantRepository, ChallengeService challengeService) {
        this.participantRepository = participantRepository;
        this.challengeService=challengeService;
    }

    public void save(Participant participant) {
        participantRepository.save(participant);
    }

    public void deleteParticipantsByChallengeByChallengeIdAndAndUserByUserId(Challenge challenge, User user){
        participantRepository.deleteParticipantsByChallengeByChallengeIdAndAndUserByUserId(challenge, user);
    }

    public Participant getParticipantByChallengeByChallengeIdAndAndUserByUserId(Challenge challenge, User user){
      return   participantRepository.getParticipantByChallengeByChallengeIdAndAndUserByUserId(challenge, user);

    }

    public List<Participant> findAll() {
        return participantRepository.findAll();
    }
    public List<Participant> getPartcipantsForLeaderboard(Challenge challenge){
        return participantRepository.getParticipantsByChallengeByChallengeIdOrderByUserXpDesc(challenge);
    }

    public  Participant getParticipant(Challenge challenge, User user){
        return participantRepository.getParticipantByChallengeByChallengeIdAndUserByUserId(challenge, user);
    }

    public String enroll(long id, User user){
        Challenge challenge = challengeService.getChallengeById(id);
        Participant participan=participantRepository.getParticipantByChallengeByChallengeIdAndAndUserByUserId(challenge, user);
        if(participan!=null){
        return "enrolled";
        }
        else {
            Participant participant = new Participant();
            participant.setChallengeByChallengeId(challenge);
            participant.setUserByUserId(user);
            participant.setUserXp((long) 0);
            participantRepository.save(participant);
            return "success";
        }
    }

}
