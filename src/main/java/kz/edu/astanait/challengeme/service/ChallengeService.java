package kz.edu.astanait.challengeme.service;

import kz.edu.astanait.challengeme.entity.Challenge;

import java.util.List;

public interface ChallengeService {
    List<Challenge> findAll();
    void save(Challenge challenge);
    Challenge getChallengeById(long id);
    void deleteChallengeById(long id);
}
