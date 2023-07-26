package hanjan.yeji.boot.woorisul.mybatis;

import hanjan.yeji.boot.woorisul.model.Brewery;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BreweryMapper {
    int insertBrewery(Brewery b);

    List<Brewery> selectBrewery(int stnum);

    Brewery selectOneBrewery(String bno);

    int countPageBrewery();

    int countAllBrewery();
}
