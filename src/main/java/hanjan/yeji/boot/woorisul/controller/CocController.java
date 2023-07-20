package hanjan.yeji.boot.woorisul.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/coc")
public class CocController {

    Logger logger = LogManager.getLogger(CocController.class);

    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg){
        logger.info("coc/list 호출!!");

        return "coc/list";
    }
    @GetMapping("/view")
    public String view(){
        logger.info("coc/view 호출!!");

        return "coc/view";
    }



}