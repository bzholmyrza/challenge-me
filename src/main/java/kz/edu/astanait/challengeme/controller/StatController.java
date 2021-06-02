package kz.edu.astanait.challengeme.controller;

import kz.edu.astanait.challengeme.entity.Stat;
import kz.edu.astanait.challengeme.service.StatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Если возникнет exception - клиенту вернется код  500 Internal Server Error, поэтому не нужно все действия оборачивать в try-catch
// используем @RestController вместо обычного @Controller, чтобы все ответы сразу оборачивались в JSON
// иначе пришлось бы выполнять лишнюю работу, использовать @ResponseBody для ответа, указывать тип отправки JSON
// Названия методов могут быть любыми, главное не дублировать их имена и URL mapping
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StatController {
    private final StatService statService; // сервис для доступа к данным (напрямую к репозиториям не обращаемся)
    private final Long defaultId = 1l; // l - чтобы тип числа был Long, иначе будет ошибка компиляции

    // автоматическое внедрение экземпляра класса через конструктор
    // не используем @Autowired ля переменной класса, т.к. "Field injection is not recommended "
    public StatController(StatService statService) {
        this.statService = statService;
    }

    // для статистика всгда получаем только одну строку с id=1 (согласно таблице БД)
    @GetMapping("/stat")
    public ResponseEntity<Stat> findById() {
        // можно не использовать ResponseEntity, а просто вернуть коллекцию, код все равно будет 200 ОК
        return  ResponseEntity.ok(statService.findById(defaultId));
    }
}