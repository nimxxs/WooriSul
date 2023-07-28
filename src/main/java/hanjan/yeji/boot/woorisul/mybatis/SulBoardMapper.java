package hanjan.yeji.boot.woorisul.mybatis;

import hanjan.yeji.boot.woorisul.model.Brewery;
import hanjan.yeji.boot.woorisul.model.SulBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SulBoardMapper {

  int insertSulBoard(SulBoard sb);

  List<SulBoard> selectSulBoard(String kind, int stnum);


  int selectCountSulBoard();

  SulBoard selectOneSulBoard(String bno);

  List<SulBoard> selectFindSulBoard(Map<String, Object> params);

  int countFindSulBoard(Map<String, Object> params);

  List<SulBoard> selectSul(String kind);

  List<SulBoard> readSulBoard(String kind, Integer cpg);

  int countAllSul();

  int selectOne(String countByKind, String kind);
}