package hanjan.yeji.boot.woorisul.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/coc")
public class CocController {

    Logger logger = LogManager.getLogger(CocController.class);

    @GetMapping("/list")
    public String list(){
        logger.info("coc/list 호출!!");

        return "coc/list";
    }
    @GetMapping("/view")
    public String view(){
        logger.info("coc/view 호출!!");

        return "coc/view";
    }



}