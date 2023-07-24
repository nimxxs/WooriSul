package hanjan.yeji.boot.woorisul.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    Logger logger = LogManager.getLogger(IndexController.class);
    @GetMapping("/")
    public String index() {
        logger.info("index 호출!!");

        return "index";
    }
    @GetMapping("/intro")
    public String intro() {
        logger.info("intro 호출!!");

        return "intro";
    }
}