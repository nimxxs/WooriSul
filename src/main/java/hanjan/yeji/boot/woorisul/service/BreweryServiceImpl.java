package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.dao.BreweryDAO;
import hanjan.yeji.boot.woorisul.model.Brewery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bsrv")
@RequiredArgsConstructor
public class BreweryServiceImpl implements BreweryService{

    final BreweryDAO bdao;

    @Override
    public boolean saveBrewery(Brewery b) {
        boolean isSaved = false;
        if(bdao.insertBrewery(b) > 0)
            isSaved = true;
        return isSaved;
    }

    @Override
    public List<Brewery> readBrewery(Integer cpg) {
        int stnum = (cpg - 1) * 5;
        return bdao.selectBrewery(stnum);
    }

    @Override
    public Brewery readOneBrewery(String bno) {
        return bdao.selectOneBrewery(bno);
    }

    @Override
    public int countBrewery() {
        return bdao.selectCountBrewery();
    }
}
