package edu.sjsu.cmpe275.lab2.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yutao on 3/29/16.
 */
@Controller
public class HttpErrorController {

    @RequestMapping("/404")
    public String error404() {
        return "error";
    }
}
