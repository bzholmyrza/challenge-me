package kz.edu.astanait.challengeme.repository;

import kz.edu.astanait.challengeme.entity.Challenge;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends JpaRepository<Challenge, Long> {

}
