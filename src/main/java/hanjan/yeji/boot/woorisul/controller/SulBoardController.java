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
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/drink")
@RequiredArgsConstructor

public class SulBoardController {

    final SulBoardService sbsrv;

    Logger logger = LogManager.getLogger(SulBoardController.class);

    @GetMapping("/list/{kind}/{cpg}")
    public String list(Model m,
                       @PathVariable String kind,
                       @PathVariable Integer cpg,
                       @RequestParam(required = false) String sname,
                       @RequestParam(required = false) String region) {
        logger.info("drink/list 호출!");

        List<SulBoard> sulList;
        if (sname != null || region != null) {
            sulList = sbsrv.searchSul(sname, region);
        } else {
            sulList = sbsrv.readSulBoard(kind, cpg);
        }

        m.addAttribute("cpg", cpg);
        m.addAttribute("sbds", sulList);

        int cntpg = sbsrv.selectCountSulBoard(kind);
        m.addAttribute("cntpg", cntpg);
        m.addAttribute("cntbr", sbsrv.totalSulBoard(kind));
        m.addAttribute("stpg", ((cpg-1) / 3) * 3 +1);

        if (cpg > cntpg) {
            return "redirect:/drink/list/1";
        }

        m.addAttribute("kind", kind);

        return "drink/list";
    }




    @GetMapping("/detail/{sno}")
    public String detail(Model m, @PathVariable String sno){
        logger.info("drink/detail 호출!");

        m.addAttribute("sbd", sbsrv.readOneSulBoard(sno));


        return "drink/detail";

    }

    @GetMapping("/tag/{tag}/{cpg}")
    public String listByTag(Model m,
                            @PathVariable String tag,
                            @PathVariable Integer cpg) {
        logger.info("drink/listByTag 호출!");

        List<SulBoard> sulList = sbsrv.readSulBoardByTag(tag, cpg);

        m.addAttribute("cpg", cpg);
        m.addAttribute("sbds", sulList);

        int cntpg = sbsrv.selectCountSulBoardByTag(tag);
        m.addAttribute("cntpg", cntpg);
        m.addAttribute("cntbr", sbsrv.totalSulBoardByTag(tag));
        m.addAttribute("stpg", ((cpg-1) / 3) * 3 +1);

        if (cpg > cntpg) {
            return "redirect:/drink/tag/" + tag + "/1";
        }

        m.addAttribute("tag", tag);

        return "drink/tag";
    }



}