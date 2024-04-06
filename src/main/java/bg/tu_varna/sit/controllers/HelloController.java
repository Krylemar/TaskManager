package bg.tu_varna.sit.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // Used only to test if the application is running
    @GetMapping("/hello")
    public String getHello(){
        return "Hello World";
    }
}
