package guru.springframework.sfgrecipeapp.controllers;

import guru.springframework.sfgrecipeapp.services.RecipeService;
import lombok.Data;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Controller
public class IndexController {

    private static final Logger log = org.slf4j.LoggerFactory.getLogger(IndexController.class);
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndex(Model model) {
        log.debug("Getting index page");

        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }
}
