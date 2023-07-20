package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.SulBoard;

import java.util.List;

public interface SulBoardDAO {

  int insertSulBoard(SulBoard sb);

  List<SulBoard> selectSulBoard(int stnum);

  int selectCountSulBoard();
}
