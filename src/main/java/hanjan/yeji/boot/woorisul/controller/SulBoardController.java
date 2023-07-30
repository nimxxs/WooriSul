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
        int total = 0;
        if (sname != null || (region != null && !region.isEmpty())) { // 지역(region) 파라미터가 null이 아니고 빈 문자열이 아닐 때만 검색을 수행
            sulList = sbsrv.searchSul(sname, region, cpg);
            total = sbsrv.countSearchSul(sname, region);
        } else {
            sulList = sbsrv.readSulBoard(kind, cpg);
            total = sbsrv.totalSulBoard(kind);
        }

        m.addAttribute("cpg", cpg);
        m.addAttribute("sbds", sulList);

        int cntpg = total > 1 ? (total + 2) / 3 : 1;
        // cntpg의 계산을 수정하여 total이 0 또는 1인 경우 페이지 수(cntpg)가 1이 되도록 했습니다.
        // total이 1보다 큰 경우에만 (total + 9) / 10 계산을 수행합니다.
        // 이렇게 하면, 게시물이 1개 또는 없는 경우에도 페이징 처리가 잘 동작
        m.addAttribute("cntpg", cntpg);
        m.addAttribute("cntbr", total);
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

        int totalSulCount = sbsrv.selectCountSulBoardByTag(tag);
        int itemPerPage= 3;
        int pageCount = totalSulCount / itemPerPage;
        if(totalSulCount % itemPerPage != 0){
            pageCount++;
        }

        m.addAttribute("cntpg", pageCount);
        m.addAttribute("cntbr", totalSulCount);
        m.addAttribute("stpg", ((cpg-1) / 3) * 3 +1);

        if (cpg > pageCount) {
            return "redirect:/drink/tag/" + tag + "/1";
        }

        m.addAttribute("tag", tag);

        return "drink/tag";
    }



}