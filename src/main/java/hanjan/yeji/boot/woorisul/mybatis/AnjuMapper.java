package hanjan.yeji.boot.woorisul.mybatis;

import hanjan.yeji.boot.woorisul.model.Anju;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface AnjuMapper {
    int insertAnju(Anju a);
    List<Anju> selectAnju();
}
