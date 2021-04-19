package kz.edu.astanait.challengeme.repository;

import kz.edu.astanait.challengeme.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// принцип ООП: абстракция-реализация - здесь описываем все доступные способы доступа к данным
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    // получить все значения, сортировка по названию
    List<Category> findAllByOrderByTitleAsc();
}
