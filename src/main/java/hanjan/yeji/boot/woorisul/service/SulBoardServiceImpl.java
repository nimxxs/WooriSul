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
    public SulBoard readOneSulBoard(String sno) {
        return sbdao.selectOneSulBoard(sno);
    }


    @Override
    public int totalSulBoard(String kind) {
        return sbdao.totalSulBoard(kind);
    }


    @Override
    public List<SulBoard> searchSul(String sname, String region, Integer cpg) {
        return sbdao.searchSul(sname, region, cpg);
    }
    // 태그별 리스트(아래 총 3개)
    @Override
    public List<SulBoard> readSulBoardByTag(String tag, Integer cpg) {
        int stnum = (cpg - 1) * 3;
        return sbdao.selectSulBoardByTag(tag, stnum);
    }

    @Override
    public int selectCountSulBoardByTag(String tag) {
        return sbdao.selectCountSulBoardByTag(tag);
    }

    @Override
    public int totalSulBoardByTag(String tag) {
        return sbdao.totalSulBoardByTag(tag);
    }


    @Override
    public int countSearchSul(String sname, String region) {
        return sbdao.countSearchSul(sname, region);
    }

}
