package hanjan.yeji.boot.woorisul.anju;

import hanjan.yeji.boot.woorisul.dao.AnjuDAO;
import hanjan.yeji.boot.woorisul.dao.AnjuDAOImpl;
import hanjan.yeji.boot.woorisul.model.Anju;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Import(AnjuDAOImpl.class)
public class AnjuDAOUnitTest {
    @Autowired
    private AnjuDAO adao;

    @Test
    @DisplayName("AnjuDAO insert Test")
    void selectAnju() {
        List<Anju> results = adao.selectAnju();
        assertNotNull(results);
    }

}
