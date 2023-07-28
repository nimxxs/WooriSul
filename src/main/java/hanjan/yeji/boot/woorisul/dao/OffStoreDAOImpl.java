package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.Offline;
import hanjan.yeji.boot.woorisul.mybatis.OffStoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("offdao")
@RequiredArgsConstructor
public class OffStoreDAOImpl implements OffStoreDAO{

    final OffStoreMapper offlineMapper;
/*    @Override
    public int insertOffline(Offline on) {
        return offlineMapper.insertOffline(on);
    }*/

    @Override
    public List<Offline> selectOffline(int stnum) {
        return offlineMapper.selectOffline(stnum);
    }

    @Override
    public Offline selectOneOffline(String ono) {
        return offlineMapper.selectOneOffline(ono);
    }

    @Override
    public int countPageOffline() {
        return offlineMapper.countPageOffline();
    }

    @Override
    public int countAllOffline() {
        return offlineMapper.countAllOffline();
    }

    @Override
    public List<Offline> selectFindOffline(Map<String, Object> params) {
        return offlineMapper.selectFindOffline(params);
    }

    @Override
    public int countPageFindOffline(Map<String, Object> params) {
        return offlineMapper.countPageFindOffline(params);
    }

    @Override
    public int countFindOffline(Map<String, Object> params) {
        return offlineMapper.countFindOffline(params);
    }


}
