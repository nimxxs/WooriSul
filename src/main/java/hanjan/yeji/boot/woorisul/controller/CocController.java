package hanjan.yeji.boot.woorisul.controller;

import hanjan.yeji.boot.woorisul.model.Cocktail;
import hanjan.yeji.boot.woorisul.service.CocktailService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;



@Controller
@RequestMapping("/coc")
@RequiredArgsConstructor
public class CocController {

    final CocktailService cocsrv;

    Logger logger = LogManager.getLogger(CocController.class);

    @GetMapping("/list/{cpg}")
    public String list(Model m, @PathVariable Integer cpg) {
        logger.info("coc/list 호출!!");

        m.addAttribute("cocs", cocsrv.readCocktail(cpg));
        m.addAttribute("cpg", cpg);
        int cntpg = cocsrv.countCocktail();
        m.addAttribute("cntpg", cntpg);
        m.addAttribute("stpg", ((cpg - 1) / 10) * 10 + 1);
        m.addAttribute("cntcoc", cocsrv.countAllCocktail());

        if (cpg  > cntpg)
            return "redirect:/coc/list/1";

        return "coc/list";
    }

    @GetMapping("/write")
    public String write() {
        logger.info("coc/write 호출!!");
        return "coc/write";
    }

    @PostMapping("/write")
    public String writeok(Cocktail c, List<MultipartFile> attachs) { /* 이름명칭이 같아야함 */
        logger.info("coc/writeok 호출!!");

        String returnPage = "redirect:/coc/fail";

        int cno = cocsrv.newCocktail(c);


        return returnPage;
    }

    @GetMapping("/view/{cno}")
    public String view(Model m, @PathVariable String cno) {
        logger.info("coc/view 호출!!");

        // cno를 정수로 변환하여 prevCno 계산
        int cnoValue = Integer.parseInt(cno);
        int prevCno = Integer.parseInt(cno) - 1;
        int nextCno = Integer.parseInt(cno) + 1;

        if (prevCno < 1) {
            prevCno = 1;
        }
        int cntpg = 23;

        if (nextCno > cntpg) {
            nextCno = cntpg;
        }

        m.addAttribute("c", cocsrv.readOneCocktail(cno));
        m.addAttribute("prevCno", prevCno);
        m.addAttribute("nextCno", nextCno);

        return "coc/view";
    }

    @GetMapping("/find/{findtype}/{findkey}/{cpg}") /*순서 바꿈*/
    public String find(Model m, @PathVariable Integer cpg, @PathVariable String findtype, @PathVariable String findkey
    ) {
        logger.info("coc/find 호출!!");

        m.addAttribute("cpg", cpg);
        m.addAttribute("ftype", findtype);
        m.addAttribute("fkey", findkey);
        m.addAttribute("csrv", cocsrv.readFindCocktail(findtype, findkey,cpg));
        m.addAttribute("stpg", ((cpg - 1) / 10) * 10 + 1);
        m.addAttribute("cntpg", cocsrv.countPageFindCocktail(findtype, findkey));
        m.addAttribute("cntcoc", cocsrv.countFindCocktail(findtype, findkey));

        if (cpg > (int) m.getAttribute("cntpg"))
            return "redirect:/coc/list/1";

        return "coc/list";
    }



}