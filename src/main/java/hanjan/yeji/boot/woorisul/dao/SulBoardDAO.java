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

  List<SulBoard> selectSul(String kind);

    int totalSulBoard(String kind);

    // 술 검색
    List<SulBoard> searchSul(String sname, String region, Integer cpg);

  // 태그별 리스트(아래 총 3개)
  List<SulBoard> selectSulBoardByTag(String tag, Integer cpg);

  int selectCountSulBoardByTag(String tag);

  int totalSulBoardByTag(String tag);

  int countSearchSul(String sname, String region);
}
