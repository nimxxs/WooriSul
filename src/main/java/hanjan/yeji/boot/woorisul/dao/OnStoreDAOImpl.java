package hanjan.yeji.boot.woorisul.dao;

import hanjan.yeji.boot.woorisul.model.Online;
import hanjan.yeji.boot.woorisul.mybatis.OnStoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("odao")
@RequiredArgsConstructor
public class OnStoreDAOImpl implements OnStoreDAO{

    final OnStoreMapper onlineMapper;
/*    @Override
    public int insertOnline(Online on) {
        return onlineMapper.insertOnline(on);
    }*/

    @Override
    public List<Online> selectOnline(int stnum) {
        return onlineMapper.selectOnline(stnum);
    }

    @Override
    public int countPageOnline() {
        return onlineMapper.countPageOnline();
    }

    @Override
    public int countAllOnline() {
        return onlineMapper.countAllOnline();
    }

    @Override
    public List<Online> selectFindOnline(Map<String, Object> params) {
        return onlineMapper.selectFindOnline(params);
    }

    @Override
    public int countPageFindOnline(Map<String, Object> params) {
        return onlineMapper.countPageFindOnline(params);
    }

    @Override
    public int countFindOnline(Map<String, Object> params) {
        return onlineMapper.countFindOnline(params);
    }


}
