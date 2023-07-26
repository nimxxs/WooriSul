package hanjan.yeji.boot.woorisul.mybatis;

import hanjan.yeji.boot.woorisul.model.Brewery;
import hanjan.yeji.boot.woorisul.model.SulBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface SulBoardMapper {

  int insertSulBoard(SulBoard sb);

  List<SulBoard> selectSulBoard(int stnum);

  int selectCountSulBoard();

  SulBoard selectOneSulBoard(String bno);

  List<SulBoard> selectFindSulBoard(Map<String, Object> params);

  int countFindSulBoard(Map<String, Object> params);
}