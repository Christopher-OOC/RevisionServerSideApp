package com.example.semester4.ServerSideApp.repository;

import com.example.semester4.ServerSideApp.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}
