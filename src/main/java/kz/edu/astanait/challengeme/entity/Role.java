package kz.edu.astanait.challengeme.entity;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Role {
    private Long id;
    private String name;

    private Collection<User> users;


    public Role() {
    }

    public Role(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "roles", cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    public Collection<User> getUsers() {
        return users;
    }
    public void setUsers(Collection<User> users) {
        this.users = users;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}