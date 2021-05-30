package kz.edu.astanait.challengeme.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Data
public class Material {
    private Long id;
    private String title;
    private String description;
    private String image;
    private Integer points;
    private Challenge challengeByChallengeId;
    private Day dayByDayId;
    private Collection<Activity> activitiesById;

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
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "points")
    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }



    @ManyToOne
    @JoinColumn(name = "challenge_id", referencedColumnName = "id")
    public Challenge getChallengeByChallengeId() {
        return challengeByChallengeId;
    }

    public void setChallengeByChallengeId(Challenge challengeByChallengeId) {
        this.challengeByChallengeId = challengeByChallengeId;
    }

    @ManyToOne
    @JoinColumn(name = "day_id", referencedColumnName = "id")
    public Day getDayByDayId() {
        return dayByDayId;
    }

    public void setDayByDayId(Day dayByDayId) {
        this.dayByDayId = dayByDayId;
    }


    @OneToMany(mappedBy = "materialByMaterialId")
    public Collection<Activity> getActivitiesById() {
        return activitiesById;
    }

    public void setActivitiesById(Collection<Activity> activitiesById) {
        this.activitiesById = activitiesById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Material material = (Material) o;

        if (id != null ? !id.equals(material.id) : material.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}