package com.example.semester4.ServerSideApp.service;
import com.example.semester4.ServerSideApp.model.Recipe;
import com.example.semester4.ServerSideApp.repository.RecipeRepository;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public void createRecipe(Recipe recipe, MultipartFile multipartFile) throws IOException {

        if (multipartFile.getSize() != 0) {
            recipe.setImageContent(multipartFile.getBytes());
            recipe.setImageType(multipartFile.getContentType());
        }

        recipeRepository.save(recipe);
    }

    public Recipe getRecipe(int id) {
        return recipeRepository.findById(id).get();
    }


}
