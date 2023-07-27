package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.dao.SulBoardDAO;
import hanjan.yeji.boot.woorisul.model.SulBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("sbsrv")
@RequiredArgsConstructor

public class SulBoardServiceImpl implements SulBoardService {

    final SulBoardDAO sbdao;

    @Override
    public boolean saveSulBoard(SulBoard sb) {
        boolean isSaved= false;

        if(sbdao.insertSulBoard(sb) > 0) isSaved = true;

        return isSaved;
    }


    @Override
    public List<SulBoard> readSulBoard(String kind, Integer cpg) {

        int stnum= (cpg -1) * 5;
        return sbdao.selectSulBoard(kind, stnum);
    }

    @Override
    public int selectCountSulBoard() {
        return sbdao.selectCountSulBoard();
    }

    @Override
    public SulBoard readOneSulBoard(String sno) {
        return sbdao.selectOneSulBoard(sno);
    }

    @Override
    public List<SulBoard> readFindSulBoard(Integer cpg, String sname, String skey) {

        Map<String, Object> params = new HashMap<>();
        params.put("searchKind", sname);    // list.html에서 가져온 select의 id?
        params.put("findkey", skey);
        params.put("stnum", (cpg - 1) * 5);

        return sbdao.selectFindSulBoard(params);
    }

    @Override
    public int countFindSulBoard(String sname, String skey) {
        Map<String, Object> params = new HashMap<>();
        params.put("searchKind", sname);    // list.html에서 가져온 select의 id?
        params.put("findkey", skey);

        return sbdao.countFindSulBoard(params);
    }

    @Override
    public List<SulBoard> selectSul(String kind) {
        return sbdao.selectSul(kind);
    }

}
