package hanjan.yeji.boot.woorisul.service;

import hanjan.yeji.boot.woorisul.model.Online;

import java.util.List;

public interface OnStoreService {

//    boolean saveOnline(Online on);

    List<Online> readOnline(Integer cpg);

    int countPageOnline();

    int countAllOnline();

    List<Online> readFindOnline(String fontype, String fonkey, Integer cpg);

    int countPageFindOnline(String fontype, String fonkey);

    int countFindOnline(String fontype, String fonkey);
}
