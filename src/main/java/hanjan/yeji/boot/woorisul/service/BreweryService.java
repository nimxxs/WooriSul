package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.model.Brewery;

import java.util.List;
import java.util.Map;

public interface BreweryService {

//    boolean saveBrewery(Brewery b);

    List<Brewery> readBrewery(Integer cpg);

    Brewery readOneBrewery(String bno);

    int countPageBrewery();

    int countAllBrewery();

    List<Brewery> readFindBrewery(String fbrtype, String fbrkey, Integer cpg);

    int countPageFindBrewery(String fbrtype, String fbrkey);

    int countFindBrewery(String fbrtype, String fbrkey);
}
