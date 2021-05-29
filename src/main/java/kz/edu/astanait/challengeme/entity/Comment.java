package kz.edu.astanait.challengeme.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Comment {
    private Long id;
    private String content;
    private Date publishDate;
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
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "publish_date")
    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
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

        Comment comment = (Comment) o;

        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}