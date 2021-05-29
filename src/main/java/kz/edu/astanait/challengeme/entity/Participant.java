package kz.edu.astanait.challengeme.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Participant {
    private Long id;

    private Long userXp;
    private Challenge challengeByChallengeId;
    private User userByUserId;

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
    @Column(name = "user_xp")
    public Long getUserXp(int i) {
        return userXp;
    }

    public void setUserXp(Long userXp) {
        this.userXp = userXp;
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
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Participant that = (Participant) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}