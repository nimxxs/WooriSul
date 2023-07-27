package hanjan.yeji.boot.woorisul.controller;

import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {

    Logger logger = LogManager.getLogger(IndexController.class);

    @GetMapping("/list")
    public String list() {
        logger.info("store/list 호출!!");

        return "store/list";
    }
}
