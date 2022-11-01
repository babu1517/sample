package com.example.board.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/user")
@Slf4j
public class UserController {

    @GetMapping("/input")
    public String input(){
        return "user/userInput";
    }

}
