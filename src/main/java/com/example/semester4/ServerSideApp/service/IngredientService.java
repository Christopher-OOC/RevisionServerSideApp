package com.example.semester4.ServerSideApp.service;

import com.example.semester4.ServerSideApp.model.Ingredient;
import com.example.semester4.ServerSideApp.repository.IngredientRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public void createIngredient(Ingredient ingredient) {
        ingredientRepository.save(ingredient);
    }

}
