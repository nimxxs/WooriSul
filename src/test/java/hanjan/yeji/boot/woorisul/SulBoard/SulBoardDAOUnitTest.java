package hanjan.yeji.boot.woorisul.SulBoard;


import hanjan.yeji.boot.woorisul.controller.SulBoardController;
import hanjan.yeji.boot.woorisul.dao.SulBoardDAO;
import hanjan.yeji.boot.woorisul.dao.SulBoardDAOImpl;
import hanjan.yeji.boot.woorisul.model.SulBoard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
        // 여기 내용이랑 아래 오류가 연관: 내가 쓰는 DB 시스템을 대입시켜라!
@Import(SulBoardDAOImpl.class)
// 아래 Autowired로 MemberDAO 내용을 데려와야하는데 못데려와서 위 import를 다시 해줌

public class SulBoardDAOUnitTest {

    @Autowired
    private SulBoardDAO sbdao;

    @Test
    @DisplayName("sulBoardDAO insert Test")
    @Transactional
    void insertSulBoard() {
        SulBoard sb= new SulBoard();

        sb.setSname("옥수수톡탁");
        sb.setKind("홍주");
        sb.setBase("감[홍시] 30.8%");
        sb.setTag("선물용");

        int result = sbdao.insertSulBoard(sb);
        //System.out.println(results);
        assertEquals(result, 1);


    }

    @Test
    @DisplayName("SulBoardDAO selectOne Test")
    void selectOneSulBoard() {
        String sno = "12";

        SulBoard result = sbdao.selectOneSulBoard(sno);

        // System.out.println(results);
        assertNotNull(result);


    }



}
