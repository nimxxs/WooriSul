package hanjan.yeji.boot.woorisul.mybatis;

import hanjan.yeji.boot.woorisul.model.SulBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SulBoardMapper {

  int insertSulBoard(SulBoard sb);

  List<SulBoard> selectSulBoard(String kind, int stnum);


  int selectCountSulBoard(String kind);

  SulBoard selectOneSulBoard(String bno);

  List<SulBoard> selectFindSulBoard(Map<String, Object> params);

  int countFindSulBoard(Map<String, Object> params);

  List<SulBoard> selectSul(String kind);

    int totalSulBoard(String kind);

}