package hanjan.yeji.boot.woorisul.utils;

import hanjan.yeji.boot.woorisul.model.CocAttach;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.imgscalr.Scalr;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class CocktailUtils {
    Logger logger = LogManager.getLogger(CocktailUtils.class);
    //첨부파일 저장위치
    @Value("${saveImgDir}") private String saveImgDir;

    public CocAttach processUpload(List<MultipartFile> attachs)  {
        // 이미지 첨부파일명과 크기는 먼저 리스트에 저장한 뒤
        // 나중에 문자열로 취합해서 저장
        CocAttach ca = new CocAttach();
        List<String> fnames = new ArrayList<>();
        List<String> fsizes = new ArrayList<>();

        // 첨부된 이미지 파일들에 대한 반복 처리
        for (MultipartFile attach : attachs) {
            // 업로드할 파일 정보 알아내기 - 첨부파일명
            String fname = makeUUID() + attach.getOriginalFilename();

            // 업로드할 파일 정보 알아내기 - 파일 크기
            String fsize = attach.getSize() / 1024 + "";

            // 첨부파일을 지정한 위치에 저장
            String savepath = saveImgDir + fname;

            try {
                attach.transferTo(new File(savepath));

                // 첨부파일 정보를 리스트에 저장
                fnames.add(fname);
                fsizes.add(fsize);
            } catch (IOException e) {
                logger.error("첨부파일 처리중 오류발생!!");
                e.printStackTrace();
            }
        }   //for

        // 수집된 첨부파일 정보를 ga에 저장
        // join(구분자, 리스트) => 요소1;요소2;요소3
        ca.setFname(String.join(";", fnames));
        ca.setFsize(String.join(";", fsizes));

        return ca;
    }

    private String makeUUID() {
        String uuid = LocalDate.now() + "" + LocalTime.now();
        uuid = uuid.replace("-","")
                .replace(":","")
                .replace(".","");
        return uuid;
    }


    public void makeThumbnail(CocAttach ca) {
        // 업로드된 이미지들 중 첫번째 이미지에 대한 썸내일 생성
        // 파일이름들을 ; 로 나눈후 첫번째 파일명만 추출
        String basename = ca.getFname().split(";")[0];

        // 업로드된 첫번째 이미지 파일 경로 설정
        String refname = saveImgDir + basename;

        // 썸내일 이미지 경로 설정
        // 원본 : abc123.jpg
        // 썸내일 : small_abc123.jpg
       /* String thumbname = saveImgDir + basename;*/

        // 썸내일 작업 진행






    }
}
