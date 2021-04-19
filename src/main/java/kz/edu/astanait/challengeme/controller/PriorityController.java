package kz.edu.astanait.challengeme.controller;

import kz.edu.astanait.challengeme.entity.Priority;
import kz.edu.astanait.challengeme.repository.PriorityRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
// используем @RestController вместо обычного @Controller, чтобы все ответы сразу оборачивались в JSON
// иначе пришлось бы выполнять лишнюю работу, использовать @ResponseBody для ответа, указывать тип отправки JSON
@RequestMapping("/priority")// базовый адрес
public class PriorityController {
    private PriorityRepository priorityRepository; // доступ к данным из БД

    // автоматическое внедрение экземпляра класса через конструктор
    // не используем @Autowired ля переменной класса, т.к. "Field injection is not recommended "
    public PriorityController(PriorityRepository priorityRepository) {
            this.priorityRepository = priorityRepository;
    }

    @GetMapping("/test") // для тестирования адрес: http://localhost:8080/category/test
    public List<Priority> test() {
        List<Priority> list = priorityRepository.findAll();
        return list; // JSON формат будет использоваться автоматически
    }
}
