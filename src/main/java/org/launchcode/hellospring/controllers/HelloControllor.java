package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloControllor {


//hello/form
    @RequestMapping(method = {RequestMethod.GET})
    public String helloForm() {
        return "<html>" +
                    "<body style='text-align: center; margin-top: 20vh; font-size: 30px'>" +
                        "<form method='post'>" + //submit a request to /hello
                            "<input type='text' name='name'>" +
                            "<select name='language'>" +
                                "<option value='french'> French </option>" +
                                "<option value='italian'> Italian </option>" +
                                "<option value='german'> German </option>" +
                                "<option value='spanish'> Spanish </option>" +
                                "<option value='english'> English </option>" +
                            "</select>"+
                            "<input type='submit' value='Greet me!'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }
    @RequestMapping(method = {RequestMethod.POST})
    public String createMessage(@RequestParam String name,@RequestParam String language) {
        if (name == "") {
            name = "World";
        }

        String greeting = "";

        if (language.equals("english")) {
            greeting = "Hello, ";
        } else if (language.equals("french")) {
            greeting = "Bonjour, ";
        } else if (language.equals("italian")) {
            greeting = "Ciao, ";
        } else if (language.equals("spanish")) {
            greeting = "Hola, ";
        } else if (language.equals("german")) {
            greeting = "Hallo, ";
        }
        return "<p style='color: red; text-align: center; margin-top: 20vh; font-size: 30px'>" + greeting + name + '!' +"</p>";
    }
}
