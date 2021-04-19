package kz.edu.astanait.challengeme.controller;

import kz.edu.astanait.challengeme.entity.Category;
import kz.edu.astanait.challengeme.repository.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// используем @RestController вместо обычного @Controller, чтобы все ответы сразу оборачивались в JSON
// иначе пришлось бы выполнять лишнюю работу, использовать @ResponseBody для ответа, указывать тип отправки JSON
@RestController
@RequestMapping ("/category") // базовый адрес
public class CategoryController {
    // доступ к данным из БД
    private CategoryRepository categoryRepository;

    // автоматическое внедрение экземпляра класса через конструктор
    // не используем @Autowired ля переменной класса, т.к. "Field injection is not recommended "
    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    // для тестирования адрес: http://localhost:8080/category/test
    @GetMapping("/test")
    public List<Category> test() {
        List<Category> list = categoryRepository.findAll();
        return list; // JSON формат будет использоваться автоматически
    }
}
