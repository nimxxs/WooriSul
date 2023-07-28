package hanjan.yeji.boot.woorisul.controller;

import hanjan.yeji.boot.woorisul.service.OnStoreService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store/online")
@RequiredArgsConstructor
public class OnStoreController {

    final OnStoreService osrv;
    Logger logger = LogManager.getLogger(IndexController.class);

    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg) {

        logger.info("store/online/list 호출!!");

        m.addAttribute("ons", osrv.readOnline(cpg));
        m.addAttribute("cpg", cpg);
        m.addAttribute("cntpg", osrv.countPageOnline());
        m.addAttribute("cnton", osrv.countAllOnline());
        m.addAttribute("stpg", ((cpg-1)/10)*10+1);

        if(cpg > (int)m.getAttribute("cntpg"))  {
            return "redirect:/store/online/list/1";
        }

        return "online/list";
    }

    @GetMapping("/find/{findtype}/{findkey}/{cpg}")
    public String find(Model m, @PathVariable Integer cpg, @PathVariable String findtype, @PathVariable String findkey){
        logger.info("online/find 호출!");

        m.addAttribute("cpg", cpg);
        m.addAttribute("ftype", findtype);
        m.addAttribute("fkey", findkey);
        m.addAttribute("ons", osrv.readFindOnline(findtype, findkey, cpg));
        m.addAttribute("stpg", ((cpg-1)/10)*10+1);
        m.addAttribute("cntpg", osrv.countPageFindOnline(findtype, findkey));
        m.addAttribute("cnton", osrv.countFindOnline(findtype, findkey));

//        m.addAttribute("cntbr", osrv.countAllOnline());

        if(cpg > (int)m.getAttribute("cntpg"))  {
            return "redirect:/store/online/list/1";
        }

        return "online/list";
    }
}
