package kz.edu.astanait.challengeme.service;

import kz.edu.astanait.challengeme.entity.Participant;

import kz.edu.astanait.challengeme.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ParticipantServiceImpl implements ParticipantService{
    @Autowired
    private ParticipantRepository participantRepository;
    @Override
    public void save(Participant participant) {
        this.participantRepository.save(participant);
    }
}
