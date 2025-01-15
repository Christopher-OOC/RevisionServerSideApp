package com.example.semester4.ServerSideApp.service;
import com.example.semester4.ServerSideApp.model.Recipe;
import com.example.semester4.ServerSideApp.repository.RecipeRepository;

import org.springframework.stereotype.Service;

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


}
