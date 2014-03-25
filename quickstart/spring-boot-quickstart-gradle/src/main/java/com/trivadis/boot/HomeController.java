package com.trivadis.boot;

import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hello Trivadis!";
    }
}