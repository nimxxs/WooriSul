package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.dao.OffStoreDAO;
import hanjan.yeji.boot.woorisul.model.Offline;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("offsrv")
@RequiredArgsConstructor
public class OffStoreServiceImpl implements OffStoreService {

    final OffStoreDAO offdao;

/*    @Override
    public boolean saveOffline(Offline b) {
        boolean isSaved = false;
        if(offdao.insertOffline(b) > 0)
            isSaved = true;
        return isSaved;
    }*/

    @Override
    public List<Offline> readOffline(Integer cpg) {
        int stnum = (cpg - 1) * 6;
        return offdao.selectOffline(stnum);
    }

    @Override
    public Offline readOneOffline(String fno) {
        return offdao.selectOneOffline(fno);
    }

    @Override
    public int countPageOffline() {
        return offdao.countPageOffline();
    }

    @Override
    public int countAllOffline() {
        return offdao.countAllOffline();
    }

    @Override
    public List<Offline> readFindOffline(String fofftype, String foffkey, Integer cpg) {
        Map<String, Object> params = new HashMap<>();
        params.put("findofftype", fofftype);
        params.put("findoffkey", foffkey);
        params.put("stnum", (cpg - 1) * 6);
        return offdao.selectFindOffline(params);
    }

    @Override
    public int countPageFindOffline(String fofftype, String foffkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("findofftype", fofftype);
        params.put("findoffkey", foffkey);

        return offdao.countPageFindOffline(params);
    }

    @Override
    public int countFindOffline(String fofftype, String foffkey) {
        Map<String, Object> params = new HashMap<>();
        params.put("findofftype", fofftype);
        params.put("findoffkey", foffkey);

        return offdao.countFindOffline(params);
    }
}
