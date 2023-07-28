package hanjan.yeji.boot.woorisul.online;

import hanjan.yeji.boot.woorisul.model.Online;
import hanjan.yeji.boot.woorisul.mybatis.OnStoreMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class OnStoreMapperUnitTest {

    @Autowired private OnStoreMapper onlineMapper;

/*     @Test
    @DisplayName("OnStoreMapper insert Test")
    @Transactional
   void insertOnline(){
        Online b = new Online();
        b.setBrname("양조장");
        b.setAddr("테스트");
        b.setBkind("테스트");
        b.setTel("테스트");
        b.setWaddr("테스트");

        int result = onlineMapper.insertOnline(b);
        assertEquals(result, 1);
    }*/

    @Test
    @DisplayName("OnStoreMapper select Test")
    void selectOnline(){
        int cpg = 1;
        int stnum = (cpg - 1) * 6;
        List<Online> results = onlineMapper.selectOnline(stnum);

        assertNotNull(results);
    }


}
