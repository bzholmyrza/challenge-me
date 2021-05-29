package kz.edu.astanait.challengeme.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;

@Entity
@Data
public class Challenge {
    private Long id;
    private String type;
    private String title;
    private String description;
    private String image;
    private Date startDate;
    private Date endDate;
    private Collection<Activity> activitiesById;
    private User userByAdminId;
    private Collection<Comment> commentsById;
    private Collection<Material> materialsById;
    private Collection<Participant> participantsById;

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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
    @Column(name = "start_date")
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }



    @OneToMany(mappedBy = "challengeByChallengeId")
    public Collection<Activity> getActivitiesById() {
        return activitiesById;
    }

    public void setActivitiesById(Collection<Activity> activitiesById) {
        this.activitiesById = activitiesById;
    }

    @ManyToOne
    @JoinColumn(name = "admin_id", referencedColumnName = "id")
    public User getUserByAdminId() {
        return userByAdminId;
    }

    public void setUserByAdminId(User userByAdminId) {
        this.userByAdminId = userByAdminId;
    }

    @OneToMany(mappedBy = "challengeByChallengeId")
    public Collection<Comment> getCommentsById() {
        return commentsById;
    }

    public void setCommentsById(Collection<Comment> commentsById) {
        this.commentsById = commentsById;
    }

    @OneToMany(mappedBy = "challengeByChallengeId")
    public Collection<Material> getMaterialsById() {
        return materialsById;
    }

    public void setMaterialsById(Collection<Material> materialsById) {
        this.materialsById = materialsById;
    }

    @OneToMany(mappedBy = "challengeByChallengeId")
    public Collection<Participant> getParticipantsById() {
        return participantsById;
    }

    public void setParticipantsById(Collection<Participant> participantsById) {
        this.participantsById = participantsById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Challenge challenge = (Challenge) o;

        if (id != null ? !id.equals(challenge.id) : challenge.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}