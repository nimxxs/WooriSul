package hanjan.yeji.boot.woorisul.dao;


import hanjan.yeji.boot.woorisul.model.SulBoard;
import hanjan.yeji.boot.woorisul.mybatis.SulBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("sbdao")
@RequiredArgsConstructor

public class SulBoardDAOImpl implements SulBoardDAO{

  final SulBoardMapper sulBoardMapper;
  @Override
  public int insertSulBoard(SulBoard sb) {
    return sulBoardMapper.insertSulBoard(sb);
  }

  @Override
  public List<SulBoard> selectSulBoard(int stnum) {
    return sulBoardMapper.selectSulBoard(stnum);
  }

  @Override
  public int selectCountSulBoard() {
    return sulBoardMapper.selectCountSulBoard();
  }

  @Override
  public SulBoard selectOneSulBoard(String sno) {

    sulBoardMapper.updateViewSulBoard(sno);

    return sulBoardMapper.selectOneSulBoard(sno);
  }
}
