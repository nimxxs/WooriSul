package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.dao.AnjuDAO;
import hanjan.yeji.boot.woorisul.model.Anju;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("asrv")
@RequiredArgsConstructor
public class AnjuServiceImpl implements AnjuService{
    final AnjuDAO adao;

    @Override
    public int insertAnju(Anju a) {
        return adao.insertAnju(a);
    }

    @Override
    public List<Anju> selectAnju(String kind) {
        return adao.selectAnju(kind);
    }

    @Override
    public List<Anju> getAllAnju() {
        return adao.getAllAnju();
    }
}
