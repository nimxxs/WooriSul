package hanjan.yeji.boot.woorisul.mybatis;

import hanjan.yeji.boot.woorisul.model.Online;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OnStoreMapper {
/*    int insertOnline(Online on);*/

    List<Online> selectOnline(int stnum);

    int countPageOnline();

    int countAllOnline();

    List<Online> selectFindOnline(Map<String, Object> params);

    int countPageFindOnline(Map<String, Object> params);

    int countFindOnline(Map<String, Object> params);

}
