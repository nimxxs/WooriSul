package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.model.Online;

import java.util.List;

public interface OnStoreService {

//    boolean saveOnline(Online on);

    List<Online> readOnline(Integer cpg);

    int countPageOnline();

    int countAllOnline();

    List<Online> readFindOnline(String ftype, String fkey, Integer cpg);

    int countPageFindOnline(String ftype, String fkey);

    int countFindOnline(String ftype, String fkey);
}
