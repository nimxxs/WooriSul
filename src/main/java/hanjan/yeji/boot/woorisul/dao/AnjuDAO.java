package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.Anju;

import java.util.List;

public interface AnjuDAO {
    int insertAnju(Anju a);
    List<Anju> selectAnju(String kind);

    List<Anju> getAllAnju();
}
