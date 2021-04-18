package kz.edu.astanait.challengeme.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    // указываем, что поле заполняется в БД
    // нужно, когда добавляем новый объект и он возвращается уже с новым id
    private Long id;

    @Basic
    @Column(name = "title")
    private String title;

    @Basic
    @Column(name = "completed")
    private Integer completed;

    @Basic
    @Column(name = "date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "priority_id", referencedColumnName = "id")
    // ссылка на объект Priority
    // одна задача имеет ссылку на один объект
    private Priority priority;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    // ссылка на объект Category
    // одна задача имеет ссылку на один объект
    private Category category;
}
