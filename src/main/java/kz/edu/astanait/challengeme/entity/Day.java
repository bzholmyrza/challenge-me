package kz.edu.astanait.challengeme.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data
public class Day {
    private Long id;

    private String name;
    private Collection<Material> materialsById;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Day day = (Day) o;

        if (id != null ? !id.equals(day.id) : day.id != null) return false;
        if (name != null ? !name.equals(day.name) : day.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "dayByDayId")
    public Collection<Material> getMaterialsById() {
        return materialsById;
    }

    public void setMaterialsById(Collection<Material> materialsById) {
        this.materialsById = materialsById;
    }
}