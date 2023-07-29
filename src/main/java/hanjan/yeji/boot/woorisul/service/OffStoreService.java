package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.model.Offline;

import java.util.List;

public interface OffStoreService {

//    boolean saveOffline(Offline on);

    List<Offline> readOffline(Integer cpg);

    Offline readOneOffline(String fno);

    int countPageOffline();

    int countAllOffline();

    List<Offline> readFindOffline(String fofftype, String foffkey, Integer cpg);

    int countPageFindOffline(String fofftype, String foffkey);

    int countFindOffline(String fofftype, String foffkey);
}
