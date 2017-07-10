import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.staticFileLocation;
import static spark.Spark.get;
import static spark.Spark.post;

public class App {
    public static void main(String[] args){
       staticFileLocation("/public");
       String layout = "templates/layout.vtl";

       get("/", (request, response) -> {
           Map<String, Object> model = new HashMap<String, Object>();

           if(Member.all().isEmpty()) {
               Team firstTeam = new Team("ZipCargo", "Optimize space in cargo trucks. We provide a way for cargo trucks to optimize the leftover space that they have inside their trucks and generate new clients.");
               Team secondTeam = new Team("UrbanBeat", "App for users to get discounts and opportunities from brands when they are close to the brand’s location.");
               Team thirdTeam = new Team("NoMeRobes", "App that alerts you if your bicycle is getting stolen and allows you to track it to get it back.");
               Member firstMember = new Member("Ivan", "Ivanov", "Leader");
               Member secondMember = new Member("Peter", "Petrov", "Architect");
               Member thirdMember = new Member("Fedor", "Fedorov", "Marketing");
               Member fourthMember = new Member("Anna", "Kuznetsova", "Front-end Developer");
               Member fifthMember = new Member("Irina", "Vasilyeva", "Back-end Developer");
               Member sixthMember = new Member("Maria", "Ivanova", "Business development");
               firstTeam.addMember(firstMember);
               firstTeam.addMember(secondMember);
               firstTeam.addMember(thirdMember);
               firstTeam.addMember(fourthMember);
               firstTeam.addMember(fifthMember);
               firstTeam.addMember(sixthMember);

               secondTeam.addMember(firstMember);
               secondTeam.addMember(secondMember);
               secondTeam.addMember(thirdMember);
               secondTeam.addMember(fourthMember);
               secondTeam.addMember(fifthMember);
               secondTeam.addMember(sixthMember);

               thirdTeam.addMember(firstMember);
               thirdTeam.addMember(secondMember);
               thirdTeam.addMember(thirdMember);
               thirdTeam.addMember(fourthMember);
               thirdTeam.addMember(fifthMember);
           }
           model.put("teams", Team.all());
           model.put("members", request.session().attribute("members"));
           model.put("template", "templates/index.vtl");
           return new ModelAndView(model, layout);
       }, new VelocityTemplateEngine());

       /*get("members/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/member-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/members", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("members", Member.all());
            model.put("template", "templates/members.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());*/

        get("/members/:id", (request, response) -> {
            HashMap<String, Object> model = new HashMap<String, Object>();
            Member member = Member.find(Integer.parseInt(request.params(":id")));
            model.put("member", member);
            model.put("template", "templates/member.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/teams/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("template", "templates/team-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/teams", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("teams", Team.all());
            model.put("template", "templates/teams.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/teams/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Team team = Team.find(Integer.parseInt(request.params(":id")));
            model.put("team", team);
            model.put("template", "templates/team.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("teams/:id/members/new", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Team team = Team.find(Integer.parseInt(request.params(":id")));
            model.put("team", team);
            model.put("template", "templates/team-members-form.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());


        /*post("/members", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            String firstName = request.queryParams("firstName");
            String lastName = request.queryParams("lastName");

            Member newMember = new Member(firstName,lastName);
            model.put("member", newMember);
            model.put("template", "templates/success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine()); */

        post("/teams", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            String name = request.queryParams("name");
            String description = request.queryParams("description");
            Team newTeam = new Team(name, description);
            model.put("team", newTeam);
            model.put("template", "templates/team-success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        post("/members", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();

            Team team = Team.find(Integer.parseInt(request.queryParams("teamId")));

            String firstName = request.queryParams("firstName");
            String lastName = request.queryParams("lastName");
            String role = request.queryParams("role");

            Member newMember = new Member(firstName,lastName, role);

            team.addMember(newMember);

            model.put("member", newMember);
            model.put("team", team);
            model.put("template", "templates/team-members-success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

      }
    }

