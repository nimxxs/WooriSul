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

    /* 오프라인 판매처 목록 */
    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg) {

        logger.info("store/offline/list 호출!!");

        m.addAttribute("offs", offsrv.readOffline(cpg));        /* 오프라인 판매처 모두 불러오기 */
        m.addAttribute("cpg", cpg);                             /* 오프라인 판매처 현재 페이지 숫자 */
        m.addAttribute("cntpg", offsrv.countPageOffline());     /* 오프라인 판매처 리스트 페이지 수 */
        m.addAttribute("cntoff", offsrv.countAllOffline());     /* 오프라인 판매처 총 개수 */
        m.addAttribute("stpg", ((cpg-1)/10)*10+1);  /* 오프라인 판매처 리스트 페이지네이션 첫번째 수 */

        if(cpg > (int)m.getAttribute("cntpg"))  {
            return "redirect:/store/offline/list/1";
        }   /* 주소창에 실제 있는 오프라인 구매처 페이지 이상의 수를 입력시 1페이지로 이동 */

        return "offline/list";
    }

    /* 오프라인 판매처 상세소개 */
    @GetMapping("/view/{fno}")
    public String view(Model m, @PathVariable String fno){
        logger.info("store/offline/view 호출!");
        m.addAttribute("off", offsrv.readOneOffline(fno));
        m.addAttribute("fno", Integer.valueOf(fno));            /* 오프라인 판매처 번호 */
        m.addAttribute("cntoff", offsrv.countAllOffline());     /* 오프라인 판매처 총 개수 */

        return "offline/view";
    }

    @GetMapping("/find/{findofftype}/{findoffkey}/{cpg}")
    public String find(Model m, @PathVariable Integer cpg, @PathVariable String findofftype, @PathVariable String findoffkey){
        logger.info("offline/find 호출!");

        m.addAttribute("cpg", cpg);
        m.addAttribute("fofftype", findofftype);          /* 검색 옵션 */
        m.addAttribute("foffkey", findoffkey);            /* 검색어 */
        m.addAttribute("offs", offsrv.readFindOffline(findofftype, findoffkey, cpg));    /* 검색에 맞는 오프라인 판매처 불러오기 */
        m.addAttribute("stpg", ((cpg-1)/10)*10+1);
        m.addAttribute("cntpg", offsrv.countPageFindOffline(findofftype, findoffkey));   /* 검색에 맞는 오프라인 판매처들의 페이지 수 */
        m.addAttribute("cntoff", offsrv.countFindOffline(findofftype, findoffkey));      /* 검색에 맞는 오프라인 판매처 총 개수 */

        if(cpg > (int)m.getAttribute("cntpg"))  {
            return "redirect:/store/offline/list/1";
        }   /* 주소창에 잘못된 검색어 입력시 리스트 1 페이지로 이동 */

        return "offline/list";
    }
}
