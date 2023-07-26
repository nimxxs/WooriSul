package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.model.Anju;

import java.util.List;

public interface AnjuService {
    int insertAnju(Anju a);
    List<Anju> selectAnju(String kind);

    List<Anju> getAllAnju();
}
