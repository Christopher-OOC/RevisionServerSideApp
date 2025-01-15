package com.example.semester4.ServerSideApp.controller;

import com.example.semester4.ServerSideApp.model.Ingredient;
import com.example.semester4.ServerSideApp.model.Recipe;
import com.example.semester4.ServerSideApp.service.IngredientService;
import com.example.semester4.ServerSideApp.service.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/splacky-recipes")
public class WebController {

    private RecipeService recipeService;
    private IngredientService ingredientService;

    public WebController(
            RecipeService recipeService,
            IngredientService ingredientService
    ) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
    }

    @GetMapping(value = "/")
    public String showHomePage(Model model) {
        List<Recipe> recipes = recipeService.getAllRecipes();

        if (recipes.size() == 0) {
            model.addAttribute("noRecipe", true);
        }
        else {
            model.addAttribute("recipes", recipes);
        }

        return "home";
    }

    @GetMapping(value = "/create-recipe")
    public String createRecipe() {

        return "create-recipe";
    }

    @GetMapping(value = "/create-ingredient")
    public String showCreateIngredientPage(Model model) {
        model.addAttribute("newIngredient", new Ingredient());

        return "create-ingredient";
    }

    @PostMapping(value = "/create-ingredient")
    public String createIngredient(@ModelAttribute("newIngredient") Ingredient ingredient) {
        ingredientService.createIngredient(ingredient);

        return "redirect:/splacky-recipes/";
    }
}

