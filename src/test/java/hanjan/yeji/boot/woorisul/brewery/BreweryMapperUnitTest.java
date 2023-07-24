package hanjan.yeji.boot.woorisul.brewery;

import hanjan.yeji.boot.woorisul.model.Brewery;
import hanjan.yeji.boot.woorisul.mybatis.BreweryMapper;
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
public class BreweryMapperUnitTest {

    @Autowired private BreweryMapper breweryMapper;

    @Test
    @DisplayName("BreweryMapper insert Test")
    @Transactional
    void insertBrewery(){
        Brewery b = new Brewery();
        b.setBrname("양조장");
        b.setAddr("테스트");
        b.setKind("테스트");
        b.setTel("테스트");
        b.setWaddr("테스트");

        int result = breweryMapper.insertBrewery(b);
        assertEquals(result, 1);
    }

    @Test
    @DisplayName("BreweryMapper select Test")
    void selectBrewery(){
        int cpg = 1;
        int stnum = (cpg - 1) * 5;
        List<Brewery> results = breweryMapper.selectBrewery(stnum);

        assertNotNull(results);
    }

    @Test
    @DisplayName("BreweryMapper selectOne Test")
    void selectOneBrewery(){
        String bno="1";
        Brewery result = breweryMapper.selectOneBrewery(bno);

        assertNotNull(result);
    }

}
