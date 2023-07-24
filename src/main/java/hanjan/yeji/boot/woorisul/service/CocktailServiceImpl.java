package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.dao.CocktailDAO;
import hanjan.yeji.boot.woorisul.dao.SulBoardDAO;
import hanjan.yeji.boot.woorisul.model.CocAttach;
import hanjan.yeji.boot.woorisul.model.Cocktail;
import hanjan.yeji.boot.woorisul.model.SulBoard;
import hanjan.yeji.boot.woorisul.utils.CocktailUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("cocsrv")
@RequiredArgsConstructor

public class CocktailServiceImpl implements CocktailService {

    final CocktailDAO cdao;
    final CocktailUtils cocUtils;


    @Override
    public List<Cocktail> readCocktail(Integer cpg) {
        return cdao.selectCocktail(cpg - 1);
    }

    @Override
    public int countCocktail() {
        return 0;
    }

    @Override
    public int newCocktail(Cocktail c) {
        return cdao.insertCocktail(c);
    }

    @Override
    public boolean newCocAttach(List<MultipartFile> attachs, int cno) {
        // 이미지 파일 저장후 파일 정보 (들) 받아오기
        CocAttach ca = cocUtils.processUpload(attachs);

        // 썸내일 이미지 생성
        cocUtils.makeThumbnail(ca);

        // 이미지 파일 정보 저장
        ca.setCno(cno + "");

        return (cdao.insertCocAttach(ca) > 0) ? true : false;

        // 업로드한 뒤에 pno를 집어 넣었는데 gal를 썸네일이 들어간후
    }

    @Override
    public Cocktail readOneCocktail(String cno) {
        return cdao.selectOneCocktail(cno);
    }

    @Override
    public List<Cocktail> readFindCocktail(Integer cpg, String ftype, String fkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype",ftype);
        params.put("findkey",fkey);
        params.put("stnum",(cpg - 1) * 9);

        return cdao.selectFindCocktail(params);
    }

    @Override
    public int countFindCocktail(String ftype, String fkey) {
        return 0;
    }
}
