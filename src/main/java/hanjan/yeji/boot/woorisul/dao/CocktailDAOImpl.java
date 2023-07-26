package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.CocAttach;
import hanjan.yeji.boot.woorisul.model.Cocktail;
import hanjan.yeji.boot.woorisul.mybatis.CocktailMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("cdao")
public class CocktailDAOImpl implements CocktailDAO{

    @Autowired
    private CocktailMapper cocktailMapper;


    @Override
    public List<Cocktail> selectCocktail(int stnum) {

        return cocktailMapper.selectCocktail(stnum);
    }

    @Override
    public int insertCocktail(Cocktail c) {
        int cnt = cocktailMapper.insertCocktail(c);
        if (cnt > 0) cnt = cocktailMapper.lastCocCno();

        return cnt;
    }

    @Override
    public int insertCocAttach(CocAttach ca) {

        return cocktailMapper.insertCocAttach(ca);
    }

    @Override
    public Cocktail selectOneCocktail(String cno) {

        return cocktailMapper.selectOneCocktail(cno);
    }

    @Override
    public List<Cocktail> selectFindCocktail(Map<String, Object> params) {
        return cocktailMapper.selectFindCocktail(params);
    }

    @Override
    public int selectCountCocktail() {
        return cocktailMapper.selectCountCocktail();
    }


}
