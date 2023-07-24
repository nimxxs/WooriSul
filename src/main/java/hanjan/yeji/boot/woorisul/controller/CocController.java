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
        m.addAttribute("cntpg", cocsrv.countCocktail());
        m.addAttribute("stpg", ((cpg - 1) / 10) * 10 + 1);

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

        // 작성한 게시글을 먼저 디비에 저장하고 글번호를 알아냄
        int cno = cocsrv.newCocktail(c);

        // 알아낸 글번호를 이용해 첨부파일 처리 (디비저장, 업로드)
        if (!attachs.isEmpty()) {  // 첨부파일이 존재한다면
            cocsrv.newCocAttach(attachs, cno);

            returnPage = "redirect:/coc/list/1";
        }

        return returnPage;
    }

    @GetMapping("/view/{cno}")
    public String view(Model m, @PathVariable String cno) {
        logger.info("coc/view 호출!!");

        m.addAttribute("c", cocsrv.readOneCocktail(cno));

        return "coc/view";
    }

    @GetMapping("/find/{findtype}/{findkey}/{cpg}") /*순서 바꿈*/
    public String find(Model m, @PathVariable Integer cpg,
                       @PathVariable String findtype, @PathVariable String findkey) {
        logger.info("board/find 호출!!");

        m.addAttribute("bds", cocsrv.readFindCocktail(cpg, findtype, findkey));
        m.addAttribute("cpg", cpg);
        m.addAttribute("stpg", ((cpg - 1) / 10) * 10 + 1);
        m.addAttribute("fkey", findkey);
        m.addAttribute("ftype", findtype);

        // 만일 , 현재페이지가 총페이지수 보다 크면
        // 1페이지로 강제 이동
        if (cpg > (int) m.getAttribute("cntpg"))
            return "redirect:/board/list/1";

        return "board/list";
    }



}