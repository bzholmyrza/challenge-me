package kz.edu.astanait.challengeme.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Activity {
    private Long id;

    private Boolean status;
    private User userByUserId;
    private Material materialByMaterialId;
    private Challenge challengeByChallengeId;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "status")
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @ManyToOne
    @JoinColumn(name = "material_id", referencedColumnName = "id")
    public Material getMaterialByMaterialId() {
        return materialByMaterialId;
    }

    public void setMaterialByMaterialId(Material materialByMaterialId) {
        this.materialByMaterialId = materialByMaterialId;
    }

    @ManyToOne
    @JoinColumn(name = "challenge_id", referencedColumnName = "id")
    public Challenge getChallengeByChallengeId() {
        return challengeByChallengeId;
    }

    public void setChallengeByChallengeId(Challenge challengeByChallengeId) {
        this.challengeByChallengeId = challengeByChallengeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Activity activity = (Activity) o;

        if (id != null ? !id.equals(activity.id) : activity.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}