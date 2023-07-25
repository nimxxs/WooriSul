package hanjan.yeji.boot.woorisul.controller;

import hanjan.yeji.boot.woorisul.service.AnjuService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/anju")
@RequiredArgsConstructor
public class AnjuController {
    final AnjuService asrv;
    Logger logger = LogManager.getLogger(AnjuController.class);

    @GetMapping("/list")
    public String anju(Model m) {
        logger.info("anju 호출!!");
        m.addAttribute("ads", asrv.readAnju());

        return "/anju/list";
    }
}