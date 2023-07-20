package hanjan.yeji.boot.woorisul.dao;


import hanjan.yeji.boot.woorisul.model.SulBoard;
import hanjan.yeji.boot.woorisul.mybatis.SulBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository("sbdao")
@RequiredArgsConstructor

public class SulBoardDAOImpl implements SulBoardDAO{

  final SulBoardMapper sulBoardMapper;
  @Override
  public int insertSulBoard(SulBoard sb) {
    return sulBoardMapper.insertSulBoard(sb);
  }
}
