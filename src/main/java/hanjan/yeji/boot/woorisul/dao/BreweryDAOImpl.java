package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.Brewery;
import hanjan.yeji.boot.woorisul.mybatis.BreweryMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("bdao")
@RequiredArgsConstructor
public class BreweryDAOImpl implements BreweryDAO{

    final BreweryMapper breweryMapper;
/*    @Override
    public int insertBrewery(Brewery b) {
        return breweryMapper.insertBrewery(b);
    }*/

    @Override
    public List<Brewery> selectBrewery(int stnum) {
        return breweryMapper.selectBrewery(stnum);
    }

    @Override
    public Brewery selectOneBrewery(String bno) {

        breweryMapper.updateViewBrewery(bno);

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

    @Override
    public List<Brewery> selectFindBrewery(Map<String, Object> params) {
        return breweryMapper.selectFindBrewery(params);
    }

    @Override
    public int countPageFindBrewery(Map<String, Object> params) {
        return breweryMapper.countPageFindBrewery(params);
    }

    @Override
    public int countFindBrewery(Map<String, Object> params) {
        return breweryMapper.countFindBrewery(params);
    }


}
