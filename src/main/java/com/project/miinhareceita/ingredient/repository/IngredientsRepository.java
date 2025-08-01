package com.project.miinhareceita.ingredient.repository;

import com.project.miinhareceita.ingredient.domain.Ingredients;
import com.project.miinhareceita.ingredient.projection.IngredientProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IngredientsRepository extends JpaRepository<Ingredients, Long> {

    @Query(nativeQuery = true, value = """
	SELECT tb_ingredients.id, tb_ingredients.name
	FROM tb_ingredients
	WHERE (:name IS NULL OR LOWER(tb_ingredients.name) LIKE LOWER(CONCAT('%',:name,'%')))
	""")
    List<IngredientProjection> searchProducts(String name);
}
