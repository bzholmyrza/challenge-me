package kz.edu.astanait.challengeme.service;

import kz.edu.astanait.challengeme.entity.Activity;
import kz.edu.astanait.challengeme.entity.Day;
import kz.edu.astanait.challengeme.repository.DayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayService {
    private final DayRepository dayRepository;

    @Autowired
    public DayService(DayRepository dayRepository) {
        this.dayRepository = dayRepository;
    }
    public List<Day> getDays(){
        return dayRepository.findAll();
    }
    public Day getDay(long id){
        return dayRepository.getDayById(id);
    }
    public void deleteTask(long id){
        dayRepository.deleteById(id);
    }

}
