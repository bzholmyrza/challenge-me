package kz.edu.astanait.challengeme.service;

import kz.edu.astanait.challengeme.entity.Challenge;
import kz.edu.astanait.challengeme.entity.Participant;
import kz.edu.astanait.challengeme.repository.ParticipantRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ParticipantServiceTest {
    @Mock
    private ParticipantRepository participantRepository;
    private ChallengeService challengeService;
    private ParticipantService underTest;

    @BeforeEach
    void setUp(){
        underTest=new ParticipantService(participantRepository, challengeService);
    }

    @Test
    void canAddParticipant() {
    //given
        Participant participant= new Participant();
    //when
    underTest.save(participant);
    //then
        ArgumentCaptor<Participant> participantArgumentCaptor=ArgumentCaptor.forClass(Participant.class);
        verify(participantRepository).save(participantArgumentCaptor.capture());

        Participant capturedParticipant=participantArgumentCaptor.getValue();
        assertThat(capturedParticipant).isEqualTo(participant);
    }



    @Test
    void canGetAllParticipants() {
        underTest.findAll();
        verify(participantRepository).findAll();
    }
}