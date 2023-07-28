package hanjan.yeji.boot.woorisul.dao;


import hanjan.yeji.boot.woorisul.model.SulBoard;
import hanjan.yeji.boot.woorisul.mybatis.SulBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("sbdao")
@RequiredArgsConstructor

public class SulBoardDAOImpl implements SulBoardDAO {

  final SulBoardMapper sulBoardMapper;
  @Override
  public int insertSulBoard(SulBoard sb) {
    return sulBoardMapper.insertSulBoard(sb);
  }

  @Override
  public List<SulBoard> selectSulBoard(String kind, int stnum) {
    return sulBoardMapper.selectSulBoard(kind, stnum);
  }

  @Override
  public int selectCountSulBoard(String kind) {
    return sulBoardMapper.selectCountSulBoard(kind);
  }

  @Override
  public SulBoard selectOneSulBoard(String sno) {

    return sulBoardMapper.selectOneSulBoard(sno);
  }

  @Override
  public List<SulBoard> selectFindSulBoard(Map<String, Object> params) {
      return sulBoardMapper.selectFindSulBoard(params);
  }

  @Override
  public int countFindSulBoard(Map<String, Object> params) {
    return sulBoardMapper.countFindSulBoard(params);
  }

  @Override
  public List<SulBoard> selectSul(String kind) {
    return sulBoardMapper.selectSul(kind);
  }

  @Override
  public int totalSulBoard(String kind) {
    return sulBoardMapper.totalSulBoard(kind);
  }


}
