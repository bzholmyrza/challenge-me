package kz.edu.astanait.challengeme.repository;

import kz.edu.astanait.challengeme.entity.Challenge;
import kz.edu.astanait.challengeme.entity.Day;
import kz.edu.astanait.challengeme.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MaterialRepository extends JpaRepository<Material, Long> {
void deleteById(long id);

    @Override
    List<Material> findAll();

    List<Material> getMaterialsByDayByDayIdAndChallengeByChallengeId(Day day, Challenge challenge);
    List<Material> getMaterialsByChallengeByChallengeId(Challenge challenge);
    Material getMaterialsById(long id);
}
