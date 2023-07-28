package hanjan.yeji.boot.woorisul.mybatis;

import hanjan.yeji.boot.woorisul.model.Offline;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface OffStoreMapper {
/*    int insertOffline(Offline on);*/

    List<Offline> selectOffline(int stnum);

    Offline selectOneOffline(String fno);

    int countPageOffline();

    int countAllOffline();

    List<Offline> selectFindOffline(Map<String, Object> params);

    int countPageFindOffline(Map<String, Object> params);

    int countFindOffline(Map<String, Object> params);

}
