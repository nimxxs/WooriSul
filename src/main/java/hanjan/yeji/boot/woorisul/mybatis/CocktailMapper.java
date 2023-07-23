package hanjan.yeji.boot.woorisul.mybatis;

import hanjan.yeji.boot.woorisul.model.CocAttach;
import hanjan.yeji.boot.woorisul.model.Cocktail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CocktailMapper {
    int insertCocktail(Cocktail c);

    int insertCocAttach(CocAttach ca);

    List<Cocktail> selectCocktail(int stnum);

    Cocktail selectOneCocktail(String cno);

    int selectCountCocktail();

    CocAttach selectOneGalleryAttach(String cno);

    int lastCocCno();

//    int insertPdsComment(PdsComment pc);
//
//    List<PdsComment> selectPdsComment(String pno);
//
//    int insertPdsReply(PdsComment pc);

    /*int updateViewPds(String bno);
    List<Pds> selectFindPds(Map<String, Object> params);
    int countFindPds(Map<String, Object> params);*/


}
