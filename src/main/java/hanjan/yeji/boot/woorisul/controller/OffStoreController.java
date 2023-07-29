package hanjan.yeji.boot.woorisul.controller;

import hanjan.yeji.boot.woorisul.service.OffStoreService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/store/offline")
@RequiredArgsConstructor
public class OffStoreController {

    final OffStoreService offsrv;
    Logger logger = LogManager.getLogger(IndexController.class);

    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg) {

        logger.info("store/offline/list 호출!!");

        m.addAttribute("offs", offsrv.readOffline(cpg));
        m.addAttribute("cpg", cpg);
        m.addAttribute("cntpg", offsrv.countPageOffline());
        m.addAttribute("cntoff", offsrv.countAllOffline());
        m.addAttribute("stpg", ((cpg-1)/10)*10+1);

        if(cpg > (int)m.getAttribute("cntpg"))  {
            return "redirect:/store/offline/list/1";
        }

        return "offline/list";
    }

    @GetMapping("/view/{fno}")
    public String view(Model m, @PathVariable String fno){
        logger.info("store/offline/view 호출!");
        m.addAttribute("off", offsrv.readOneOffline(fno));
        m.addAttribute("fno", Integer.valueOf(fno));
        m.addAttribute("cntoff", offsrv.countAllOffline());

        return "offline/view";
    }

    @GetMapping("/find/{findofftype}/{findoffkey}/{cpg}")
    public String find(Model m, @PathVariable Integer cpg, @PathVariable String findofftype, @PathVariable String findoffkey){
        logger.info("offline/find 호출!");

        m.addAttribute("cpg", cpg);
        m.addAttribute("fofftype", findofftype);
        m.addAttribute("foffkey", findoffkey);
        m.addAttribute("offs", offsrv.readFindOffline(findofftype, findoffkey, cpg));
        m.addAttribute("stpg", ((cpg-1)/10)*10+1);
        m.addAttribute("cntpg", offsrv.countPageFindOffline(findofftype, findoffkey));
        m.addAttribute("cntoff", offsrv.countFindOffline(findofftype, findoffkey));

//        m.addAttribute("cntbr", offsrv.countAllOffline());

        if(cpg > (int)m.getAttribute("cntpg"))  {
            return "redirect:/store/offline/list/1";
        }

        return "offline/list";
    }
}
