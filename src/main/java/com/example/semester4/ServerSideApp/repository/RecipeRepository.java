package com.example.semester4.ServerSideApp.repository;

import com.example.semester4.ServerSideApp.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
}
