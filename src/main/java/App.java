import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import Animals.Endangered;
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
        get("/success", (request,response)->{
            Map<String, Object> model= new HashMap<>();
            String name = request.queryParams("name");
            String age = request.queryParams("age");
            String health = request.queryParams("health");
            Endangered endangered=new Endangered(name,age,health);
            model.put("endangered",endangered);
//            Trying to save to sessions to confirms it works
            model.put("name",name);
            model.put("age",age);
            model.put("health",health);
            //DaoInterface.add(endangered);
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());

        }
}
