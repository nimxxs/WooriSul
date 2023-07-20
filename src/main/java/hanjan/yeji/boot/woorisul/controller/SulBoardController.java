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
@RequestMapping("/sulboard")
@RequiredArgsConstructor

public class SulBoardController {

    final SulBoardService sbsrv;

    Logger logger = LogManager.getLogger(SulBoardController.class);

    @GetMapping("/list")
    public String list(Model m, @PathVariable Integer cpg){
        logger.info("board/list 호출!");

        m.addAttribute("bds", bsrv.readBoard(cpg));
        //bsrv.readBoard를 실행해서 넘어온 결과가 bds로 넘어옴
        m.addAttribute("cpg", cpg);

        int cntpg = bsrv.countBoard();
        m.addAttribute("cntpg", bsrv.countBoard());
        m.addAttribute("stpg", ((cpg -1) / 10) *10 +1);

        // 만일 현재페이지가 총페이지수보다 크다면
        // cpg를 1로 강제 초기화(1페이지로 강제이동)
//        if ( cpg > cntpg ) {
//            return "redirect:/board/list/1";
//        }


        return "board/list";

    }


}
