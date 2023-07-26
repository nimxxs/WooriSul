/*
package hanjan.yeji.boot.woorisul.brewery;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class BreweryControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("BreweryController read Test")
    void readBrewery() throws Exception {
        mvc.perform(get("/brewery/list/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("BreweryController view Test")
    void viewBrewery() throws Exception {
        mvc.perform(get("/brewery/view/1"))
                .andExpect(status().isOk())
                .andDo(print());
    }



}
*/
