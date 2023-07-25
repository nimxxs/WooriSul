package hanjan.yeji.boot.woorisul.controller;

import hanjan.yeji.boot.woorisul.model.SulBoard;
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

        int cntpg = sbsrv.countSulBoard();
        m.addAttribute("cntpg", sbsrv.countSulBoard());
        m.addAttribute("stpg", ((cpg-1) / 5) * 5 +1);

        if ( cpg > cntpg ) {
            return "redirect:/drink/list/1";
        }


        return "drink/list";

    }

    @GetMapping("/detail/{sno}")
    public String detail(Model m, @PathVariable String sno){
        logger.info("drink/detail 호출!");

        m.addAttribute("sbd", sbsrv.readOneSulBoard(sno));

        return "drink/detail";

    }

    @GetMapping("/tag")
    public String tag(){
        logger.info("drink/tag 호출!");


        return "drink/tag";

    }


}
