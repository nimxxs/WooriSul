package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.SulBoard;

import java.util.List;
import java.util.Map;

public interface SulBoardDAO {

  int insertSulBoard(SulBoard sb);

//  List<SulBoard> readSulBoard(String kind, Integer cpg);

  List<SulBoard> selectSulBoard(String kind, int stnum);

  int selectCountSulBoard(String kind);

  SulBoard selectOneSulBoard(String sno);

   List<SulBoard> selectFindSulBoard(Map<String, Object> params);

  int countFindSulBoard(Map<String, Object> params);

  List<SulBoard> selectSul(String kind);

    int totalSulBoard(String kind);

}
