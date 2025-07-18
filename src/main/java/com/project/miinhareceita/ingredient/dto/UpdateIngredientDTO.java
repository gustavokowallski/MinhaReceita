package com.project.miinhareceita.ingredient.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UpdateIngredientDTO implements ValidIngredientDTO {

    @NotBlank(message = "Nome não deve estar em branco")
    private String name;

    @Override
    public String getName() {
        return name;
    }
}
