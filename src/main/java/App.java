import java.util.Map;
import java.util.HashMap;

import Animals.Animal;
import Dao.DaoInterface;
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
        post("/success", (request,response)->{
            Map<String, Object> model= new HashMap<>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String health = request.queryParams("health");
            String ranger = request.queryParams("ranger");
            String endangered = request.queryParams("endangered");
            Animal animal=new Animal(name,age,health,ranger);
            //model.put("endangered",endangered);
            //Trying to save to sessions to confirms it works
            model.put("name",name);
            model.put("age",age);
            model.put("health",health);
            model.put("endangered",endangered);
           //DaoInterface.add(endangered);
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());
    // all
        get("/new-sight",(req,res)->{
            Map<String, Object> model= new HashMap<>();
            return new ModelAndView(model, "newsightings.hbs");
        }, new HandlebarsTemplateEngine());
        //Sight Success route
        post("/sightSuccess", (request,response)->{
            Map<String, Object> model= new HashMap<>();
            String animalId = request.queryParams("animalId");
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            Sighting sighting=new Sighting(animalId,location,rangerName);
            //Trying to save to sessions to confirms it works
            model.put("animalId",animalId);
            model.put("location",location);
            model.put("rangerName",rangerName);

            return new ModelAndView(model,"sightSuccess.hbs");
        }, new HandlebarsTemplateEngine());


        }
}
