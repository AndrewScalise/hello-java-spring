package org.launchcode.hellospring.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Mugen on 5/15/2017.
 */
@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request){
        String name = request.getParameter("name");

        if(name==null){
            name="World";
        }

        return "Hello " +name;
    }

    @RequestMapping(value="hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm(){
        String html = "<form method='post'>"+
                "<input type='text' name='name'/>" +
                "<select name='select'>" +
                "   <option value='English'>English</option>"+
                "   <option value='French'>French</option>"+
                "   <option value='Japanese'>Japanese</option>"+
                "   <option value='Korean'>Korean</option>"+
                "   <option value='Spanish'>Spanish</option>"+
                "</select>"+
                "<input type='submit' value='Greet Me!'/>" +
                "</form>";

        return html;
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request){

        String name = request.getParameter("name");
        String select = request.getParameter("select");

        switch (select){
            case "French":
                return "Bonjour " +name;

            case "Japanese":
                return "Konnichiwa " +name;

            case "Korean":
                return "Anyanghaseyo " +name;

            case "Spanish":
                return "Hola " +name;

            default:
                return "Hello " + name;
        }

    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name){

        return "Hello " + name;
    }


    @RequestMapping(value="goodbye")
    @ResponseBody
    public String goodbye(){
        return "redirect:/";
    }
}
