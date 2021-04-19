package kz.edu.astanait.challengeme.repository;

import kz.edu.astanait.challengeme.entity.Priority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// принцип ООП: абстракция-реализация - здесь описываем все доступные способы доступа к данным
public interface PriorityRepository extends JpaRepository<Priority, Long> {

}
