package kz.edu.astanait.challengeme.repository;

import kz.edu.astanait.challengeme.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
