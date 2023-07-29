package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.dao.OnStoreDAO;
import hanjan.yeji.boot.woorisul.model.Online;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("osrv")
@RequiredArgsConstructor
public class OnStoreServiceImpl implements OnStoreService {

    final OnStoreDAO odao;

/*    @Override
    public boolean saveOnline(Online b) {
        boolean isSaved = false;
        if(odao.insertOnline(b) > 0)
            isSaved = true;
        return isSaved;
    }*/

    @Override
    public List<Online> readOnline(Integer cpg) {
        int stnum = (cpg - 1) * 6;
        return odao.selectOnline(stnum);
    }

    @Override
    public int countPageOnline() {
        return odao.countPageOnline();
    }

    @Override
    public int countAllOnline() {
        return odao.countAllOnline();
    }

    @Override
    public List<Online> readFindOnline(String fontype, String fonkey, Integer cpg) {
        Map<String, Object> params = new HashMap<>();
        params.put("findontype", fontype);
        params.put("findonkey", fonkey);
        params.put("stnum", (cpg - 1) * 6);
        return odao.selectFindOnline(params);
    }

    @Override
    public int countPageFindOnline(String fontype, String fonkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("findontype", fontype);
        params.put("findonkey", fonkey);

        return odao.countPageFindOnline(params);
    }

    @Override
    public int countFindOnline(String fontype, String fonkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("findontype", fontype);
        params.put("findonkey", fonkey);

        return odao.countFindOnline(params);
    }
}
