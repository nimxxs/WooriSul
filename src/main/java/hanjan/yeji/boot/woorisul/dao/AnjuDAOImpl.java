package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.Anju;
import hanjan.yeji.boot.woorisul.mybatis.AnjuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("adao")
public class AnjuDAOImpl implements AnjuDAO{

    @Autowired
    private AnjuMapper anjuMapper;

    @Override
    public List<Anju> selectAnju() {
        return anjuMapper.selectAnju();
    }
}
