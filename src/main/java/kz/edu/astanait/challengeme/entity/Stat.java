package kz.edu.astanait.challengeme.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Stat {
    @Id
    @Column(name = "id")
    private Long id;

    @Basic
    @Column(name = "completed_total")
    private Long completedTotal;

    @Basic
    @Column(name = "uncompleted_total")
    private Long uncompletedTotal;
}
