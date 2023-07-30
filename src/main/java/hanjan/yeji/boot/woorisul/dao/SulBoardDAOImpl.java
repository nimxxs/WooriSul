package hanjan.yeji.boot.woorisul.dao;


import hanjan.yeji.boot.woorisul.model.SulBoard;
import hanjan.yeji.boot.woorisul.mybatis.SulBoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
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
  public List<SulBoard> selectSul(String kind) {
    return sulBoardMapper.selectSul(kind);
  }

  @Override
  public int totalSulBoard(String kind) {
    return sulBoardMapper.totalSulBoard(kind);
  }

  @Override
  public List<SulBoard> searchSul(String sname, String region, Integer cpg) {
    Map<String, String> params = new HashMap<>();
    params.put("sname", sname);
    params.put("region", region);

    return sulBoardMapper.searchSul(params);
  }

  @Override
  public List<SulBoard> selectSulBoardByTag(String tag, Integer cpg) {
    Map<String, Object> params = new HashMap<>();
    params.put("tag", tag);
    params.put("cpg", cpg);
    return sulBoardMapper.selectSulBoardByTag(params);
  }

  @Override
  public int selectCountSulBoardByTag(String tag) {
    return sulBoardMapper.selectCountSulBoardByTag(tag);
  }

  @Override
  public int totalSulBoardByTag(String tag) {
    return sulBoardMapper.totalSulBoardByTag(tag);
  }

  @Override
  public int countSearchSul(String sname, String region) {
    Map<String, Object> params = new HashMap<>();
    params.put("sname", sname);
    params.put("region", region);
    return sulBoardMapper.countSearchSul(sname, region);
  }
}
