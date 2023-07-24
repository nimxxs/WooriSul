package hanjan.yeji.boot.woorisul.Cocktail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class CocktailControllerUnitTest {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("GalleryController upload Test")
    @Transactional
    void writeok() throws Exception {

        String fpath = "C:/Java/abc123.jpg";
        FileInputStream fis = new FileInputStream(fpath);

        // MkckMultipartFile(폼이름,파일명,MIME,파일객체)
        MockMultipartFile attach = new MockMultipartFile(
                "attachs", "abc123.jpg", "image/png", fis);

        mvc.perform(multipart("/coc/write").file(attach)
                        .param("cname", "자몽이슬")
                        .param("mix", "쉑키")
                        .param("comment", "이것저것")
                        .param("recipe", "이것저것"))
                .andExpect(status().is3xxRedirection()) // 300 확인 요청?
                .andDo(print());
    }

}