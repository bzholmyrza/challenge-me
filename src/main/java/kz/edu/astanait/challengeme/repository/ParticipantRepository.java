package kz.edu.astanait.challengeme.repository;

import kz.edu.astanait.challengeme.entity.Challenge;
import kz.edu.astanait.challengeme.entity.Participant;
import kz.edu.astanait.challengeme.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    /*Participant getParticipantById(long id);*/
    /*void deleteChallengeById(long id);*/
   /* void deleteParticipantByChallengeByChallengeIdAndUserByUserId(Challenge challenge, User user);*/
    void deleteParticipantsByChallengeByChallengeIdAndAndUserByUserId(Challenge challenge, User user);
    Participant getParticipantByChallengeByChallengeIdAndAndUserByUserId(Challenge challenge, User user);
    List<Participant> getParticipantsByChallengeByChallengeIdOrderByUserXpDesc(Challenge challenge);
    Participant getParticipantByChallengeByChallengeIdAndUserByUserId(Challenge challenge, User user);
}
