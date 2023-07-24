package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.Brewery;

import java.util.List;

public interface BreweryDAO {

    int insertBrewery(Brewery b);

    List<Brewery> selectBrewery(int stnum);

    Brewery selectOneBrewery(String bno);

    int selectCountBrewery();
}
