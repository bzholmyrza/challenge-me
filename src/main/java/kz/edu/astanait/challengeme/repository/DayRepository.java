package kz.edu.astanait.challengeme.repository;

import kz.edu.astanait.challengeme.entity.Day;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepository extends JpaRepository<Day, Long> {
Day getDayById(long id);
}
