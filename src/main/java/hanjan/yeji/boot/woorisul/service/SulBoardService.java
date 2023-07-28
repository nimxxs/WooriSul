package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.model.SulBoard;

import java.util.List;

public interface SulBoardService {

    boolean saveSulBoard(SulBoard sb);

    List<SulBoard> readSulBoard(String kind, Integer cpg);

    int selectCountSulBoard(String kind);


    SulBoard readOneSulBoard(String sno);

    List<SulBoard> readFindSulBoard(Integer cpg, String sname, String skey);

    int countFindSulBoard(String sname, String skey);


    List<SulBoard> selectSul(String kind);

    int totalSulBoard(String kind);

}
