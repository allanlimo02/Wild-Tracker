import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import Animals.Endangered;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        get("/new-animal",(req,res)->{
            Map<String, Object> model= new HashMap<>();
            return new ModelAndView(model, "endangeredInput.hbs");
        }, new HandlebarsTemplateEngine());
        }
}
