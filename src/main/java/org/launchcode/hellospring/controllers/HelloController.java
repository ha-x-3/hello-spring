package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("hello")
public class HelloController {

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }
    @ResponseBody
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

//    @GetMapping("hello")
//    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }

//    @GetMapping("hello")
//    @RequestMapping(method={RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name, Model model) {
//        String greeting = "Hello, " + name + "!";
//        model.addAttribute("greeting", greeting);
//        return "hello";
//    }


    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    public String helloPost(@RequestParam String name, @RequestParam String language, Model model) {
        if (name == null || name.isEmpty()) {
            name = "World";
        }
        String theGreeting = createMessage(name, language);
        model.addAttribute("greeting", theGreeting);
        return "hello";
    }

    public static String createMessage(String n, String l) {
        String greeting = "";
        if (l.equals("english")) {
            greeting = "Hello";
        }
        if (l.equals("spanish")) {
            greeting = "Hola";
        }
        if (l.equals("french")) {
            greeting = "Bonjour";
        }
        if (l.equals("german")) {
            greeting = "Hallo";
        }
        if (l.equals("dothraki")) {
            greeting = "Athchomar chomakaan";
        }
        if (l.equals("valyrian")) {
            greeting = "Rytsas";
        }

//        return "<h1 style='color: purple; font-family: Helvetica; text-align: center; padding-top: 50px;'>"
//                + greeting + ", " + n + "!" + "</h1>";
        return greeting + ", " + n + "!";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        List<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Brittney");
        names.add("Java");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
