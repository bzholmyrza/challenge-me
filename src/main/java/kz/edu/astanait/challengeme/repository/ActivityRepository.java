package kz.edu.astanait.challengeme.repository;

import kz.edu.astanait.challengeme.entity.Activity;
import kz.edu.astanait.challengeme.entity.Challenge;
import kz.edu.astanait.challengeme.entity.Material;
import kz.edu.astanait.challengeme.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ActivityRepository extends JpaRepository<Activity, Long> {
 Activity getActivityByMaterialByMaterialId(Material material);
 List<Activity> getActivitiesByChallengeByChallengeIdAndUserByUserId(Challenge challenge, User user);
}
