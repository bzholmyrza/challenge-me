package kz.edu.astanait.challengeme.service;

import kz.edu.astanait.challengeme.entity.Challenge;
import kz.edu.astanait.challengeme.repository.ChallengeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChallengeServiceImpl implements ChallengeService {

    @Autowired
    private ChallengeRepository challengeRepository;

    @Override
    public List<Challenge> findAll() {
        return challengeRepository.findAll();
    }

    @Override
    public void save(Challenge challenge) {
        this.challengeRepository.save(challenge);
    }

    @Override
    public Challenge getChallengeById(long id) {
        Optional<Challenge> optional = challengeRepository.findById(id);
        Challenge challenge = null;
        if (optional.isPresent()) {
            challenge = optional.get();
        } else {
            throw new RuntimeException("Challenge not found for id :: " + id);
        }
        return challenge;
    }

    @Override
    public void deleteChallengeById(long id) {
        this.challengeRepository.deleteById(id);
    }


}
