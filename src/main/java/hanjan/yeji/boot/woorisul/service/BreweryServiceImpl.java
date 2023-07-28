package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.dao.BreweryDAO;
import hanjan.yeji.boot.woorisul.model.Brewery;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        int stnum = (cpg - 1) * 4;
        return bdao.selectBrewery(stnum);
    }

    @Override
    public Brewery readOneBrewery(String bno) {
        return bdao.selectOneBrewery(bno);
    }

    @Override
    public int countPageBrewery() {
        return bdao.countPageBrewery();
    }
    @Override
    public int countAllBrewery() {
        return bdao.countAllBrewery();
    }

    @Override
    public List<Brewery> readFindBrewery(String ftype, String fkey, Integer cpg) {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", ftype);
        params.put("findkey", fkey);
        params.put("stnum", (cpg - 1) * 4);
        return bdao.selectFindBrewery(params);
    }

    @Override
    public int countPageFindBrewery(String ftype, String fkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", ftype);
        params.put("findkey", fkey);

        return bdao.countPageFindBrewery(params);
    }

    @Override
    public int countFindBrewery(String ftype, String fkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("findtype", ftype);
        params.put("findkey", fkey);

        return bdao.countFindBrewery(params);
    }
}
