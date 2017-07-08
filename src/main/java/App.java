import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class App {
    public static void main(String[] args){
       staticFileLocation("/public");
       String layout = "templates/layout.vtl";

       get("/", (request, response) -> {
           Map<String, Object> model = new HashMap<String, Object>();
           model.put("members", request.session().attribute("members"));
           model.put("template", "templates/index.vtl");
           return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());

        post("/members", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            ArrayList<Member> members = request.session().attribute("members");
            if (members == null) {
                members = new ArrayList<Member>();
                request.session().attribute("members", members);
            }
            String firstName = request.queryParams("firstName");
            String lastName = request.queryParams("lastName");
            Member newMember = new Member(firstName,lastName);
            members.add(newMember);

            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

      }
    }

