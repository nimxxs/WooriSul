/*

package hanjan.yeji.boot.woorisul.SulBoard;

import hanjan.yeji.boot.woorisul.model.Brewery;
import hanjan.yeji.boot.woorisul.model.SulBoard;
import hanjan.yeji.boot.woorisul.mybatis.SulBoardMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@MybatisTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
        // 여기 내용이랑 아래 오류가 연관: 내가 쓰는 DB 시스템을 대입시켜라!

public class SulBoardMapperUnitTest {

    @Autowired
    private SulBoardMapper sulBoardMapper;

    @Test
    @DisplayName("sulBoardMapper insert Test")
    @Transactional
    void insertSulBoard() {
        SulBoard sb= new SulBoard();

        sb.setSname("옥수수톡톡");
        sb.setKind("홍주");
        sb.setBase("감[홍시] 30.8%");
        sb.setTag("선물용");

        int result = sulBoardMapper.insertSulBoard(sb);
        //System.out.println(results);
        assertEquals(result, 1);


    }
    @Test
    @DisplayName("sulboardMapper update Test")
    void countPage(){


        int result = sulBoardMapper.selectCountSulBoard();

        assertNotNull(result);
    }

    @Test
    @DisplayName("sulBoardMapper select Test")
    void selectSulBoard() {

       String kind = "all";
       Integer stnum = 1;
       List<SulBoard> result = sulBoardMapper.selectSulBoard(kind, stnum);

       assertNotNull(result);


    }

    @Test
    @DisplayName("sulBoardMapper selectOneSulBoard Test")

    void selectOneSulBoard() {

        String sno = "2";

        SulBoard result = sulBoardMapper.selectOneSulBoard(sno);

        assertNotNull(result);


    }




}
*/
