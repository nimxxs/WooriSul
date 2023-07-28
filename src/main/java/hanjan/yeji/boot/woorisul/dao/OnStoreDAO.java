package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.Online;

import java.util.List;
import java.util.Map;

public interface OnStoreDAO {

/*    int insertOnline(Online on);*/

    List<Online> selectOnline(int stnum);

    int countPageOnline();

    int countAllOnline();

    List<Online> selectFindOnline(Map<String, Object> params);

    int countPageFindOnline(Map<String, Object> params);

    int countFindOnline(Map<String, Object> params);

}
