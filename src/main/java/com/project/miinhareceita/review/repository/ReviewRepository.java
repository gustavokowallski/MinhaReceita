package com.project.miinhareceita.review.repository;

import com.project.miinhareceita.review.domain.Review;
import com.project.miinhareceita.review.projection.ReviewProjections;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    @Query(nativeQuery = true, value = """
        SELECT *
        FROM tb_review
        WHERE recipe_id = :recipeId
        """)
    List<ReviewProjections> findReviewByRecipeId(Long recipeId);
}
