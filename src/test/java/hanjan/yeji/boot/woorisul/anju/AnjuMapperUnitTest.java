/*
package hanjan.yeji.boot.woorisul.anju;


import hanjan.yeji.boot.woorisul.model.Anju;
import hanjan.yeji.boot.woorisul.mybatis.AnjuMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AnjuMapperUnitTest {
    @Autowired
    private AnjuMapper anjuMapper;
    @Test
    @DisplayName("AnjuMapper select Test")
    void selectAnju() {
        List<Anju> results = anjuMapper.selectAnju("aname");

        System.out.println(results);
        assertNotNull(results);
    }
}
*/
