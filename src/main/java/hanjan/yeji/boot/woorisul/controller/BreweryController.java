package hanjan.yeji.boot.woorisul.controller;

import hanjan.yeji.boot.woorisul.service.BreweryService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brewery")
@RequiredArgsConstructor
public class BreweryController {

    final BreweryService bsrv;

    Logger logger= LogManager.getLogger(BreweryController.class);

    /* 양조장 목록 */
    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg){
        logger.info("brewery/list 호출!");

        m.addAttribute("brs", bsrv.readBrewery(cpg));       /* 양조장 모두 불러오기 */
        m.addAttribute("cpg", cpg);                         /* 양조장 현재 페이지 숫자 */
        m.addAttribute("cntpg", bsrv.countPageBrewery());   /* 양조장 리스트 페이지 수 */
        m.addAttribute("cntbr", bsrv.countAllBrewery());    /* 양조장 총 개수 */
        m.addAttribute("stpg", ((cpg-1)/10)*10+1);  /* 양조장 리스트 페이지네이션 첫번째 수 */

        if(cpg > (int)m.getAttribute("cntpg"))  {
            return "redirect:/brewery/list/1";
        }   /* 주소창에 실제 있는 양조장 페이지 이상의 수를 입력시 1페이지로 이동 */

        return "brewery/list";
    }

    /* 양조장 상세소개 */
    @GetMapping("/view/{bno}")
    public String view(Model m, @PathVariable String bno){
        logger.info("brewery/view 호출!");
        m.addAttribute("br", bsrv.readOneBrewery(bno));

        return "brewery/view";
    }

    /* 양조장 검색 결과 */
    @GetMapping("/find/{findbrtype}/{findbrkey}/{cpg}")
    public String find(Model m, @PathVariable Integer cpg, @PathVariable String findbrtype, @PathVariable String findbrkey){
        logger.info("brewery/find 호출!");

        m.addAttribute("cpg", cpg);
        m.addAttribute("fbrtype", findbrtype);              /* 검색 옵션 */
        m.addAttribute("fbrkey", findbrkey);                /* 검색어 */
        m.addAttribute("brs", bsrv.readFindBrewery(findbrtype, findbrkey, cpg));    /* 검색에 맞는 양조장 불러오기 */
        m.addAttribute("stpg", ((cpg-1)/10)*10+1);
        m.addAttribute("cntpg", bsrv.countPageFindBrewery(findbrtype, findbrkey));  /* 검색에 맞는 양조장들의 페이지 수 */
        m.addAttribute("cntbr", bsrv.countFindBrewery(findbrtype, findbrkey));      /* 검색에 맞는 양조장 총 개수 */

        if(cpg > (int)m.getAttribute("cntpg"))  {
            return "redirect:/brewery/list/1";
        }   /* 주소창에 잘못된 검색어 입력시 리스트 1 페이지로 이동 */

        return "brewery/list";
    }


}