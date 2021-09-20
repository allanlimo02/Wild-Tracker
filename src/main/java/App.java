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
        post("/newSight",(req,res)->{
            Map<String, Object> model= new HashMap<>();
            String animal_id=req.queryParams("animal_id");
            String location=req.queryParams("location");
            String rangerName=req.queryParams("rangerName");
            // save to session
            model.put("animal_id",animal_id);
            model.put("location",location);
            model.put("rangerName",rangerName);
            //Creating a new sight using inputs above
            Sighting sighting=new Sighting(location,rangerName,animal_id);
            // saving to the database
            sightingImplementing.add(sighting);


            return new ModelAndView(model,"sightSuccess.hbs") ;
        }, new HandlebarsTemplateEngine());
        //*******************************************
//        post("/sightSuccess", (request,response)->{
//            Map<String, Object> model= new HashMap<>();
//            //int animalId = Integer.parseInt(request.queryParams("animalId"));
//            String animalId=request.queryParams("animalId");
//            String location = request.queryParams("location");
//            String rangerName = request.queryParams("rangerName");
//            //Trying to save to sessions to confirms it works
//            model.put("animalId",animalId);
//            model.put("location",location);
//            model.put("rangerName",rangerName);
//            Sighting sight= new Sighting(location,rangerName,animalId);
//            sightingImplementing.add(sight);
//            return new ModelAndView(model,"sightSuccess.hbs");
       // }, new HandlebarsTemplateEngine());

        //******************************************8
//        post("/sightSuccess", (request,response)->{
//            Map<String, Object> model= new HashMap<>();
//            //int animal_id = Integer.parseInt(request.queryParams("animal_id"));
//            String animal_id=request.queryParams("animal_id");
//            String location = request.queryParams("location");
//            String rangerName = request.queryParams("rangerName");
//            Sighting sight=new Sighting(location,rangerName,"22");
//            model.put("location",location);
//            model.put("ranger_name",rangerName);
//            model.put("animal_id",animal_id);
//            System.out.println("1"+location+"\n 2"+rangerName+"\n 3"+animal_id);
//           sightingImplementing.add(sight);
//
//            return new ModelAndView(model,"sightSuccess.hbs");
//        }, new HandlebarsTemplateEngine());
        //############################################
        //Route to show all animals
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            List<Animal> animal = dao.findAll();

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());
        //******************************************
        //Post trial method



        }
}
