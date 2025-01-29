package com.example.semester4.ServerSideApp.controller;

import com.example.semester4.ServerSideApp.model.Ingredient;
import com.example.semester4.ServerSideApp.model.Recipe;
import com.example.semester4.ServerSideApp.model.User;
import com.example.semester4.ServerSideApp.service.IngredientService;
import com.example.semester4.ServerSideApp.service.RecipeService;
import com.example.semester4.ServerSideApp.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/splacky-recipes")
public class WebController {

    private RecipeService recipeService;
    private IngredientService ingredientService;
    private UserService userService;

    public WebController(
            RecipeService recipeService,
            IngredientService ingredientService,
            UserService userService
    ) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.userService = userService;
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
    public String showCreateRecipePage(Model model) {
        model.addAttribute("ingredients", ingredientService.getAllIngredients());
        model.addAttribute("newRecipe", new Recipe());

        return "create-recipe";
    }

    @PostMapping(value = "/create-recipe", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String createRecipe(
            @ModelAttribute("newRecipe") Recipe recipe,
            @RequestParam("file") MultipartFile multipartFile
                               ) throws IOException {
        recipeService.createRecipe(recipe, multipartFile);

        System.out.println("RECIPE: " + recipe);

        return "redirect:/splacky-recipes/";
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

    @GetMapping(value = "/resources/{id}")
    public ResponseEntity<?> getResource(@PathVariable("id") int id) {
        Recipe recipe = recipeService.getRecipe(id);

        return ResponseEntity
                .ok()
                .contentType(MediaType.valueOf(recipe.getImageType()))
                .body(recipe.getImageContent());
    }

    @GetMapping(value = "/login")
    public String showLoginPage() {
        return "login";
    }

    @GetMapping(value = "/create-account")
    public String showCreateAccount(Model model) {
        model.addAttribute("newUser", new User());

        return "create-account";
    }

    @PostMapping(value = "/create-account")
    public String showCreateAccount(@ModelAttribute("newUser") User user) {
        userService.createUser(user);

        return "/splacky-recipes/";
    }


}

