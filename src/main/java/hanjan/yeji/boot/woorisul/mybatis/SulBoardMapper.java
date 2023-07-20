package hanjan.yeji.boot.woorisul.mybatis;

import hanjan.yeji.boot.woorisul.model.SulBoard;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SulBoardMapper {

  int insertSulBoard(SulBoard sb);
}
