import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import Animals.Animal;
import Dao.Dao;
import Dao.Sql2oSightingDao;
import Sightings.Sighting;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");
        Dao dao = new Dao();
        Sql2oSightingDao sightDao=new Sql2oSightingDao();

        //****************************************
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

        get("/new-sight",(req,res)->{
            Map<String, Object> model= new HashMap<>();
            return new ModelAndView(model, "newsightings.hbs");
        }, new HandlebarsTemplateEngine());
        //Sight Success route
        post("/sightSuccess",(req,res)->{
            Map<String, Object> model= new HashMap<>();
            int animal_id= Integer.parseInt(req.queryParams("animal_id"));
            String location=req.queryParams("location");
            String rangerName=req.queryParams("rangerName");
            // save to session
            model.put("animal_id",animal_id);
            model.put("location",location);
            model.put("rangerName",rangerName);
            //Creating a new sight using inputs above
            Sighting sighting=new Sighting(location,rangerName,animal_id);
            // saving to the database
            sightDao.add(sighting);

            return new ModelAndView(model,"sightSuccess.hbs") ;
        }, new HandlebarsTemplateEngine());
        //*******************************************
//
//

        //Route to show all animals
        get("/allAnimals", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animal = dao.findAll();
            return new ModelAndView(model, "allAnimals.hbs");
        }, new HandlebarsTemplateEngine());

        // route to display all allSighting.hbs
        get("/allSighting", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            //List<Sighting> animal = sightDao.findAll();
            return new ModelAndView(model, "allSighting.hbs");
        }, new HandlebarsTemplateEngine());

        //******************************************
        //Post trial method



        }
}
