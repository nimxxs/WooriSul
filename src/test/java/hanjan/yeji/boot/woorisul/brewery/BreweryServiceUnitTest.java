package hanjan.yeji.boot.woorisul.brewery;

import hanjan.yeji.boot.woorisul.dao.BreweryDAOImpl;
import hanjan.yeji.boot.woorisul.model.Brewery;
import hanjan.yeji.boot.woorisul.service.BreweryService;
import hanjan.yeji.boot.woorisul.service.BreweryServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)  /*자동으로 h2 데이터베이스를 사용하려고함. 내가 쓰는 데이터베이스로 조정해야함. replace속성으로*/
@Import({BreweryServiceImpl.class, BreweryDAOImpl.class})
public class BreweryServiceUnitTest {

    @Autowired private BreweryService bsrv;

    @Test
    @DisplayName("BreweryService save Test")
    void saveBrewery(){
        Brewery b = new Brewery();
        b.setBrname("양조장");
        b.setAddr("테스트");
        b.setBkind("테스트");
        b.setTel("테스트");
        b.setWaddr("테스트");

        boolean result = bsrv.saveBrewery(b);

        //System.out.println(results);
        assertEquals(result, true);
    }

    @Test
    @DisplayName("BreweryService read Test")
    void readBrewery(){
        int cpg=1;
        List<Brewery> results = bsrv.readBrewery(cpg);

        //System.out.println(results);
        assertNotNull(results);
    }

    @Test
    @DisplayName("BreweryService readOne Test")
    void readOneBrewery(){
        String bno ="1";

        Brewery result = bsrv.readOneBrewery(bno);
        assertNotNull(result);
    }

    @Test
    @DisplayName("BreweryService count Test")
    void countBrewery(){
        int result = bsrv.countBrewery();

        assertNotNull(result);
    }



}
