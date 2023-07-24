package hanjan.yeji.boot.woorisul.SulBoard;


import hanjan.yeji.boot.woorisul.dao.SulBoardDAOImpl;
import hanjan.yeji.boot.woorisul.model.SulBoard;
import hanjan.yeji.boot.woorisul.service.SulBoardService;
import hanjan.yeji.boot.woorisul.service.SulBoardServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
        // 여기 내용이랑 아래 오류가 연관: 내가 쓰는 DB 시스템을 대입시켜라!
@Import({SulBoardServiceImpl.class, SulBoardDAOImpl.class})
// 아래 Autowired로 MemberDAO 내용을 데려와야하는데 못데려와서 위 import를 다시 해줌

public class SulBoardServiceUnitTest {

    @Autowired
    private SulBoardService sbsrv;


    @Test
    @DisplayName("sulboardService save Test")
    @Transactional
    void saveSulBoard() {
        SulBoard sb= new SulBoard();

        sb.setSname("옥수수톡톡");
        sb.setKind("홍주");
        sb.setBase("감[홍시] 30.8%");
        sb.setTag("선물용");


        boolean result = sbsrv.saveSulBoard(sb);
        //System.out.println(results);
        assertEquals(result, true);


    }

    @Test
    @DisplayName("SulBoardService read Test")
    void readSulBoard() {

        int cpg=1;

        List<SulBoard> results = sbsrv.readSulBoard(cpg);
        //System.out.println(results);
        assertNotNull(results);


    }

}
