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

    /* 온라인 판매처 목록 */
    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg) {

        logger.info("store/online/list 호출!!");

        m.addAttribute("ons", osrv.readOnline(cpg));        /* 온라인 판매처 모두 불러오기 */
        m.addAttribute("cpg", cpg);                         /* 온라인 판매처 현재 페이지 숫자 */
        m.addAttribute("cntpg", osrv.countPageOnline());    /* 온라인 판매처 리스트 페이지 수 */
        m.addAttribute("cnton", osrv.countAllOnline());     /* 온라인 판매처 총 개수 */
        m.addAttribute("stpg", ((cpg-1)/10)*10+1);  /* 온라인 판매처 리스트 페이지네이션 첫번째 수 */

        if(cpg > (int)m.getAttribute("cntpg"))  {
            return "redirect:/store/online/list/1";
        }   /* 주소창에 실제 있는 온라인 구매처 페이지 이상의 수를 입력시 1페이지로 이동 */

        return "online/list";
    }

    /* 온라인 판매처 검색 결과 */
    @GetMapping("/find/{findontype}/{findonkey}/{cpg}")
    public String find(Model m, @PathVariable Integer cpg, @PathVariable String findontype, @PathVariable String findonkey){
        logger.info("online/find 호출!");

        m.addAttribute("cpg", cpg);
        m.addAttribute("fontype", findontype);          /* 검색 옵션 */
        m.addAttribute("fonkey", findonkey);            /* 검색어 */
        m.addAttribute("ons", osrv.readFindOnline(findontype, findonkey, cpg));    /* 검색에 맞는 온라인 판매처 불러오기 */
        m.addAttribute("stpg", ((cpg-1)/10)*10+1);
        m.addAttribute("cntpg", osrv.countPageFindOnline(findontype, findonkey));  /* 검색에 맞는 온라인 판매처들의 페이지 수 */
        m.addAttribute("cnton", osrv.countFindOnline(findontype, findonkey));      /* 검색에 맞는 온라인 판매처 총 개수 */

//        m.addAttribute("cntbr", osrv.countAllOnline());

        if(cpg > (int)m.getAttribute("cntpg"))  {
            return "redirect:/store/online/list/1";
        }   /* 주소창에 잘못된 검색어 입력시 리스트 1 페이지로 이동 */

        return "online/list";
    }
}
