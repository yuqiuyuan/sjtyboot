package com.dre.sjty.com.dre.sjty.web.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Component
@Controller
public class SjtyPropritiesController {


    @ResponseBody
    @RequestMapping("lp")
    public String getLocalProperty() {
        return null;
    }

    public static void main(String[] args) {

    }
}
