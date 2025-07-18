package com.project.miinhareceita.review.dto;

import com.project.miinhareceita.review.domain.Review;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public class InsertReviewDTO implements ReviewValidDTO {

    @Min(value = 1, message = "A nota deve ser no mínimo 1")
    @Max(value = 5, message = "A nota deve ser no máximo 5")
    @NotNull(message = "A nota não deve ser nula")
    private Integer nota;


    private String comment;

    public InsertReviewDTO(Review review) {
        nota = review.getNota();
        comment = review.getComment();
    }

    @Override
    public Integer getNota() {
        return nota;
    }

    @Override
    public String getComment() {
        return comment;
    }
}
