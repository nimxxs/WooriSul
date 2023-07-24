package hanjan.yeji.boot.woorisul.mybatis;

import hanjan.yeji.boot.woorisul.model.SulBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SulBoardMapper {

  int insertSulBoard(SulBoard sb);

  List<SulBoard> selectSulBoard(int stnum);

  int selectCountSulBoard();

//  int updateViewSulBoard(String sno);

  SulBoard selectOneSulBoard(String sno);


}