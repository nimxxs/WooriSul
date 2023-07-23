package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.CocAttach;
import hanjan.yeji.boot.woorisul.model.Cocktail;

import java.util.List;

public interface CocktailDAO {
    List<Cocktail> selectCocktail(int stnum);

    int insertCocktail(Cocktail c);

    int insertCocAttach(CocAttach ca);

    Cocktail selectOneCocktail(String cno);
}
