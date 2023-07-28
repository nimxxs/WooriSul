package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.Offline;

import java.util.List;
import java.util.Map;

public interface OffStoreDAO {

/*    int insertOffline(Offline off);*/

    List<Offline> selectOffline(int stnum);

    Offline selectOneOffline(String fno);

    int countPageOffline();

    int countAllOffline();

    List<Offline> selectFindOffline(Map<String, Object> params);

    int countPageFindOffline(Map<String, Object> params);

    int countFindOffline(Map<String, Object> params);

}
