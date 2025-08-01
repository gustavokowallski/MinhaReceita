package com.project.miinhareceita.tests;

import com.project.miinhareceita.favorite.domain.Favorite;
import com.project.miinhareceita.recipe.domain.Recipe;
import com.project.miinhareceita.user.domain.User;

public class FavoriteFactory {
    public static Favorite createFavorite(){
        Recipe recipe = RecipeFactory.createRecipe();
        User user = UserFactory.createUser();
        return new Favorite(recipe, user);
    }
    public static Favorite createFavorite(Recipe recipe, User user){
        return new Favorite(recipe, user);
    }
}
