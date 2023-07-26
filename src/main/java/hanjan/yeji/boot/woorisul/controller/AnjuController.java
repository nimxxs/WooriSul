package hanjan.yeji.boot.woorisul.controller;

import hanjan.yeji.boot.woorisul.model.Anju;
import hanjan.yeji.boot.woorisul.service.AnjuService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/anju")
@RequiredArgsConstructor
public class AnjuController {
    final AnjuService asrv;
    Logger logger = LogManager.getLogger(AnjuController.class);


    @GetMapping("/list/{kind}")
    public String anju(Model m, @PathVariable String kind) {
        logger.info("anju 호출!!");

        List<Anju> anjuList;
        if (kind == null || kind.equals("All")) {
            anjuList = asrv.getAllAnju(); // 모든 카테고리 조회 로직
        } else {
            anjuList = asrv.selectAnju(kind); // 선택된 카테고리 조회 로직
        }

        m.addAttribute("ads", anjuList);
        m.addAttribute("kind", kind);

        return "anju/list";
    }

}