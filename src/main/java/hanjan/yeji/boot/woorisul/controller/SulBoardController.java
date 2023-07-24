package hanjan.yeji.boot.woorisul.controller;

import hanjan.yeji.boot.woorisul.service.SulBoardService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drink")
@RequiredArgsConstructor

public class SulBoardController {

    final SulBoardService sbsrv;

    Logger logger = LogManager.getLogger(SulBoardController.class);

    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg){
        logger.info("drink/list 호출!");

        m.addAttribute("cpg", cpg);
        m.addAttribute("sbds", sbsrv.readSulBoard(cpg));

        return "drink/list";

    }

    @GetMapping("/detail/{sno}")
    public String detail(Model m, @PathVariable String sno){
        logger.info("drink/detail 호출!");

        m.addAttribute("sbd", sbsrv.readOneSulBoard(sno));

        return "drink/detail";

    }


}
