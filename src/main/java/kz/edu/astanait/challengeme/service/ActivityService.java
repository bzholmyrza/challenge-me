package kz.edu.astanait.challengeme.service;

import kz.edu.astanait.challengeme.entity.Activity;
import kz.edu.astanait.challengeme.entity.Challenge;
import kz.edu.astanait.challengeme.entity.Material;
import kz.edu.astanait.challengeme.entity.User;
import kz.edu.astanait.challengeme.repository.ActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {
    private final ActivityRepository  activityRepository;
    @Autowired
    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }
    public Activity getActivity(Material material){
        return activityRepository.getActivityByMaterialByMaterialId(material);
    }

    public List<Activity> getChallengeActivities(Challenge challenge, User user){
        return activityRepository.getActivitiesByChallengeByChallengeIdAndUserByUserId(challenge, user);
    }
}
