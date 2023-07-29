package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.CocAttach;
import hanjan.yeji.boot.woorisul.model.Cocktail;

import java.util.List;
import java.util.Map;

public interface CocktailDAO {
    List<Cocktail> selectCocktail(int stnum);

    int insertCocktail(Cocktail c);

    int insertCocAttach(CocAttach ca);

    Cocktail selectOneCocktail(String cno);

    int selectCountCocktail();

    List<Cocktail> selectFindCocktail(Map<String, Object> params);

    int countPageFindCocktail(Map<String, Object> params);

    int countFindCocktail(Map<String, Object> params);

    int countAllBrewery();
}
