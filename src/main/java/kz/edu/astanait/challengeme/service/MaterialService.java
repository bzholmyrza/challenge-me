package kz.edu.astanait.challengeme.service;

import kz.edu.astanait.challengeme.entity.Challenge;
import kz.edu.astanait.challengeme.entity.Day;
import kz.edu.astanait.challengeme.entity.Material;
import kz.edu.astanait.challengeme.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    private final MaterialRepository materialRepository;

    public MaterialService(MaterialRepository materialRepository) {
        this.materialRepository = materialRepository;
    }

    public void deleteMaterial(long id){
        materialRepository.deleteById(id);
    }

    public List<Material> getMaterial(Day day, Challenge challenge){
       return materialRepository.getMaterialsByDayByDayIdAndChallengeByChallengeId(day, challenge);
    }

    public List<Material> getAllMaterials(Challenge challenge){
        return materialRepository.getMaterialsByChallengeByChallengeId(challenge);
    }


    public void save(Material material) {
        this.materialRepository.save(material);
    }



}
