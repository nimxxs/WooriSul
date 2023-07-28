package hanjan.yeji.boot.woorisul.sulBoard;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc

public class SulBoardControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("SulBoardController read Test")

    void readSulBoard() throws Exception {


        mvc.perform(get("/drink/list/1"))

                .andExpect(status().isOk())
                .andDo(print());

    }

    @Test
    @DisplayName("SulBoardController detail Test")

    void detail() throws Exception {


        mvc.perform(get("/drink/detail/1"))

                .andExpect(status().isOk())
                .andDo(print());

    }

//    @Test
//    @DisplayName("SulBoardController category Test")
//
//    void category() throws Exception {
//
//        mvc.perform(get("/drink/category/탁주"))
//
//                .andExpect(status().isOk())
//                .andDo(print());
//
//    }




}
