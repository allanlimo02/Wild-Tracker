import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import Animals.Animal;
import Dao.Dao;
import SightingDAO.SightingImplementing;
import Sightings.Sighting;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        Dao dao = new Dao();
        SightingImplementing sightingImplementing= new SightingImplementing();
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
            //boolean endangered = request.queryParams("endangered");
            Animal animal=new Animal(name,health,age,false);
            //Trying to save to sessions to confirms it works
            model.put("name",name);
            model.put("age",age);
            model.put("health",health);
            model.put("endangered",false);
            dao.add(animal);
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());
        //Route to show all animals
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> tasks = dao.findAll();
            model.put("tasks", tasks);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

    // Sighting route
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
            //Trying to save to sessions to confirms it works
            model.put("animalId",animalId);
            model.put("location",location);
            model.put("rangerName",rangerName);
            Sighting sight= new Sighting(location,rangerName,animalId);
            sightingImplementing.add(sight);

            return new ModelAndView(model,"sightSuccess.hbs");
        }, new HandlebarsTemplateEngine());


        }
}
