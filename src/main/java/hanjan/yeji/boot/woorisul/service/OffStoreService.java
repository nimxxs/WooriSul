package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.model.Offline;

import java.util.List;

public interface OffStoreService {

//    boolean saveOffline(Offline on);

    List<Offline> readOffline(Integer cpg);

    Offline readOneOffline(String ono);

    int countPageOffline();

    int countAllOffline();

    List<Offline> readFindOffline(String ftype, String fkey, Integer cpg);

    int countPageFindOffline(String ftype, String fkey);

    int countFindOffline(String ftype, String fkey);
}
