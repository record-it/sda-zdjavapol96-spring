package pl.sda.springproject.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class HomeController {
    int counter = 0;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String home(){
        return "Hello from Spring";
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello(@RequestParam String name){
        return "Hello " + name;
    }

    @GetMapping("/count")
    @ResponseBody
    public String counter(@RequestParam(defaultValue = "0") int a){
        counter += a;
        return String.format("%d", counter);
    }

    @GetMapping("/power")
    @ResponseBody
    public String power(@RequestParam(defaultValue = "0") double number,
                        @RequestParam(defaultValue = "2") int exp){
        return String.format("%.4f", Math.pow(number, exp));
    }

    @GetMapping("/servlet-power")
    public void testServlet(HttpServletRequest request,
                            HttpServletResponse response) throws IOException {
        final String numberStr = request.getParameter("number");
        final String expStr = request.getParameter("exp");
        try {
            double number = 0; //wartość domyślna
            if (numberStr != null) {
                number = Double.parseDouble(numberStr);
            }
            int exp = Integer.parseInt(expStr);
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println(String.format("%.4f", Math.pow(number, exp)));
        } catch (NumberFormatException e){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }

    }
}
