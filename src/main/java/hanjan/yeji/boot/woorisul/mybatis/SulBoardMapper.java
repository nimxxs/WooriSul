package hanjan.yeji.boot.woorisul.mybatis;

import hanjan.yeji.boot.woorisul.model.SulBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SulBoardMapper {

  int insertSulBoard(SulBoard sb);

  List<SulBoard> selectSulBoard(String kind, int stnum);


  int selectCountSulBoard(String kind);

  SulBoard selectOneSulBoard(String bno);

  List<SulBoard> selectSul(String kind);

  int totalSulBoard(String kind);

  List<SulBoard> searchSul(Map<String, String> params);

  List<SulBoard> selectSulBoardByTag(Map<String, Object> params);

  int selectCountSulBoardByTag(String tag);

  int totalSulBoardByTag(String tag);

  int countSearchSul(String sname, String region);

  //  술 검색 시 페이징

}