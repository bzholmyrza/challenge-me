package kz.edu.astanait.challengeme.repository;

import kz.edu.astanait.challengeme.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
// принцип ООП: абстракция-реализация - здесь описываем все доступные способы доступа к данным
public interface PriorityRepository extends JpaRepository<Priority, Long> {
    // получить все значения, сортировка по id
    List<Priority> findAllByOrderByIdAsc();

    // если title == null или =='', то получим все значения
    @Query("SELECT c FROM Priority c where " +
            "(:title is null or :title='' or lower(c.title) like lower(concat('%', :title,'%')))  " +
            "order by c.title asc")
    List<Priority> findByTitle(@Param("title") String title);
}
