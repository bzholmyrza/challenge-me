package kz.edu.astanait.challengeme.search;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// возможные значения, по которым можно искать категории
public class CategorySearchValues {
    private String text;
}
