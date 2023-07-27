package hanjan.yeji.boot.woorisul.mybatis;

import hanjan.yeji.boot.woorisul.model.Brewery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface BreweryMapper {
    int insertBrewery(Brewery b);

    List<Brewery> selectBrewery(int stnum);

    Brewery selectOneBrewery(String bno);

    int countPageBrewery();

    int countAllBrewery();

    List<Brewery> selectFindBrewery(Map<String, Object> params);

    int countPageFindBrewery(Map<String, Object> params);
    int countFindBrewery(Map<String, Object> params);

}
