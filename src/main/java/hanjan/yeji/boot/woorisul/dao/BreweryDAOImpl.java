package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.Brewery;
import hanjan.yeji.boot.woorisul.mybatis.BreweryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("bdao")
@RequiredArgsConstructor
public class BreweryDAOImpl implements BreweryDAO{

    final BreweryMapper breweryMapper;
    @Override
    public int insertBrewery(Brewery b) {
        return breweryMapper.insertBrewery(b);
    }

    @Override
    public List<Brewery> selectBrewery(int stnum) {
        return breweryMapper.selectBrewery(stnum);
    }

    @Override
    public Brewery selectOneBrewery(String bno) {
        return breweryMapper.selectOneBrewery(bno);
    }

    @Override
    public int countPageBrewery() {
        return breweryMapper.countPageBrewery();
    }

    @Override
    public int countAllBrewery() {
        return breweryMapper.countAllBrewery();
    }


}
