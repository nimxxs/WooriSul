package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.model.SulBoard;

import java.util.List;

public interface SulBoardService {

    boolean saveSulBoard(SulBoard sb);

    List<SulBoard> readSulBoard(String kind, Integer cpg);

    int selectCountSulBoard(String kind);

    SulBoard readOneSulBoard(String sno);

    List<SulBoard> selectSul(String kind);

    int totalSulBoard(String kind);

    List<SulBoard> searchSul(String sname, String region);

    //태그별 리스트
    List<SulBoard> readSulBoardByTag(String tag, Integer cpg);

    int selectCountSulBoardByTag(String tag);

    int totalSulBoardByTag(String tag);
}
