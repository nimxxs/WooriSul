package hanjan.yeji.boot.woorisul.anju;

import hanjan.yeji.boot.woorisul.dao.AnjuDAOImpl;
import hanjan.yeji.boot.woorisul.model.Anju;
import hanjan.yeji.boot.woorisul.service.AnjuService;
import hanjan.yeji.boot.woorisul.service.AnjuServiceImpl;
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
@Import({AnjuServiceImpl.class, AnjuDAOImpl.class})
public class AnjuServiceUnitTest {
    @Autowired
    private AnjuService asrv;

    @Test
    @DisplayName("AnjuService insert Test")
    void readAnju() {
        String kind = "some_value";
        List<Anju> results = asrv.selectAnju(kind);
        assertNotNull(results);
    }

}
