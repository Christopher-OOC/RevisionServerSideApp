package com.example.semester4.ServerSideApp.controller;

import com.example.semester4.ServerSideApp.model.Ingredient;
import com.example.semester4.ServerSideApp.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToIngredientConverter implements Converter<String, Ingredient> {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public Ingredient convert(String ingredientName) {
        return ingredientRepository.findByName(ingredientName);
    }
}
