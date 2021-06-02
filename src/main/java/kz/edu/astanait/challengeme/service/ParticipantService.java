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

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
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

}
